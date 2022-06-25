package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    private FirebaseAuth mAuth;
    TextInputLayout logEmail, logPassword;
    TextView logEmailAlert, logPasswordAlert;
    Button logBtn, logToRegBtn, logForgetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        logEmail = findViewById(R.id.login_email);
        logEmailAlert = findViewById(R.id.login_emailAlert);
        logPassword = findViewById(R.id.login_password);
        logPasswordAlert = findViewById(R.id.login_pwAlert);
        logBtn = findViewById(R.id.login_btn);
        logToRegBtn = findViewById(R.id.log_to_reg_btn);
        logForgetBtn = findViewById(R.id.login_forgotPw);

        mAuth = FirebaseAuth.getInstance();

        logBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validateEmail() && validatePassword())
                    verifyLogin();
            }
        });

        logToRegBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        logForgetBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void verifyLogin(){
        String email = logEmail.getEditText().getText().toString();
        String password = logPassword.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //sign in success
                            if(mAuth.getCurrentUser().isEmailVerified()){
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                finish();
                            } else {
                                logPasswordAlert.setText("Please verify your email address!");
                            }
                        } else {
                            logPasswordAlert.setText(task.getException().getMessage());
                        }
                    }
                });
    }

    private boolean validateEmail() {
        String email = logEmail.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            logEmailAlert.setText("Field can't be empty.");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            logEmailAlert.setText("Please enter a valid email address.");
            return false;
        } else {
            logEmailAlert.setText(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String password = logPassword.getEditText().getText().toString();
        if (password.isEmpty()) {
            logPasswordAlert.setText("Field can't be empty.");
            return false;
        }else{
            logPasswordAlert.setText(null);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this,"Please click BACK again to exit.", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            finishAffinity();
        }
    }
}