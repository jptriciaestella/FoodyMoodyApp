package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    TextView changePwInstruct, changePwAlert;
    TextInputLayout currPw, newPw, confNewPw, resetPwEmail;
    Button changePwBtn, forgotPwBtn, resetPwBtn, returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //back action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Change Password");
        actionBar.setDisplayHomeAsUpEnabled(true);



        //find id
        changePwInstruct = findViewById(R.id.change_pw_instruct);
        changePwAlert = findViewById(R.id.change_pw_alert);
        currPw = findViewById(R.id.change_pw_curr);
        newPw = findViewById(R.id.change_pw_new);
        confNewPw = findViewById(R.id.change_pw_conf);
        resetPwEmail = findViewById(R.id.change_pw_reset_email);
        changePwBtn = findViewById(R.id.change_pw_button_change);
        forgotPwBtn = findViewById(R.id.changePw_forgotPw_button);
        resetPwBtn = findViewById(R.id.change_pw_send_reset_button);
        returnBtn = findViewById(R.id.changePw_return);

        //change pw
        changePwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currPassword = currPw.getEditText().getText().toString();
                String newPassword = newPw.getEditText().getText().toString();
                String confirmPassword = confNewPw.getEditText().getText().toString();
                //check curr pw reauth
                AuthCredential authCredential = EmailAuthProvider.getCredential(
                        firebaseUser.getEmail(),currPassword);
                firebaseUser.reauthenticate(authCredential).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            if(validatePassword(newPassword, confirmPassword))
                            {
                                firebaseUser.updatePassword(newPassword)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    changePwAlert.setText("Password successfully updated!");
                                                    final Handler handler = new Handler();
                                                    handler.postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            finish();
                                                        }
                                                    }, 2000);
                                                }
                                                else{
                                                    //update pw fail
                                                    changePwAlert.setText(task.getException().getMessage());
                                                }
                                            }
                                        });
                            }
                        }
                        else{
                            //reauth fail
                            changePwAlert.setText(task.getException().getMessage());
                        }
                    }
                });
                //check new pw isvalid?
                //alert pw changed, back
            }
        });

        //forgot pw: tampilin email
        forgotPwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePwInstruct.setText("Enter your email");
                currPw.setVisibility(View.GONE);
                newPw.setVisibility(View.GONE);
                confNewPw.setVisibility(View.GONE);
                changePwBtn.setVisibility(View.GONE);
                forgotPwBtn.setVisibility(View.GONE);
                resetPwEmail.setVisibility(View.VISIBLE);
                resetPwBtn.setVisibility(View.VISIBLE);
                returnBtn.setVisibility(View.VISIBLE);
            }
        });

        //reset pw: validate email, send pw
        resetPwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verif email, send email
                String email = resetPwEmail.getEditText().getText().toString().trim();
                if(validateEmail(email))
                {
                    firebaseAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        changePwAlert.setText("Password reset link has been sent, please check your email.");
                                        final Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                finish();
                                            }
                                        }, 2000);
                                    }else{
                                        changePwAlert.setText(task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });

        //return: tampilin change pw
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePwInstruct.setText("Enter your password");
                currPw.setVisibility(View.VISIBLE);
                newPw.setVisibility(View.VISIBLE);
                confNewPw.setVisibility(View.VISIBLE);
                changePwBtn.setVisibility(View.VISIBLE);
                forgotPwBtn.setVisibility(View.VISIBLE);
                resetPwEmail.setVisibility(View.GONE);
                resetPwBtn.setVisibility(View.GONE);
                returnBtn.setVisibility(View.GONE);
            }
        });
    }

    //back action bar
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
            changePwAlert.setText("Field can't be empty.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            changePwAlert.setText("Please enter a valid email address.");
            return false;
        } else {
            changePwAlert.setText(null);
            return true;
        }
    }

    private boolean validatePassword(String password, String confirmPassword) {
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            changePwAlert.setText("Field can't be empty.");
            return false;
        }
        if (confirmPassword.isEmpty())
        {
            changePwAlert.setText("Field can't be empty.");
            return false;
        }
        if (password.length()<8) {
            changePwAlert.setText("Password must be at least 8 characters!");
            return false;
        }
        if(!password.matches("(.*[0-9].*)")){
            changePwAlert.setText("Password must contains at least 1 number!");
            return false;
        }
        if(!password.matches("(.*[A-Z].*)")){
            changePwAlert.setText("Password must contains at least 1 capital letter!");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            changePwAlert.setText("New password not matched!");
            return false;
        }else{
            changePwAlert.setText(null);
            return true;
        }
    }
}