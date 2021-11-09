package com.example.stay_fit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stay_fit.Model.Food;
import com.example.stay_fit.Model.FoodFactory;
import com.example.stay_fit.Model.FoodInterface;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    private ListView FoodList;
   private double calories;
    /*private String msgCalories;
    private String msgFood;
    private String msgExercise;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
         FoodList=findViewById(R.id.ListFood);
      /*  Intent intent=getIntent();
         msgExercise=intent.getStringExtra("dataExercise");
         msgFood=intent.getStringExtra("dataFood");
         msgCalories=intent.getStringExtra("dataCalories");
        FoodList=findViewById(R.id.ListFood);*/
        populateList();
    }

    private void populateList(){
        FoodFactory EF=new FoodFactory();
        FoodInterface EI=EF.getModel();
        ArrayList<Food> listF=EI.getFoodList();
        ArrayList<String> ListString=new ArrayList<String>();
        for(int i=0; i<listF.size();i++){
            ListString.add(listF.get(i).getName()+"                              "+listF.get(i).getCalories());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListString);
        FoodList.setAdapter(adapter);

        FoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calories +=listF.get(position).getCalories();



            }
        });
    }

    public void btnBack(View view) {

        /*double caloriesRemainder=Double.parseDouble(msgCalories)-((Double.parseDouble(msgFood)+calories)+Double.parseDouble(msgExercise));
        double caloriesFoodAll=calories+Double.parseDouble(msgFood);

        String txtMessageFood=Double.toString(caloriesFoodAll);
        String txtMessageReminder=Double.toString(caloriesRemainder);

        intent.putExtra("dataFoodAll", txtMessageFood);
       intent.putExtra("dataReminderAll", txtMessageReminder);
        intent.putExtra("dataCaloriesAll", msgCalories);
        intent.putExtra("dataExerciseAll", msgExercise);

         */
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("dataCaloriesAll", calories);
        startActivity(intent);
    }
}