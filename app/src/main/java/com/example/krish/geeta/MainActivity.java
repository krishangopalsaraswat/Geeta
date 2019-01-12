package com.example.krish.geeta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button button;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.mainprogressbar);
        database = FirebaseDatabase.getInstance();
        button = (Button) findViewById(R.id.register);
        /*SharedPreferences sp = getSharedPreferences("abc", 0);
        SharedPreferences.Editor ed = sp.edit();

        int x = sp.getInt("x", 0);
        if (x == 0) {
            x++;
            ed.putInt("x", x);
            ed.commit();
        } else {
            //Intent i = new Intent(MainActivity.this, Splashscreen.class);
            //startActivity(i);
            //finish();

        }*/
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            showStartDialog();
        }
        else{
            Intent i = new Intent(MainActivity.this, Splashscreen.class);
            startActivity(i);
            finish();
        }
    }

    private void showStartDialog() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                EditText editTextName = (EditText) findViewById(R.id.Name);
                EditText editTextmobile = (EditText) findViewById(R.id.Mobile);
                EditText editTextcurrentlocation = (EditText) findViewById(R.id.Currentlocation);
                EditText editTextstudyingin = (EditText) findViewById(R.id.Studyingin);
                EditText editTextpreaperingfor = (EditText) findViewById(R.id.Preaperingfor);
                String child = editTextName.getText().toString();
                myRef = database.getReference("Users").child(child);
                myRef.child("Name").setValue(editTextName.getText().toString());
                if (editTextName.length() == 0) {

                    Toast.makeText(MainActivity.this, "Name field must be filled", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Mobile").setValue(editTextmobile.getText().toString());
                if (editTextmobile.length() < 10 || editTextmobile.length()>=11) {
                    editTextmobile.setError("Enter valid number");
                    Toast.makeText(MainActivity.this, "Please Enter valid Number", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Location").setValue(editTextcurrentlocation.getText().toString());
                if (editTextcurrentlocation.length() == 0) {
                   editTextcurrentlocation.setError("Ex. Lucknow , UP");
                    Toast.makeText(MainActivity.this, "Please enter valid location", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                myRef.child("Preapering").setValue(editTextpreaperingfor.getText().toString());
                if (editTextpreaperingfor.length() == 0) {
                    editTextpreaperingfor.setError("Ex. Medical, Engineering");
                    progressBar.setVisibility(View.GONE);

                    return;
                }
                myRef.child("Class").setValue(editTextstudyingin.getText().toString());
                if (editTextstudyingin.length() == 0) {
                    editTextstudyingin.setError("Ex. 12 class");

                    progressBar.setVisibility(View.GONE);
                    return;
                }



                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("firstStart", false);
                editor.apply();
                Intent i = new Intent(MainActivity.this, Splashscreen.class);
                startActivity(i);
                finish();
            }

        });
        progressBar.setVisibility(View.GONE);
    }
}