package com.example.krish.geeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hincareer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hincareer);
    }
    public void hinmathscareer(View view){
        Intent i=new Intent(Hincareer.this,Hinmathematicscareer.class);
        startActivity(i);
    }
    public void hinbiologycareer(View view){
        Intent i=new Intent(Hincareer.this,Hinbiologycareer.class);
        startActivity(i);
    }
    public void hincommercecareer(View view){
        Intent i=new Intent(Hincareer.this,Hincommercecareer.class);
        startActivity(i);
    }
    public void hinartscareer(View view){
        Intent i=new Intent(Hincareer.this,Hinartscareer.class);
        startActivity(i);
    }
}