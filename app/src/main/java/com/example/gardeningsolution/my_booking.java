package com.example.gardeningsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class my_booking extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Assign varible
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
        //redirect to Services
        homepage.redirectActivity(this, profile.class);
    }

    public void ClickServices(View view){
        //redirect to Services
        homepage.redirectActivity(this, services.class);
    }

    public void ClickMyBooking(View view){
       //recreate
         recreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        homepage.closeDrawer(drawerLayout);
    }
}