package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    TextInputLayout regEmail, regPassword, regConfirmPassword;
    TextView regEmailAlert, regPasswordAlert, regPasswordConfirmAlert;
    Button regToLoginBtn, regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        mAuth = FirebaseAuth.getInstance();

        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regConfirmPassword = findViewById(R.id.reg_confirmPassword);
        regEmailAlert = findViewById(R.id.reg_emailAlert);
        regPasswordAlert = findViewById(R.id.reg_pwAlert);
        regPasswordConfirmAlert = findViewById(R.id.reg_pwConfAlert);
        regToLoginBtn = findViewById(R.id.reg_to_login);
        regBtn = findViewById(R.id.reg_btn);

        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validateEmail() && validatePassword())
                    createAccount();
            }
        });

        regToLoginBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
               startActivity(intent);
           }
        });
    }

    private boolean validateEmail() {
        String email = regEmail.getEditText().getText().toString();
        if (email.isEmpty()) {
            regEmailAlert.setText("Field can't be empty.");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            regEmailAlert.setText("Please enter a valid email address.");
            return false;
        } else {
            regEmailAlert.setText(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String password = regPassword.getEditText().getText().toString();
        String confirmPassword = regConfirmPassword.getEditText().getText().toString();
        if (password.isEmpty()) {
            regPasswordAlert.setText("Field can't be empty.");
            return false;
        }
        if (password.length()<8) {
            regPasswordAlert.setText("Password must be at least 8 characters!");
            return false;
        }
        if(!password.matches("(.*[0-9].*)")){
            regPasswordAlert.setText("Password must contains at least 1 number!");
            return false;
        }
        if(!password.matches("(.*[A-Z].*)")){
            regPasswordAlert.setText("Password must contains at least 1 capital letter!");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            regPasswordAlert.setText(null);
            regPasswordConfirmAlert.setText("Password not matched!");
            return false;
        }else{
            regPasswordAlert.setText(null);
            regPasswordConfirmAlert.setText(null);
            return true;
        }
    }

    private void createAccount(){
        String email = regEmail.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Intent intent = new Intent(RegisterActivity.this, VerifyAccountActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(),
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            // If sign in fails, display a message to the user.
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                regEmailAlert.setText("Email already registered!");
                            }
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}