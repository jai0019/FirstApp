package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SevenActivity extends AppCompatActivity {

    TextView tv1;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        tv1=findViewById(R.id.tv1);
    }

    //Calculate Button
    public void go(View v)
    {
       n = (int)(100+(200-100)*Math.random()) ;
       tv1.setText(n+"");
    }

    //Finish Button
    public void go2(View v)
    {
        Intent backintent = new Intent();
        backintent.putExtra("ans",n);

        setResult(RESULT_OK,backintent);

       // This will finish Activity and go Back
       finish();
    }

}
