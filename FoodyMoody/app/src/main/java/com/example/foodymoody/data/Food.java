package com.example.foodymoody.data;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Food implements Parcelable {
    private String description, image, name;
    private Integer calories;
    private boolean allergic;
    public Food(){

    }

    public Food(String description, String image, String name, Integer calories, boolean allergic) {
        this.description = description;
        this.image = image;
        this.name = name;
        this.calories = calories;
        this.allergic = allergic;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Food(Parcel in) {
        description = in.readString();
        image = in.readString();
        name = in.readString();
        calories = in.readInt();
        allergic = in.readBoolean();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public boolean isAllergic() {
        return allergic;
    }

    public void setAllergic(boolean allergic) {
        this.allergic = allergic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeString(name);
        parcel.writeInt(calories);
        parcel.writeBoolean(allergic);
    }
}
