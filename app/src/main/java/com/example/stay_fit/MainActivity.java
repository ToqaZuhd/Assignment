package com.example.stay_fit;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread LogoThread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    int waited = 0;
                    while (waited < 2800)
                    {
                        sleep(50);
                        waited += 100;
                    }
                } catch (InterruptedException e)
                {
                    // do nothing
                } finally
                {
                    finish();
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                }
            }
        };
        LogoThread.start();
    }
}