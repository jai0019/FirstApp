package com.example.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FiveActivity extends AppCompatActivity {

    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        tv1=findViewById(R.id.tv1);

        Intent in = getIntent();

        Uri uri =in.getData();
        tv1.setText( uri.toString() );

    }



}
