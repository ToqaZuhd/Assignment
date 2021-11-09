package com.example.stay_fit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stay_fit.Model.person;
import com.example.stay_fit.Model.personFactory;
import com.example.stay_fit.Model.personInterface;
import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {

    private Spinner gender;
    private Spinner goal;
    private EditText height;
    private EditText weight;
    private EditText age;
    private RadioGroup radiogroup;
    private RadioButton RD1;
    private RadioButton RD2;
    private RadioButton RD3;
    private RadioButton RD4;
    private String Calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gender= findViewById(R.id.Gender);
        goal= findViewById(R.id.Goal);
        height=findViewById(R.id.Height);
        weight=findViewById(R.id.Weight);
        age=findViewById(R.id.Age);
        radiogroup=(RadioGroup) findViewById(R.id.RGroup);
        RD1=findViewById(R.id.SedentaryLevel);
        RD2=findViewById(R.id.LightlyLevel);
        RD3=findViewById(R.id.ModeratelyLevel);
        RD4=findViewById(R.id.ActiveLevel);
        populateSpinners();

    }


    private void populateSpinners() {
       personFactory PF=new personFactory();
       personInterface PLI=PF.getModel();
       String[] Gender=PLI.getGender();
       String[] Goal=PLI.getGoal();
       ArrayAdapter<String> adapterGender=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Gender);
       ArrayAdapter<String> adapterGoal=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Goal);
       gender.setAdapter(adapterGender);
       goal.setAdapter(adapterGoal);


    }

    public void getCalories(){
        int calories;
        double BMR;
        double AMR=0;
        double heightD=Double.parseDouble(height.getText().toString());
        double weightD=Double.parseDouble(weight.getText().toString());
        int ageD=Integer.parseInt(age.getText().toString());

        String selectedGoal=goal.getSelectedItem().toString();

        String selectedGender=gender.getSelectedItem().toString();
        String selectRD1=RD1.getText().toString();
        String selectRD2=RD2.getText().toString();
        String selectRD3=RD3.getText().toString();
        String selectRD4=RD4.getText().toString();
        String selectedLevel=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId()))
                .getText().toString();

        if (selectedGender=="Female")
            BMR=655.1+(9.563*weightD)+(1.850*heightD)-(4.676*ageD);
        else
            BMR=66.47+(13.75*weightD)+(5.003*heightD)-(6.755*ageD);

        if(selectedLevel==selectRD1)
            AMR=BMR*1.2;
        else if (selectedLevel==selectRD2)
            AMR=BMR*1.375;
        else if (selectedLevel==selectRD3)
            AMR=BMR*1.55;
        else if (selectedLevel==selectRD4)
            AMR=BMR*1.725;


        if(selectedGoal=="Loss")
            calories=(int)AMR-300;
        else if(selectedGoal=="Maintenance")
            calories=(int)AMR;
        else
            calories=(int)AMR+300;

        Calories=Integer.toString(calories);

    }
    public void btnCalculateCalories(View view) {
        getCalories();
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("data", Calories);
        startActivity(intent);
    }

    public void btnSaveOnClick(View view) {
        getCalories();
        double heightD=Double.parseDouble(height.getText().toString());
        double weightD=Double.parseDouble(weight.getText().toString());
        int ageD=Integer.parseInt(age.getText().toString());
        int caloriesPerson=Integer.parseInt(Calories);
        String selectedGoal=goal.getSelectedItem().toString();
        String selectedGender=gender.getSelectedItem().toString();
        String selectedLevel=((RadioButton)findViewById(radiogroup.getCheckedRadioButtonId()))
                .getText().toString();



        person persons=new person(heightD,weightD,ageD,selectedGender,selectedGoal,selectedLevel,caloriesPerson);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String personString = gson.toJson(persons);
        editor.putString("person", personString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + personString,
                Toast.LENGTH_SHORT).show();


    }

    public void btnLoadOnClick(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("person", "");
        person Person = gson.fromJson(str, person.class);

        Toast.makeText(this, "Your Calories: " + Person.getCalories()
                , Toast.LENGTH_LONG).show();
    }
}