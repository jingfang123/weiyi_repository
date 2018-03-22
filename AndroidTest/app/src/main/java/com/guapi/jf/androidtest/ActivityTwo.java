package com.guapi.jf.androidtest;

/**
 * Created by idmin on 2018/3/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {


    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";
    //声明四个TextView
    private TextView tv1,tv2,tv3,tv4;
    private int mCreate,mRestart,mStart,mResume;



    private final static String TAG = "Lab-ActivityTwo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tv1= findViewById(R.id.create2);
        tv2=findViewById(R.id.start2);
        tv3=findViewById(R.id.resume2);
        tv4=findViewById(R.id.restart2);


        Button closeButton =  findViewById(R.id.bClose);
        closeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bClose:
                        finish();
                        break;
                }


            }
        });


        if (savedInstanceState != null) {

            mCreate=savedInstanceState.getInt(CREATE_KEY);
            mStart=savedInstanceState.getInt(START_KEY);
            mResume=savedInstanceState.getInt(RESUME_KEY);
            mRestart=savedInstanceState.getInt(RESTART_KEY);


        }
        ++mCreate;

        Log.i(TAG, "Entered the onCreate() method");

        tv1.setText("onCreate() calls: " +mCreate);



    }

    @Override
    public void onStart() {
        super.onStart();
        //this.displayCounts();
        ++mStart;
        Log.i(TAG, "Entered the onStart() method");


        tv2.setText("onStart() calls: " +mStart);



    }

    @Override
    public void onResume() {
        super.onResume();

        ++mResume;
        Log.i(TAG, "Entered the onResume() method");



        tv3.setText("onResume() calls: "+mResume);

    }

    @Override
    public void onPause() {
        super.onPause();


        Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onStop() {
        super.onStop();


        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        ++mRestart;
        Log.i(TAG, "Entered the onRestart() method");

        tv4.setText("onRestart() calls: " + mRestart);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
       savedInstanceState.putInt(CREATE_KEY,mCreate);
        savedInstanceState.putInt(START_KEY,mStart);
        savedInstanceState.putInt(RESUME_KEY,mResume);
        savedInstanceState.putInt(RESTART_KEY,mRestart);

    }



}