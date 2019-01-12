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

public class Hinconductedexams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinconductedexams);
    }
    public void hinmathsecon(View view){
        Intent i=new Intent(Hinconductedexams.this,Hinmathematicsexamsconducted.class);
        startActivity(i);
    }
    public void hinbiologyecun(View view){
        Intent i=new Intent(Hinconductedexams.this,Hinbiologyexamsconducted.class);
        startActivity(i);
    }
    public void hincommerceecun(View view){
        Intent i=new Intent(Hinconductedexams.this,Hincommerceexamsconducted.class);
        startActivity(i);
    }
    public void hinartsecun(View view){
        Intent i=new Intent(Hinconductedexams.this,Hinartsexamsconducted.class);
        startActivity(i);
    }

}