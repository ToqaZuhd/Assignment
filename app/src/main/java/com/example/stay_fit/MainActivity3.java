package com.example.stay_fit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity3 extends AppCompatActivity {

    private TextView txtCalories;
    private TextView txtReminder2;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        txtCalories = findViewById(R.id.Calories);
        txtReminder2 = findViewById(R.id.Reminder);
        String msg = intent.getStringExtra("data");
        txtCalories.setText(msg);
        txtReminder2.setText(msg);
        listView = findViewById(R.id.ListPersonal);
        populateList();


       /* Intent intentFood=getIntent();
        txtFood.setText(intentFood.getStringExtra("dataCaloriesAll"));

        Intent intentExercise=getIntent();
        txtCalories.setText(intentExercise.getStringExtra("dataCaloriesAll2"));

        /*
        txtCalories.setText(intentFood.getStringExtra("dataCaloriesAll"));

        txtExercise.setText(intentFood.getStringExtra("dataExerciseAll"));
        txtReminder2.setText(intentFood.getStringExtra("dataReminderAll"));


        txtFood.setText(intentExercise.getStringExtra("dataFoodAll2"));
        txtExercise.setText(intentExercise.getStringExtra("dataExerciseAll2"));
        txtReminder2.setText(intentExercise.getStringExtra("dataReminderAll2"));
*/

    }


    private void populateList(){
        String[] Daily={"Food","Exercise"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Daily);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(view.getContext(), MainActivity4.class);
                  /*  intent.putExtra("dataCalories", txtCalories.getText().toString());
                    intent.putExtra("dataFood", txtFood.getText().toString());
                    intent.putExtra("dataExercise", txtExercise.getText().toString());
                    */
                    startActivity(intent);
                }
                else{
                    Intent intent2=new Intent(view.getContext(), MainActivity5.class);
                   /* intent2.putExtra("dataCalories", txtCalories.getText().toString());
                    intent2.putExtra("dataFood", txtFood.getText().toString());
                    intent2.putExtra("dataExercise", txtExercise.getText().toString());
                    */startActivity(intent2);
            }}
        });



    }


}