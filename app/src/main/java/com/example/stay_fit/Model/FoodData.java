package com.example.stay_fit.Model;

import java.util.ArrayList;

public class FoodData implements FoodInterface {
    @Override
    public ArrayList<Food> getFoodList()
    {
        ArrayList<Food> FoodList = new ArrayList<>();
        FoodList.add(new Food("Egg",72));
        FoodList.add(new Food("Tomato",25));
        FoodList.add(new Food("Bread",100));
        FoodList.add(new Food("Banana",105));
        FoodList.add(new Food("Apple",95));
        return FoodList;
    }
}
