package com.jai.activitylifeanalyser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LifeCycleLoggerActivity extends AppCompatActivity {

    private String TAG;

    private TextView activityName;

    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        setContentView(R.layout.logger_activity);
        activityName = findViewById(R.id.activity_name);
        activityName.setText(this.getClass().getSimpleName());

        button = findViewById(R.id.start_another_activity);
        button.setVisibility(View.GONE);

        Log.i(TAG, getString(R.string.state_log, "Created", "onCreate()"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getString(R.string.state_log, "Started", "onStart()"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getString(R.string.state_log, "Resumed", "onResume()"));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, getString(R.string.state_log, "Resumed", "onPostResume()"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getString(R.string.state_log, "Paused", "onPause()"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getString(R.string.state_log, "Stopped", "onStopped()"));

        /* Now following things can happen
        1. User Navigated to another activity. So this activity will go to the back-stack. and can goto started again if user do a backpress.
        Test what will happen if this activity remain in the backstack and system starts going out of memory. Does it first kill the background
        activity and keep the foreground. Or when it comes to kill the activity it kills the entire process.

        2. Application went to the background. In this state the activity will remain stopped while the app is backgrounded. It can then be
        killed when android decides to kill the application process. In that situation I need to test if android calls other activities.


        *
        * */

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getString(R.string.state_log, "Stopped", "onRestart()"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getString(R.string.state_log, "Destroyed", "onDestroy()"));
        if (isFinishing()) {
            Log.i(TAG, "isFinishing: " + isFinishing());
        }
    }
}
