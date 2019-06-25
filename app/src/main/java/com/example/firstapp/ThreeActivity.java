package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        //Refer to incoming intent
        Intent in = getIntent();

        //Extract extras from intent
        int a = in.getIntExtra("p",0);
        String b = in.getStringExtra("st");
        double c = in.getDoubleExtra("q",0.0) ;

        tv1.setText(a+"");
        tv2.setText(b);
        tv3.setText(c+"");

    }
}
