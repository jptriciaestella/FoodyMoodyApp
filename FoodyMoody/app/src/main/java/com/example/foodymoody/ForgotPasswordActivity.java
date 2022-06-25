package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextInputLayout forgotEmail;
    TextView forgotEmailAlert;
    Button sendForgotBtn, forToRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Objects.requireNonNull(getSupportActionBar()).hide();



        mAuth = FirebaseAuth.getInstance();
        forgotEmail = findViewById(R.id.forgot_email);
        forgotEmailAlert = findViewById(R.id.forgot_emailAlert);
        sendForgotBtn = findViewById(R.id.send_forgot);
        forToRegBtn = findViewById(R.id.for_to_reg_btn);

        sendForgotBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = forgotEmail.getEditText().getText().toString();
                if (email.isEmpty()) {
                    forgotEmailAlert.setText("Field can't be empty.");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    forgotEmailAlert.setText("Please enter a valid email address.");
                } else {
                    forgotEmailAlert.setText(null);
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        forgotEmailAlert.setText("Password send to your email.");
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            }
                                        }, 3000);
                                    }else{
                                        forgotEmailAlert.setText(task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });

        forToRegBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ForgotPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}