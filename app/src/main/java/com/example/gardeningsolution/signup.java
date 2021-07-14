package com.example.gardeningsolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    Button button;
    EditText email,name,passwd,cnfpass;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        passwd = findViewById(R.id.passwd);
        cnfpass = findViewById(R.id.cnfpass);
        button = findViewById(R.id.sign);

        fAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password  = passwd.getText().toString();
                String Confirm  = cnfpass.getText().toString();


                if(Name.isEmpty()){
                    name.setError("Name is required");
                    return;
                }
                if(Email.isEmpty()){
                    email.setError("Email is required");
                    return;
                }

                if(Password.isEmpty()){
                    passwd.setError("Password is required");
                    return;
                }
                if(Confirm.isEmpty()){
                   cnfpass.setError("Confirm Password is required");
                    return;
                }
                if(!Password.equals(Confirm)){
                    cnfpass.setError("Password  do no match");
                    return;
                }

                Toast.makeText(signup.this,"You are Successfully Register",Toast.LENGTH_SHORT).show();

                fAuth.createUserWithEmailAndPassword(Email,Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }
}