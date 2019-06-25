package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LifeCycleDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_demo);
        Log.d("MYMESSAGE","ON Create Called");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MYMESSAGE","On Start Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MYMESSAGE","On Resume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MYMESSAGE","On Pause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MYMESSAGE","On Stop Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MYMESSAGE","On ReStart Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MYMESSAGE","On Destroy Called");
    }

    public void go(View v)
    {
        Intent in=new Intent(this, TenActivity.class);
        startActivity(in);
    }

}
