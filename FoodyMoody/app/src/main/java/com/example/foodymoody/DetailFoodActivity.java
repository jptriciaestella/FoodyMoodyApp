package com.example.foodymoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodymoody.data.Food;

import java.util.Date;
import java.util.Random;

public class DetailFoodActivity extends AppCompatActivity {

    ImageView foodImage, restoImg0, restoImg1, restoImg2;
    TextView foodName, foodDescription, foodCalories, foodAllergic,
            restoName0, restoName1, restoName2,
            restoPhone0, restoPhone1, restoPhone2;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        Intent intent = getIntent();
        Food food = intent.getParcelableExtra("likedFood");

        //        Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(food.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);

        foodImage = findViewById(R.id.detail_food_image);
            Glide.with(this)
            .load(food.getImage())
            .into(foodImage);

        String calories = food.getCalories()+ " kkal";
        String allergy;
        if (food.isAllergic()) {
            allergy = "Yes";
        }else{
            allergy = "No";
        }

        foodName = findViewById(R.id.detail_food_name);
            foodName.setText(food.getName());
        foodDescription = findViewById(R.id.detail_food_desc);
            foodDescription.setText(food.getDescription());
        foodCalories = findViewById(R.id.detail_food_cal);
            foodCalories.setText(calories);
        foodAllergic = findViewById(R.id.detail_food_allergic);
            foodAllergic.setText(allergy);

        //set resto0
        restoImg0 = findViewById(R.id.resto_img0);
            restoImg0.setImageBitmap(BitmapFactory.decodeResource(getResources(),generateImageID()));
        restoName0 = findViewById(R.id.resto_name0);
            restoName0.setText(generateRestoName(food.getName()));
        restoPhone0 = findViewById(R.id.resto_phone0);
            restoPhone0.setText(generatePhoneNumber());

        //set resto1
        restoImg1 = findViewById(R.id.resto_img1);
            restoImg1.setImageBitmap(BitmapFactory.decodeResource(getResources(),generateImageID()));
        restoName1 = findViewById(R.id.resto_name1);
            restoName1.setText(generateRestoName(food.getName()));
        restoPhone1 = findViewById(R.id.resto_phone1);


        //set resto2
        restoImg2 = findViewById(R.id.resto_img2);
            restoImg2.setImageBitmap(BitmapFactory.decodeResource(getResources(),generateImageID()));
        restoName2 = findViewById(R.id.resto_name2);
            restoName2.setText(generateRestoName(food.getName()));
        restoPhone2 = findViewById(R.id.resto_phone2);

    }

    private String getFoodAllergy(boolean allergic) {
        if (allergic){
            return "Yes";
        }else{
            return "No";
        }
    }

    private String getFoodCal(Integer calories) {
        return calories + " kkal";
    }



    private String generatePhoneNumber() {
        String phoneNo = "021-";
        for (int i = 0; i < 7; i++) {
            phoneNo += rand.nextInt(10);
        }
        return phoneNo;
    }

    private int generateImageID(){
        String fnm = "rest" + rand.nextInt(5);
        String PACKAGE_NAME = getApplicationContext().getPackageName();

        return getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);
    }

    private String generateRestoName(String foodName){
        String[] prefix = {"Restoran ", "Rumah makan ", "Warung ", "Cafe ", "Restaurant ", "Diner "} ;
        String postfix = " ";
        char c;
        for (int i = 0; i < 3; i++) {
            c = (char)(rand.nextInt(26) + 'A');
            postfix += c;
        }
        return prefix[rand.nextInt(6)] + foodName + postfix;
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
}