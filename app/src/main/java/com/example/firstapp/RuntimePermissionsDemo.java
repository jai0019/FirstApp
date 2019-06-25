package com.example.firstapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RuntimePermissionsDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permissions_demo);
    }

    public void go(View view)
    {

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
        {

            //Check If Permissions are already granted, otherwise show Ask Permission Dialog
            if(checkPermission())
            {
                Toast.makeText(this, "All Permissions Already Granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
                requestPermission();
            }

        }
    }

    public boolean checkPermission()
    {
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED;
        boolean result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
        boolean result3 = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)== PackageManager.PERMISSION_GRANTED;

        return result1 && result2 && result3 ;
    }


    public void requestPermission()
    {

        //Show ASK FOR PERSMISSION DIALOG (passing array of permissions that u want to ask)

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECEIVE_SMS }, 1);
    }

// After User Selects Desired Permissions, thid method is automatically called

    // It has request code, permissions array and corresponding grantresults array

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1)
        {
            if(grantResults.length>0)
            {

                if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED && grantResults[2]==PackageManager.PERMISSION_GRANTED  )
                {
                    Toast.makeText(this, "All PERMISSON GRANTED", Toast.LENGTH_SHORT).show();
                }

                if(grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(this,"Call Permission Granted",Toast.LENGTH_SHORT).show();

                }


                if(grantResults[1]==PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();

                }

                if(grantResults[2]==PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(this, "SMS Permission Granted", Toast.LENGTH_SHORT).show();

                }


                if(grantResults[0]==PackageManager.PERMISSION_DENIED  && grantResults[1]==PackageManager.PERMISSION_DENIED && grantResults[2]==PackageManager.PERMISSION_DENIED )
                {
                    Toast.makeText(this, "All Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }

        }



    }


}
