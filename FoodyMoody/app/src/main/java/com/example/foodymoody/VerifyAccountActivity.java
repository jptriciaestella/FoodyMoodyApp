package com.example.foodymoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class VerifyAccountActivity extends AppCompatActivity {

    private long pressedTime;
    private FirebaseAuth mAuth;

    Button verifToLoginBtn, resendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_account);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mAuth = FirebaseAuth.getInstance();
        verifToLoginBtn = findViewById(R.id.ver_to_login_btn);
        resendBtn = findViewById(R.id.resend_verification);

        verifToLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(VerifyAccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        resendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mAuth.getCurrentUser().sendEmailVerification();
                if (pressedTime + 60000 > System.currentTimeMillis()) {
                    Toast.makeText(getBaseContext(), "Please wait 60 seconds to try again!", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.getCurrentUser().sendEmailVerification();
                    Toast.makeText(getBaseContext(), "Verification email has been resent.", Toast.LENGTH_SHORT).show();
                }
                pressedTime = System.currentTimeMillis();
            }
        });
    }
}