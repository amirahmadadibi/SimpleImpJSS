package com.amirahmad.projects.testjobsdcaduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/**
 * Created by Amirahmad Adibi.
 * TestJobSdcaduler | Copyrights 2019-07-07.
 */
//1- extend form JobService
public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        //write your code here

        Log.d("codeRunner", "onStartJob: "+params.getJobId());
        //when your job is complete
        jobFinished(params,false);

        //false means you complete the job in the current thread
        return false;
    }


    //gets called by the scheduler if the job needs to be stopped
    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("codeRunner", "onStartJob: "+params.getJobId());
        return false;
    }
}
