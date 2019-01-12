package com.example.krish.geeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Bookdonationthnx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdonationthnx);
    }
    public void openbooksdonation(View view){
        Intent i=new Intent(Bookdonationthnx.this,Engscholarships.class);
        startActivity(i);
    }
}
