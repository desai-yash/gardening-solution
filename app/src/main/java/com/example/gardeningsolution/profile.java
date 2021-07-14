package com.example.gardeningsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button logout;
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });


        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //open drawer
        homepage.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        homepage.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //redirect activity to home
        homepage.redirectActivity(this, homepage.class );
    }
    public void ClickProfile(View view){
        //recreate activity
        recreate();
    }

    public void ClickServices(View view){
        //redirect to Services
        homepage.redirectActivity(this, services.class);
    }

    public void ClickMyBooking(View view){
        //redirect to Services
        homepage.redirectActivity(this, my_booking.class);
    }

    public void ClickExit(View view){
        //close app
        homepage.Exit(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        homepage.closeDrawer(drawerLayout);
    }
}