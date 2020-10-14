package com.example.helloandroid.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.R;

public class ActivityB extends AppCompatActivity {
    private static final String TAG = "ACTIVITY B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ActivityB.TAG, "onStart B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ActivityB.TAG, "onResume B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ActivityB.TAG, "onDestroy B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ActivityB.TAG, "onPause B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ActivityB.TAG, "onStop B");
    }

    @Override
    protected void  onRestart() {
        super.onRestart();
        Log.d(ActivityB.TAG, "onRestart B");
    }

    public void clicked(View view) {
        switch (view.getId()) {
            case R.id.buttonA:
                startActivity(new Intent(this, ActivityA.class));
                break;
            case R.id.buttonB:
                startActivity(new Intent(this, ActivityB.class));
                break;
            case R.id.buttonC:
                startActivity(new Intent(this, ActivityC.class));
                break;
        }
    }
}