package com.example.firstapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoDemo extends AppCompatActivity {

    ImageView imv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_demo);
        imv1=findViewById(R.id.imv1);
    }

    public void go(View view) {
        Picasso.with(this).load(R.drawable.one).into(imv1);
    }

    public void go2(View view) {

       Picasso.with(this).load(new File("/mnt/sdcard/one.jpg")).into(imv1);
    }

    public void go3(View view) {
         Picasso.with(this).load("http://lorempixel.com/800/400/").into(imv1);
    }

}
