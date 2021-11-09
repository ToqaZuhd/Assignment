package com.example.stay_fit.Model;

public class Food {
    private String Name;
    private double calories;

    public Food(String name, double calories) {
        Name = name;
        this.calories = calories;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }


}
