package com.example.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SomeComponentsActivity extends AppCompatActivity {

    TextView tv1;
    CheckBox c1;

    ToggleButton tb1;
    Switch sw1;

    RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_components);

        tv1=findViewById(R.id.tv1);
        c1=findViewById(R.id.c1);
        tb1=findViewById(R.id.tb1);
        sw1=findViewById(R.id.sw1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);



        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    tv1.setVisibility(View.VISIBLE);
                else
                    //tv1.setVisibility(View.INVISIBLE);
                    tv1.setVisibility(View.GONE);

            }
        });


        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv1.setText("Wifi ON");
                    tv1.setTextColor(Color.GREEN);
                }
                    else {
                    tv1.setText("Wifi OFF");
                    tv1.setTextColor(Color.RED);
                }
            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv1.setText("Wifi ON");
                    tv1.setTextColor(Color.GREEN);
                }
                else {
                    tv1.setText("Wifi OFF");
                    tv1.setTextColor(Color.RED);
                }
            }
        });


        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                  tv1.setTextColor(Color.RED);
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                  tv1.setTextColor(Color.GREEN);
            }
        });

        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                   tv1.setTextColor(Color.BLUE);
            }
        });


    }


    public void go(View view) {

        Toast.makeText(this, "Image Button CLicked", Toast.LENGTH_SHORT).show();
    }
}
