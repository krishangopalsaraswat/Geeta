package com.example.krish.geeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Contactus extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        textView=(TextView)findViewById(R.id.text1);
        String pars="M.Sc.,PhD.\n" +"Assistant Professor\n" +
                "Information Technology\n" +
                "Institute of Technology\n"+ "Guru Ghasidas Vishwavidyalaya\n"+"Biaspur C.G\n"+"Mobile: 9425280380\n"+"e-mail: khasamit@gmail.com\n";                ;
        textView.setText(pars);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}