package com.example.foodymoody;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class Profile extends Fragment {

    CardView changeEmail, changePassword, contactUs, promoteFood, rateApp, signOut;
    TextView welcomeUser, userEmail;
    ShapeableImageView userImage;

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user == null)
        {
            Intent intent = new Intent(rootView.getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        //randomize user avatar
        int date = new Date().getDate()%10;
        String fnm = "avatar" + date;
        String PACKAGE_NAME = getActivity().getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);

        //print user info
        String email = user.getEmail();
        String name = email.substring(0,email.indexOf('@'));

        if (email.indexOf('@') > 24){
            name = name.substring(0,20) + "... ";
            email = "..." + email.substring(email.indexOf('@')-10, email.length());
        }

        changeEmail = (CardView) rootView.findViewById(R.id.change_email);
        changePassword = (CardView) rootView.findViewById(R.id.change_password);
        contactUs = (CardView) rootView.findViewById(R.id.contact_us);
        promoteFood = (CardView) rootView.findViewById(R.id.promote_food);
        rateApp = (CardView) rootView.findViewById(R.id.rate_app);
        signOut = (CardView) rootView.findViewById(R.id.sign_out);

        //set user dn and email
        welcomeUser = (TextView) rootView.findViewById(R.id.welcome_user);
            welcomeUser.setText("Welcome " + name + "!");

        userEmail = (TextView) rootView.findViewById(R.id.user_email);
            userEmail.setText(email);

        //set user avatar
        userImage = (ShapeableImageView) rootView.findViewById(R.id.user_image);
            userImage.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId));

        changeEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("changeemail");
                Intent myIntent = new Intent(getActivity().getApplicationContext(), ChangeEmailActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("changepassword");
                Intent myIntent = new Intent(getActivity().getApplicationContext(), ChangePasswordActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("contactus");
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"foodymoodyapp@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Contact Foody Moody Support");
                intent.putExtra(Intent.EXTRA_TEXT,"Hello, I'm a Foody Moody user " + user.getEmail() + " and I'd like to ...");
                intent.putExtra(Intent.EXTRA_CC,user.getEmail());
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });

        promoteFood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("promotefood");
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"foodymoodyapp@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Promote Food/Eatery Request to Foody Moody");
                intent.putExtra(Intent.EXTRA_TEXT,"Hey, I'd like to promote my food to the application please! My restaurant is ...");
                intent.putExtra(Intent.EXTRA_CC,user.getEmail());
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });

        rateApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("rateapp");
                Toast.makeText(getActivity(), "This feature is not available yet!", Toast.LENGTH_LONG).show();
            }
        });

        signOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(rootView.getContext());
                builder.setTitle("Logout Confirmation!").
                        setMessage("Since we are still in a development, we cant sync the list of your favorites yet and it will be deleted permanently. " +
                                "Proceed to logout?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(rootView.getContext(), LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });

        return rootView;
    }
}