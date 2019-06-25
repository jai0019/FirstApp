package com.example.firstapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv10;
    Button bt1,bt2;
    ImageView imv1;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 =  (findViewById(R.id.tv1));
        tv2 =  (findViewById(R.id.tv2));
        tv10 = findViewById(R.id.tv10);

        bt1=   findViewById(R.id.bt1);
        bt2=   findViewById(R.id.bt2);
        imv1=  findViewById(R.id.imv1);
        et1= findViewById(R.id.et1);
        et2= findViewById(R.id.et2);

        startPermission();
    }

    //This method is called on bt1 and bt2 click
    public void go(View v)
    {
        if(v==bt1) {
            tv1.setText(Math.random() + "");
        }
        else {
            tv1.setText("HELLO WORLD");
        }
    }

    public void go2(View v)
    {
        tv1.setText("hello world");
    }


    public void go3(View view) {
        imv1.setImageResource(R.drawable.two);
    }

    public void go4(View v)
    {
         int a,b,c;
         a= Integer.parseInt(et1.getText().toString()) ;
         b= Integer.parseInt(et2.getText().toString()) ;

         c=a+b;

         tv2.setText("Sum is "+c);
    }

    public void go5(View view) {

        // Code to Launch Two Activity

        Intent in =new Intent(this,TwoActivity.class);
        startActivity(in);
    }

    public void go6(View view) {

        Intent in=new Intent(this,ThreeActivity.class);

        in.putExtra("p",123);
        in.putExtra("st","AMRINDER");
        in.putExtra("q",98.76);

        startActivity(in);

    }


    public void go7(View view) {

        Intent in=new Intent(this,FourActivity.class);

        Bundle bundle=new Bundle();
        bundle.putInt("p",1234);
        bundle.putString("st","ABCDEF");
        bundle.putDouble("q",99.12);

        in.putExtras(bundle);

        startActivity(in);

    }

    public void go8(View view) {

        Intent intent=new Intent(this,FiveActivity.class);

        Uri uri = Uri.parse("http://www.google.com");
        //Uri uri = Uri.parse("tel: 9914487487");

        intent.setData(uri);

        startActivity(intent);

    }

    public void go9(View view) {

        Intent in=new Intent(this, SixActivity.class);
        startActivity(in);
    }

    public void go10(View view)
    {

        Intent in=new Intent(this, SevenActivity.class);
        startActivityForResult(in,100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent backintent)
    {

        if(requestCode==100)    //back from SevenActivity
        {
              int ans = backintent.getIntExtra("ans",-1);
              tv10.setText( ans+"" );
        }

    }


    public void go11(View view) {

        Intent in=new Intent(this, CameraAndGalleryActivity.class);
        startActivity(in);
    }

    public void go12(View view) {

        Intent in=new Intent(this, DialogsDemoActivity.class);
        startActivity(in);
    }


    public void go13(View view) {

        Intent in=new Intent(this, SomeComponentsActivity.class);
        startActivity(in);
    }

    public void go14(View view) {

        Intent in=new Intent(this, UsingThreadActivity.class);
        startActivity(in);

    }

    public void go15(View view) {

        Intent in=new Intent(this, IODemo.class);
        startActivity(in);
    }


    public void go16(View view) {

        Intent in=new Intent(this, LifeCycleDemo.class);
        startActivity(in);

    }

    public void go17(View view) {

        Intent in=new Intent(this, SimpleListView1.class);
        startActivity(in);

    }

    public void go18(View view) {

        Intent in=new Intent(this, SimpleListView2.class);
        startActivity(in);

    }

    public void go19(View view) {

        Intent in=new Intent(this, PicassoDemo.class);
        startActivity(in);

    }
    public void go20(View view) {

        Intent in=new Intent(this, CustomListView1.class);
        startActivity(in);
    }

    public void go21(View view) {

        Intent in=new Intent(this, GridViewDemo1.class);
        startActivity(in);
    }

    public void go22(View view) {

        Intent in=new Intent(this, SpinnerDemoActivity.class);
        startActivity(in);
    }

    public void go23(View view) {

        Intent in=new Intent(this, AutoCompleteDemo.class);
        startActivity(in);
    }

    public void go24(View view) {

        Intent in=new Intent(this, NotificationsDemoActivity.class);
        startActivity(in);
    }

    public void go25(View view) {

        Intent in=new Intent(this, RuntimePermissionsDemo.class);
        startActivity(in);
    }


    public void go26(View view) {
        Intent in=new Intent(this, TwentyActivity.class);
        startActivity(in);
    }


    public void go27(View view) {
        Intent in=new Intent(this, TwentyOneActivity.class);
        startActivity(in);
    }

    public void go28(View view) {
        Intent in=new Intent(this, TwentyTwoActivity.class);
        startActivity(in);
    }

    public void go29(View view) {
        Intent in=new Intent(this, TwentyThreeActivity.class);
        startActivity(in);
    }

    public void go30(View view) {
        Intent in=new Intent(this, TwentyFourActivity.class);
        startActivity(in);
    }

    public void go31(View view) {
        Intent in=new Intent(this, TwentyFive.class);
        startActivity(in);
    }

    public void go32(View view) {
        Intent in=new Intent(this, DrawerDemoActivity.class);
        startActivity(in);
    }

    public void go33(View view) {

        Intent intent =  new Intent(this, MyService.class);
        intent.setAction("START SIGNAL");
        startService(intent);

    }

    public void go34(View view) {
        Intent intent =  new Intent(this, MyService.class);
        intent.setAction("STOP SIGNAL");
        startService(intent);
    }

    public void go35(View view) {
        Intent intent =new Intent(this, BRDemo1.class);
        startActivity(intent);
    }

    public void go36(View view) {
        Intent intent =new Intent(this, VolleyDemo1.class);
        startActivity(intent);
    }

    public void go37(View view) {
        Intent intent =new Intent(this, VolleyDemo2.class);
        startActivity(intent);
    }

    public void go38(View view) {
        Intent intent =new Intent(this, VolleyDemo3.class);
        startActivity(intent);
    }

    public void go39(View view) {
        Intent intent =new Intent(this, RecyclerViewWithCardView.class);
        startActivity(intent);
    }

    public void go40(View view) {
        Intent intent =new Intent(this, RecyclerViewWithVolley.class);
        startActivity(intent);
    }


    public void go41(View view) {
        Intent intent =new Intent(this, FirebaseDatabaseDemoActivity.class);
        startActivity(intent);
    }



    public void go42(View view) {
        Intent intent =new Intent(this, FirebaseDatabaseDemoActivity2.class);
        startActivity(intent);
    }

    public void go43(View view) {
        Intent intent =new Intent(this, FirebaseDatabaseDemoActivity3.class);
        startActivity(intent);
    }

    public void go44(View view) {
        Intent intent =new Intent(this, FirebaeDatabaseDemoActivity4.class);
        startActivity(intent);
    }

    public void go45(View view) {
        Intent intent =new Intent(this,FirebaseDatabaseActivity5.class);
        startActivity(intent);
    }

    public void go46(View view) {
        Intent intent =new Intent(this, FirbaseStorageDemo1.class);
        startActivity(intent);
    }

    public void go47(View view) {
        Intent intent =new Intent(this, FirebaseStorageDemo2.class);
        startActivity(intent);
    }

    public void go48(View view) {
        Intent intent =new Intent(this, LocationDemo.class);
        startActivity(intent);
    }

    public void go49(View view) {
        Intent intent =new Intent(this, MapsActivity.class);
        startActivity(intent);
    }



    public void startPermission()
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
        boolean result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED;
        boolean result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
        boolean result3 = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)== PackageManager.PERMISSION_GRANTED;
        boolean result4 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED;


        return result1 && result2 && result3 && result4 ;
    }


    public void requestPermission()
    {

        //Show ASK FOR PERSMISSION DIALOG (passing array of permissions that u want to ask)

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECEIVE_SMS, Manifest.permission.ACCESS_FINE_LOCATION }, 1);
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

                if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED && grantResults[2]==PackageManager.PERMISSION_GRANTED && grantResults[3]==PackageManager.PERMISSION_GRANTED  )
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

                if(grantResults[3]==PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();

                }


                if(grantResults[0]==PackageManager.PERMISSION_DENIED  && grantResults[1]==PackageManager.PERMISSION_DENIED && grantResults[2]==PackageManager.PERMISSION_DENIED && grantResults[3]==PackageManager.PERMISSION_DENIED )
                {
                    Toast.makeText(this, "All Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }

        }



    }


}
