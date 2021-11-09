package com.example.stay_fit.Model;

public class person {
    private double Height;
    private double Width;
    private int Age;
    private String Gender;
    private String Goal;
    private String Level;
    private int Calories;

    public person(double height, double width, int age, String gender, String goal, String level,int calories) {
        Height = height;
        Width = width;
        Age = age;
        Gender = gender;
        Goal = goal;
        Level = level;
        Calories=calories;
    }
    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getWidth() {
        return Width;
    }

    public void setWidth(double width) {
        Width = width;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getGoal() {
        return Goal;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        Calories = calories;
    }

}
