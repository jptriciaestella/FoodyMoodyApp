package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ChangeEmailActivity extends AppCompatActivity {

    TextView ChangeEmailInstructions, ChangeEmailAlert;
    TextInputLayout ChangeEmailPassword, ChangeEmailNewEmail;
    Button ChangeEmailButtonNext, ChangeEmailButtonChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

//        Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Change Email");
        actionBar.setDisplayHomeAsUpEnabled(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        ChangeEmailInstructions = findViewById(R.id.change_email_instruct);
        ChangeEmailAlert = findViewById(R.id.change_email_alert);
        ChangeEmailPassword = findViewById(R.id.change_email_password);
        ChangeEmailNewEmail = findViewById(R.id.change_email_new_email);
        ChangeEmailButtonNext = findViewById(R.id.change_email_button_next);
        ChangeEmailButtonChange = findViewById(R.id.change_email_button_change);

        ChangeEmailButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = ChangeEmailPassword.getEditText().getText().toString();
                if (password.isEmpty()) {
                    ChangeEmailAlert.setText("Field can't be empty.");
                }else{
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), password);
                    firebaseUser.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        ChangeEmailPassword.setVisibility(View.GONE);
                                        ChangeEmailNewEmail.setVisibility(View.VISIBLE);
                                        ChangeEmailInstructions.setText("Enter your new email");
                                        ChangeEmailButtonNext.setVisibility(View.GONE);
                                        ChangeEmailButtonChange.setVisibility(View.VISIBLE);
                                        ChangeEmailAlert.setText(null);
                                    }
                                    else{
                                        ChangeEmailAlert.setText(task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });

        ChangeEmailButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ChangeEmailNewEmail.getEditText().getText().toString().trim();
                if(validateEmail(email)){
                    firebaseUser.updateEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        ChangeEmailAlert.setText("Email is updated. Check your old email if you change your mind.");
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                finish();
                                            }
                                        }, 2000);
                                    }
                                    else{
                                        ChangeEmailAlert.setText(task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validateEmail(String email){
        if (email.isEmpty()) {
            ChangeEmailAlert.setText("Field can't be empty.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ChangeEmailAlert.setText("Please enter a valid email address.");
            return false;
        } else {
            ChangeEmailAlert.setText(null);
            return true;
        }
    }

}