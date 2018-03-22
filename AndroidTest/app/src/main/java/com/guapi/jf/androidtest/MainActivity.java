package com.guapi.jf.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  {


    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";
    private final static String TAG = "Lab-ActivityOne";

    private int mCreate,mRestart,mStart,mResume;
    private TextView tv1,tv2,tv3,tv4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Button launchActivityTwoButton = findViewById(R.id.bLaunchActivityTwo);
        tv1= findViewById(R.id.create);
        tv2=findViewById(R.id.start);
        tv3=findViewById(R.id.resume);
        tv4=findViewById(R.id.restart);
        launchActivityTwoButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                case R.id.bLaunchActivityTwo:
                    Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                    startActivity(intent);
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
        ++mStart;
        this.displayCounts();
        Log.i(TAG, "Entered the onStart() method");


    }

    @Override
    public void onResume() {
        super.onResume();
        ++mResume;

        Log.i(TAG, "Entered the onResume() method");



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


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(CREATE_KEY,mCreate);
        savedInstanceState.putInt(START_KEY ,mStart);
        savedInstanceState.putInt(RESUME_KEY,mResume);
        savedInstanceState.putInt(RESTART_KEY,mRestart);
    }


    public void displayCounts() {
        tv1.setText("onCreate() calls: " +mCreate);
        tv2.setText("onStart() calls: " +mStart);
        tv3.setText("onResume() calls: "+mResume);
        tv4.setText("onRestart() calls: " + mRestart);
    }
}
