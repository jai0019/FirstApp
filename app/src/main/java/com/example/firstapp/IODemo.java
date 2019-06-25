package com.example.firstapp;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IODemo extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iodemo);

        tv1=findViewById(R.id.tv1);
    }

    //Write to External Storage
    public void go(View view) {

        try
        {
                                                    // "/mnt/sdcard/one.txt"
            FileWriter  fw = new FileWriter(Environment.getExternalStorageDirectory()+"/one.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("hello world");
            pw.println("This is Second Line");
            pw.println("This is Third Line");
            pw.println("1234567890");

            pw.flush();

            Toast.makeText(this, "File Written", Toast.LENGTH_SHORT).show();
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }

    }

    public void go2(View v)
    {
        try
        {
            FileReader     fr=new FileReader("/mnt/sdcard/one.txt");
            BufferedReader br=new BufferedReader(fr);

            String s;

            while(true)
            {
                s=br.readLine();
                if(s==null)
                    break;

                tv1.append(s+"\n");
            }
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }

    }

    public void go3(View v)
    {
        try
        {
           FileOutputStream fos =  openFileOutput("data.txt",MODE_PRIVATE);
           PrintWriter      pw = new PrintWriter(fos);

           pw.println("HELLO WORLD");
           pw.println("DATA From Iternal File");
           pw.println("!@#$%^&*()");

           pw.flush();

            Toast.makeText(this, "File Created in Internal Memory", Toast.LENGTH_SHORT).show();

        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
    }

    public void go4(View v)
    {
        try {

            FileInputStream fis = openFileInput("data.txt");
            BufferedReader  br=new BufferedReader(new InputStreamReader(fis));

            String s;

            tv1.setText("");

            while(true)
            {
                s=br.readLine();
                if(s==null)
                    break;

                tv1.append(s+"\n");
            }
        }
        catch(Exception ex)
        {
           ex.printStackTrace();
        }
    }

    public void go5(View v)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("pref1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user","Amrinder");
        editor.putInt("marks",90);

        editor.commit();
        Toast.makeText(this, "Saved in Shared Preference", Toast.LENGTH_SHORT).show();
    }

    public void go6(View v)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("pref1",MODE_PRIVATE);

        String u = sharedPreferences.getString("user",null);
        int m = sharedPreferences.getInt("marks",0);

        tv1.setText("User: "+u+"\n"+"Marks: "+m);
    }
}
