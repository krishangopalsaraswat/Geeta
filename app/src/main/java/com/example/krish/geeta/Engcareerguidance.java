package com.example.krish.geeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Engcareerguidance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engcareerguidance);
    }
    public void engcgmaths(View view){
        Intent i=new Intent(Engcareerguidance.this,Engcgmaths.class);
        startActivity(i);
    }
    public void engcgbiology(View view){
        Intent i=new Intent(Engcareerguidance.this,Engcgbiology.class);
        startActivity(i);
    }
    public void engcgcommerce(View view){
        Intent i=new Intent(Engcareerguidance.this,Engcgcommerce.class);
        startActivity(i);
    }
    public void engcgarts(View view){
        Intent i=new Intent(Engcareerguidance.this,Engcgarts.class);
        startActivity(i);
    }
}
