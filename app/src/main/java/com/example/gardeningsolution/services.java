package com.example.gardeningsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class services extends AppCompatActivity {
    //initialize variable
    DrawerLayout drawerLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        //button to date picker
        button = findViewById(R.id.btn4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(services.this, date_picker.class);
                startActivity(intent);
            }
        });

        //assign variable
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
        //redirect to profile
        homepage.redirectActivity(this, profile.class);
    }

    public void ClickServices(View view){
        //recreate activity
        recreate();

    }

    public void ClickLogout(View view){
        //close app
        homepage.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        homepage.closeDrawer(drawerLayout);
    }
}