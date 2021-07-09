package com.example.gardeningsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerlayout;
    Button button;
    CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //book now button
        button = findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, services.class);
                startActivity(intent);
            }
        });
        //Card 1 to new activity
        card = findViewById(R.id.c1);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this, fertilizers.class);
                startActivity(intent);
            }
        });


        //Assign variable
        drawerlayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){

        //Open drawer
        openDrawer(drawerlayout);
    }

    public static void openDrawer(DrawerLayout drawerlayout) {
        //Open drawer layout
        drawerlayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //close drawer
        closeDrawer(drawerlayout);
    }

    public static void closeDrawer(DrawerLayout drawerlayout) {
        //close drawer layout
        //check condition
        if(drawerlayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerlayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //recreate activity
        recreate();
    }

    public void ClickProfile(View view) {
        //redirect activity to Profile
        redirectActivity(this, profile.class);
    }

    public void ClickServices(View view){
        //redirect activity
        redirectActivity(this, services.class);
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //START activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerlayout);
    }
}