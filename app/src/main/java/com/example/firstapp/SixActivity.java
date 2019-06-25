package com.example.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
    }

    public void go(View v)
    {
        Intent in=new Intent(Intent.ACTION_VIEW);

        Uri uri= Uri.parse("http://www.apple.com");
        in.setData(uri);

        startActivity(in);
    }

    public void go2(View v)
    {
        Intent in =new Intent(Intent.ACTION_DIAL);

        // Requires CALL_PHONE Permission in Manifest (also Runtime Permission Dialog)
        //Intent in =new Intent(Intent.ACTION_CALL);

        in.setData(Uri.parse("tel: 9914487487"));

        startActivity(in);
    }

    public void go3(View v)
    {
        Intent in=new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("geo: 31.63,74.87"));
        startActivity(in);
    }

    public void go4(View v)
    {
        //Intent in=new Intent(Settings.ACTION_SETTINGS);
        Intent in=new Intent(Settings.ACTION_WIFI_SETTINGS);

        startActivity(in);
    }

}
