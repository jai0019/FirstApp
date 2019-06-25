package com.example.firstapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DialogsDemoActivity extends AppCompatActivity {

    TextView tv1;
    Button bt1;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs_demo);

        tv1=findViewById(R.id.tv1);
        bt1=findViewById(R.id.bt1);

        pd=new ProgressDialog(this);
        pd.setTitle("Download Status");
        pd.setMessage("Downloading from www.abc.com");
        pd.setIcon(R.drawable.two);
        pd.setCancelable(false);

        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tv1.setText(Math.random()+"");
                Toast.makeText(DialogsDemoActivity.this, "hello world", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void go2(View v)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("This is Title");
        builder.setMessage("This is Message");
        builder.setIcon(R.drawable.one);

        builder.setCancelable(false);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                          tv1.setText("Ok Clicked");
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                  tv1.setText("Cancel Clicked");
            }
        });

        AlertDialog ad = builder.create();
        ad.show();
    }

    public void go3(View view) {

        pd.show();
        //pd.setProgress(50);

        Thread t=new Thread(new myjob());
        t.start();
    }

    class myjob implements Runnable
    {
        @Override
        public void run() {
            for(int i=1;i<=100;i++)
            {
                pd.setProgress(i);

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            pd.dismiss();
        }
    }

}
