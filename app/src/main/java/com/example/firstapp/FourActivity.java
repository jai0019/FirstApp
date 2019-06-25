package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FourActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        Intent incomingintent = getIntent();

        Bundle bd = incomingintent.getExtras();
        int a = bd.getInt("p");
        String b = bd.getString("st");
        double c = bd.getDouble("q");

        tv1.setText(a+"");
        tv2.setText(b);
        tv3.setText(c+"");

    }
}
