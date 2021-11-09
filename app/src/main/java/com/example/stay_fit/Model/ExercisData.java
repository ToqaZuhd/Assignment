package com.example.stay_fit.Model;

import java.util.ArrayList;

public class ExercisData implements ExerciseInterface{
    @Override
    public ArrayList<Exercise> getExerciseList()
    {
        ArrayList<Exercise> ExrList = new ArrayList<>();
        ExrList.add(new Exercise("Aerobic,general",211));
        ExrList.add(new Exercise("Aerobic,high Impact",227));
        ExrList.add(new Exercise("Aerobic,low impact",163));
        ExrList.add(new Exercise("Belly dancing",146));
        ExrList.add(new Exercise("Boxing",97));
        return ExrList;
    }
}
