package com.example.stay_fit.Model;

import java.util.ArrayList;

public class personData implements personInterface {

    @Override
    public String[] getGender(){
        String[] Gender = {"Female","Male"};

        return Gender;
    }

    @Override
    public String[] getGoal(){
        String[] Goal= {"Loss", "Maintenance", "Gain"};

        return Goal;
    }
}
