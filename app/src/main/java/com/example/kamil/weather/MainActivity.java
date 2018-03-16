package com.example.kamil.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://api.wunderground.com/api/771028ced1c5c1b6/forecast10day/q/GB/London.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }
}
