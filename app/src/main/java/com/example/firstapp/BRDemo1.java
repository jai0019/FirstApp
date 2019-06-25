package com.example.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class BRDemo1 extends AppCompatActivity {

    TextView tv1;
    MYBroadcastReceiver1 MYBR1;
    MYBroadcastReceiver2 MYBR2;
    MYBroadcastReceiver3 MYBR3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brdemo1);
        tv1=findViewById(R.id.tv1);

        MYBR1 =  new MYBroadcastReceiver1();
        MYBR2 =  new MYBroadcastReceiver2();
        MYBR3 =  new MYBroadcastReceiver3();

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter1=new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(MYBR1, intentFilter1);

        IntentFilter intentFilter2=new IntentFilter(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(MYBR2, intentFilter2);

        IntentFilter intentFilter3=new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(MYBR3, intentFilter3);


        Toast.makeText(this, "BR Registered", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(MYBR1);
        unregisterReceiver(MYBR2);

    }

    //(Local BR) //

    class  MYBroadcastReceiver1 extends  BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            tv1.setText("POWER CONNECTED");
            tv1.setTextColor(Color.GREEN);

        }
    }

    class  MYBroadcastReceiver2 extends  BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            tv1.setText("POWER DISCONNECTED");
            tv1.setTextColor(Color.RED);

        }
    }

    class  MYBroadcastReceiver3 extends  BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {


            NetworkInfo networkInfo =  intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);

            if(networkInfo.isConnected())
            {
                tv1.setText("WIFI CONNECTED");
                tv1.setTextColor(Color.BLUE);
            }
            else
            {
                tv1.setText("WIFI OFF");
                tv1.setTextColor(Color.MAGENTA);
            }

        }
    }


    /////////////////



}
