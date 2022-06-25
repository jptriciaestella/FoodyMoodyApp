package com.example.foodymoody;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            if(firebaseUser != null && firebaseUser.isEmailVerified())
            {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }else{
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
            finish();
        }, 2000L);
    }
}