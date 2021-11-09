package com.example.stay_fit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stay_fit.Model.Exercise;
import com.example.stay_fit.Model.ExerciseFactory;
import com.example.stay_fit.Model.ExerciseInterface;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private ListView ListExercise;
    private double calories;

    /*private String msgCalories;
    private String msgFood;
    private String msgExercise;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ListExercise =findViewById(R.id.ListExercise);
       /* Intent intent=getIntent();
        msgExercise=intent.getStringExtra("dataExercise");
        msgFood=intent.getStringExtra("dataFood");
        msgCalories=intent.getStringExtra("dataCalories");
*/
        populateList();
    }

    private void populateList(){
        ExerciseFactory EF=new ExerciseFactory();
        ExerciseInterface EI=EF.getModel();
        ArrayList<Exercise> listE=EI.getExerciseList();
        ArrayList<String> ListString=new ArrayList<String>();
        for(int i=0; i<listE.size();i++){
            ListString.add(listE.get(i).getName()+"                              "+listE.get(i).getCalories());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListString);
        ListExercise.setAdapter(adapter);

        for (int i = 0; i < ListExercise.getChildCount(); i++) {
            ((TextView) ListExercise.getChildAt(i)).setTextColor(getResources().getColor(R.color.white));
        }

        ListExercise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calories +=listE.get(position).getCalories();


            }
        });

    }

    public void btnBackClick(View view) {

/*
        double caloriesRemainder=Double.parseDouble(msgCalories)-((Double.parseDouble(msgExercise)+calories)+Double.parseDouble(msgExercise));
        double caloriesExerciseAll=calories+Double.parseDouble(msgExercise);

        String txtMessageExercise=Double.toString(caloriesExerciseAll);
        String txtMessageReminder=Double.toString(caloriesRemainder);


        intent.putExtra("dataFoodAll2", msgFood);
        intent.putExtra("dataReminderAll2", txtMessageReminder);
        intent.putExtra("dataCaloriesAll2", msgCalories);
        intent.putExtra("dataExerciseAll2", txtMessageExercise);*/
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("dataCaloriesAll2", calories);
        startActivity(intent);

    }
}