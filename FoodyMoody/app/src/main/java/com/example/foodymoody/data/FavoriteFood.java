package com.example.foodymoody.data;

import java.util.ArrayList;
import java.util.Date;

public class FavoriteFood{
    private Food food;
    private Date added;

    public static ArrayList<FavoriteFood> list = new ArrayList<>();

    public FavoriteFood(Food food, Date added) {
        this.food = food;
        this.added = added;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

}
