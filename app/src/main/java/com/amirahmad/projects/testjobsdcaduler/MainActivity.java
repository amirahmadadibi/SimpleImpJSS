package com.amirahmad.projects.testjobsdcaduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //jobScheduler Runs in MainThread - Api 21 and later - Great low usage of battery and resources
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
