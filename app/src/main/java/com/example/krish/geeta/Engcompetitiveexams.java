package com.example.krish.geeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Engcompetitiveexams extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engcompetitiveexams);
    }
    public void engcemaths(View view){
        Intent i=new Intent(Engcompetitiveexams.this,Engcemaths.class);
        startActivity(i);
    }
    public void engcebiology(View view){
        Intent i=new Intent(Engcompetitiveexams.this,Engcebiology.class);
        startActivity(i);
    }
    public void engcecommerce(View view){
        Intent i=new Intent(Engcompetitiveexams.this,Engcecommerce.class);
        startActivity(i);
    }
    public void engcearts(View view){
        Intent i=new Intent(Engcompetitiveexams.this,Engcearts.class);
        startActivity(i);
    }
}
