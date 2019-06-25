package com.example.firstapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_demo);
    }

    public void go(View view) {

        String CHANNEL_ID="MYCHANNEL";

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is Title");
        builder.setContentText("Hello World, How are you");
        builder.setSmallIcon(R.drawable.star);

        builder.setContentInfo("CON Info");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        builder.setLargeIcon(bmp);

        //builder.setOngoing(true);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.one);
        builder.setSound(uri);

        builder.setVibrate(new long[] { 1000,1000,1000,1000 }  );

        //Create a Pending Intent and attach with Notification
        Intent intent = new Intent(this,CameraAndGalleryActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(pendingIntent);


        Notification notif =  builder.build();

        NotificationManager notificationManager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //////////// EXTRA CODE  to Handle Oreo Devices   ///////////
        ////// Since Oreo Devices uses Notification Channels    /////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Create the NotificationChannel, but only on API 26+ because

            // the NotificationChannel class is new and not in the support library

            CharSequence name = "My Channel Name";
            String description = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(20,notif);

    }

    public void go2(View v)
    {
        String CHANNEL_ID="MYCHANNEL";

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is Title");

        builder.setSmallIcon(R.drawable.star);

        builder.setContentInfo("CON Info");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        builder.setLargeIcon(bmp);

        for(int i=0;i<=100;i=i+10) {

            builder.setProgress(100, i, false);
            builder.setContentText(i+" % downloaded");

            Notification notif = builder.build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            //////////// EXTRA CODE  to Handle Oreo Devices   ///////////
            ////// Since Oreo Devices uses Notification Channels    /////
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // Create the NotificationChannel, but only on API 26+ because

                // the NotificationChannel class is new and not in the support library

                CharSequence name = "My Channel Name";
                String description = "My Channel Description";
                int importance = NotificationManager.IMPORTANCE_MIN;

                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);

                // Register the channel with the system
                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(20, notif);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void go3(View v)
    {
        String CHANNEL_ID="MYCHANNEL";

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is Title");
        builder.setContentText("Hello World, How are you");
        builder.setSmallIcon(R.drawable.star);

        builder.setContentInfo("CON Info");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        builder.setLargeIcon(bmp);

        ////  Big Style Text Code ////
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();

        bigTextStyle.setBigContentTitle("This is Big Style Title");
        bigTextStyle.setSummaryText("This is Summary Text");
        bigTextStyle.bigText("The Quick Brown Fox Jumps Over The Lazy Dog.The Quick Brown Fox Jumps Over The Lazy Dog.The Quick Brown Fox Jumps Over The Lazy Dog.");

        builder.setStyle(bigTextStyle);
        /////////////////////////////

        Notification notif =  builder.build();

        NotificationManager notificationManager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //////////// EXTRA CODE  to Handle Oreo Devices   ///////////
        ////// Since Oreo Devices uses Notification Channels    /////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Create the NotificationChannel, but only on API 26+ because

            // the NotificationChannel class is new and not in the support library

            CharSequence name = "My Channel Name";
            String description = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_LOW;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(20,notif);

    }

    public void go4(View v)
    {
        String CHANNEL_ID="MYCHANNEL";

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is Title");
        builder.setContentText("Hello World, How are you");
        builder.setSmallIcon(R.drawable.star);

        builder.setContentInfo("CON Info");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        builder.setLargeIcon(bmp);

        ////  Big Piture Style Code ////
        NotificationCompat.BigPictureStyle bigPictureStyle= new NotificationCompat.BigPictureStyle();

        bigPictureStyle.setBigContentTitle("This is NEW Title");
        bigPictureStyle.setSummaryText("This is SUMMARY Text");

        Bitmap bigbmp = BitmapFactory.decodeResource(getResources() ,  R.drawable.five);
        bigPictureStyle.bigPicture(bigbmp);

        builder.setStyle(bigPictureStyle);
        /////////////////////////////

        Notification notif =  builder.build();

        NotificationManager notificationManager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //////////// EXTRA CODE  to Handle Oreo Devices   ///////////
        ////// Since Oreo Devices uses Notification Channels    /////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Create the NotificationChannel, but only on API 26+ because

            // the NotificationChannel class is new and not in the support library

            CharSequence name = "My Channel Name";
            String description = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_LOW;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(20,notif);
    }
}
