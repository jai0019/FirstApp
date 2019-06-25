package com.example.firstapp;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocationDemo extends AppCompatActivity {

    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_demo);


        tv1=(TextView)(findViewById(R.id.tv1));
        tv2=(TextView)(findViewById(R.id.tv2));
        tv3=(TextView)(findViewById(R.id.tv3));


        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location lastlcgps = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location lastlcnw  = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if(lastlcgps==null)
        {
            tv1.setText("Last GPS Location NOT Availaible");
        }
        else
        {
            tv1.setText( "Last GPS Location "+  lastlcgps.getLatitude()+","+ lastlcgps.getLongitude() );
        }

        if(lastlcnw==null)
        {
            tv2.setText("Last NW Location NOT Availaible");
        }
        else
        {
            tv2.setText( "Last NW Location "+  lastlcnw.getLatitude()+","+ lastlcnw.getLongitude() );
        }

        //---check if GPS_PROVIDER is enabled---
        boolean gpsStatus = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        //---check if NETWORK_PROVIDER is enabled---
        boolean networkStatus = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        mylocationlistener ml=new mylocationlistener();

        if (gpsStatus==false && networkStatus==false)
        {
            Toast.makeText(this , "Both GPS and Newtork are disabled", Toast.LENGTH_LONG).show();

            //---display the "Location services" settings page---
            Intent in = new  Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(in);
        }

        if(gpsStatus==true)
        {
            Toast.makeText(this, "GPS is Enabled, using it", Toast.LENGTH_LONG).show();
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, ml);
        }

        if(networkStatus==true)
        {
            Toast.makeText(this, "Network Location is Enabled, using it", Toast.LENGTH_LONG).show();
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,0, ml);
        }


    }


    //Inner Class
    class mylocationlistener implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location) {

            tv3.setText("Current Location : "+  location.getLatitude()+" , "+ location.getLongitude() );

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

}
