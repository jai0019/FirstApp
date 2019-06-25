package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TwentyFourActivity extends AppCompatActivity {

    TextView tv1;
    Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_four);

        tv1=findViewById(R.id.tv1);
        toolbar1 =findViewById(R.id.toolbar1);

        //This will replace ActionBar with Toolbar
        setSupportActionBar(toolbar1);

    }

    // This method is used to Load Menu Items from Menu File into ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);

        return true;
    }

    // This method is called when menuitem is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.m1)
        {
            tv1.setText("Menu 1 Clicked");
        }
        else if(item.getItemId()== R.id.m2)
        {
            tv1.setText("Menu 2 Clicked");
        }
        else if(item.getItemId()== R.id.m3)
        {
            tv1.setText("Menu 3 Clicked");
        }
        else if(item.getItemId()== R.id.m4)
        {
            tv1.setText("Menu 4 Clicked");
        }
        else if(item.getItemId()== R.id.m5)
        {
            tv1.setText("Menu 5 Clicked");
        }
        else if(item.getItemId()== R.id.m6)
        {
            tv1.setText("Menu 6 Clicked");
        }
        return true;
    }
}
