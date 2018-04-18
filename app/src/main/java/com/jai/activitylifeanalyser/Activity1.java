package com.jai.activitylifeanalyser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends LifeCycleLoggerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity1.this, Activity2.class));
            }
        });
    }
}
