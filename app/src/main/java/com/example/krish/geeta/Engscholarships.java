package com.example.krish.geeta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Engscholarships extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engscholarships);
        progressBar = (ProgressBar) findViewById(R.id.engscholarshipsprogressbar);
        database = FirebaseDatabase.getInstance();
        button = (Button) findViewById(R.id.engscbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                EditText editTextName = (EditText) findViewById(R.id.scedusername);
                EditText editTextPhone = (EditText) findViewById(R.id.sceduserphonee);
                EditText editTextbook = (EditText) findViewById(R.id.scedbook);
                EditText editTextaddress = (EditText) findViewById(R.id.scedaddress);

                String child = editTextName.getText().toString();
                myRef = database.getReference("Book donation").child(child);

                myRef.child("Name").setValue(editTextName.getText().toString());
                if (editTextName.length() == 0) {
                    Toast.makeText(Engscholarships.this, "Name field must be filled", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Phone Number").setValue(editTextPhone.getText().toString());
                if (editTextPhone.length() == 0 || editTextPhone.length()<10 || editTextPhone.length()>10) {

                    Toast.makeText(Engscholarships.this, "Mobile Number is not valid!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Book Details").setValue(editTextbook.getText().toString());

                if (editTextbook.length()==0) {

                    Toast.makeText(Engscholarships.this, "Please Enter valid book detail", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Address").setValue(editTextaddress.getText().toString());

                if (editTextaddress.length() == 0) {
                    editTextaddress.setError("Ex. Lucknow , UP");
                    //Toast.makeText(Engscholarships.this, "Please enter valid location", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                Intent i = new Intent(Engscholarships.this, Thnxfordonation.class);
                startActivity(i);
finish();
            }

        });
        progressBar.setVisibility(View.GONE);
    }
}