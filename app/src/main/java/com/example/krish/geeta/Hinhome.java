package com.example.krish.geeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Hinhome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hinhome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hinhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.hinnotifications) {
            Intent i=new Intent(Hinhome.this,Hinnotifications.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.live_updates) {
            Intent i=new Intent(Hinhome.this,Hinliveupdates.class);
            startActivity(i);

        } else if (id == R.id.online_study) {
            Intent i=new Intent(Hinhome.this,Hinonlinestudy.class);
            startActivity(i);

        } else if (id == R.id.exam_tips) {
            Intent i=new Intent(Hinhome.this,Hinexamtips.class);
            startActivity(i);

        } else if (id == R.id.personality_test) {
            Intent i=new Intent(Hinhome.this,Hinpersonalitytest.class);
            startActivity(i);

        } else if (id == R.id.contact_us) {
            Intent i=new Intent(Hinhome.this,Contactus.class);
            startActivity(i);

        }
        else if (id == R.id.switchlanguage) {
            Intent i=new Intent(Hinhome.this,Enghome.class);
            startActivity(i);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void hineducationloan(View view){
        Intent i=new Intent(Hinhome.this,Hineducationloan.class);
        startActivity(i);
    }
    public void hinscholarships(View view){
        Intent i=new Intent(Hinhome.this,Hinscholarships.class);
        startActivity(i);
    }
    public void hindistanceeducation(View view){
        Intent i=new Intent(Hinhome.this,Hindistanceeducation.class);
        startActivity(i);
    }
    public void hinstudyabroad(View view){
        Intent i=new Intent(Hinhome.this,Hinstudyabroad.class);
        startActivity(i);
    }
    public void hincareer(View view){
        Intent i=new Intent(Hinhome.this,Hincareer.class);
        startActivity(i);
    }
    public void hinconductedexams(View view){
        Intent i=new Intent(Hinhome.this,Hinconductedexams.class);
        startActivity(i);
    }
}
