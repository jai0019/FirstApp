package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UsingThreadActivity extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_thread);

        tv1=findViewById(R.id.tv1);
    }


    //Short Logic
    public void go(View view) {

        tv1.setText(Math.random()+"");

    }

    public void go2(View v)
    {
       Thread t=new Thread(new myjob());
       t.start();
    }

    class myjob implements Runnable
    {
        //Long Running Logic
        @Override
        public void run()
        {
            for(int i=1;i<=100;i++)
            {
                final int x=i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Gui Changes should be done here
                        tv1.setText(x+"");
                    }
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
