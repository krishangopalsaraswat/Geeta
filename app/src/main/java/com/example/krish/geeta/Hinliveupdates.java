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

public class Hinliveupdates extends AppCompatActivity {
    private WebView web_view;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference reference=firebaseDatabase.getReference();
    private DatabaseReference childRefrence=reference.child("Hindi liveupdates website");
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinliveupdates);
        progressBar=(ProgressBar)findViewById(R.id.hinliveupdatesrogressbar);
        web_view=findViewById(R.id.hinliveupdates);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient());
        web_view.getSettings().setLoadWithOverviewMode(true);
        web_view.getSettings().setUseWideViewPort(true);
        web_view.getSettings().setBuiltInZoomControls(true);
    }
    public void setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }

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
        getMenuInflater().inflate(R.menu.hinliveupdatesmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.hinadmissionmenu) {
           Intent intent=new Intent(Hinliveupdates.this,Hinadmission.class);
            startActivity(intent);
            return true;

        }
        if (id == R.id.hinresultmenu) {
            Intent intent=new Intent(Hinliveupdates.this,Hinresult.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.hinadmitcardmenu) {
            Intent intent=new Intent(Hinliveupdates.this,Hinadmitcard.class);
            startActivity(intent);
            return true;
        }

        return true;
    }
}

