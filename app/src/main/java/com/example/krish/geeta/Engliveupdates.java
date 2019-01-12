package com.example.krish.geeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Engliveupdates extends AppCompatActivity {
    private WebView web_view;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference reference=firebaseDatabase.getReference();
    private DatabaseReference childRefrence=reference.child("English liveupdates website");
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engliveupdates);
        progressBar=(ProgressBar)findViewById(R.id.signupprogressbar);
        web_view=findViewById(R.id.engliveupdates);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient());
        web_view.getSettings().setLoadWithOverviewMode(true);
        web_view.getSettings().setUseWideViewPort(true);
        web_view.getSettings().setBuiltInZoomControls(true);
    }
    /*public void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        childRefrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.GONE);
                String message=dataSnapshot.getValue(String.class);
                web_view.loadUrl(message);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(web_view.canGoBack()){
            web_view.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.engliveupdatesmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.engadmissionmenu) {
           Intent intent=new Intent(Engliveupdates.this,Engadmission.class);
            startActivity(intent);
            return true;

        }
        if (id == R.id.engresultmenu) {
            Intent intent=new Intent(Engliveupdates.this,Engresult.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.engadmitcardmenu) {
            Intent intent=new Intent(Engliveupdates.this,Engadmitcard.class);
            startActivity(intent);
            return true;
        }

        return true;
    }
}