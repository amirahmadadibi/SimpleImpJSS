package com.amirahmad.projects.testjobsdcaduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int JOB_ID = 100;
    int counterInt = 1;

    //jobScheduler Runs in MainThread - Api 21 and later - Great low usage of battery and resources
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLaunchService = findViewById(R.id.btnLaunch);
        final TextView counter = findViewById(R.id.textViewCounter);

        btnLaunchService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(10000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        counter.setText(counterInt + "");
                        counterInt++;
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
                //Flow
                //1 - create jobScheduler
                JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                //2 - create jobInfo
                JobInfo jobInfo = new JobInfo.Builder
                        (JOB_ID, new ComponentName(MainActivity.this, MyJobService.class))
                        .setMinimumLatency(1000 * 10)
                        .build();
                //an example
                //JobInfo job = new JobInfo.Builder(0 /*jobid*/, new ComponentName(this,MyService.class))
                //.setMinimumLatency(1000)
                //.setOverrideDeadline(2000) or .setPeriodic(2000)
                //.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                //.setRequiresCharging(true)
                //.build();
                //3 - schedule the job
                jobScheduler.schedule(jobInfo);
            }
        });
    }

}
