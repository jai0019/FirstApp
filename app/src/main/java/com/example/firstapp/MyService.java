package com.example.firstapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


// Also Remember to ADD ( Foreground Service Permission ) in Manifest
// for Android 9

public class MyService extends Service {

    boolean runningflag;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

         // Start or Stop Service
         // Also Start Logic of Service

        String action = intent.getAction();
        Log.d("MYMESSAGE", action);

        if(action.equals("START SIGNAL"))
        {
            startForegroundService();
        }
        else
        {
            stopForegroundService(intent);
        }

        return super.onStartCommand(intent, flags, startId);

    }

    void startForegroundService()
    {

        //Logic to create a Foreground Service
        Notification mynotif = simpleNotification("hello","Foreground Notification Running");
        startForeground(1,mynotif);
        Log.d("MYMESSAGE", "Foreground Service Started");


        //Start Logic
        if(runningflag==false) {
            new Thread(new myjob()).start();
        }
        else
        {
            Toast.makeText(this, "Logic Already Running", Toast.LENGTH_SHORT).show();
        }
    }


    void stopForegroundService(Intent intent)
    {

        Log.d("MYMESSAGE","STOP Service Called");
        //  runningflag=false;
        stopSelf();
        stopService(intent);

    }




    public Notification simpleNotification(String title, String message)
    {

        String CHANNEL_ID=  "CHANNEL222";

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this, CHANNEL_ID);

        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.five);
        builder.setContentInfo("Con Info");

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.five);
        builder.setLargeIcon(bmp);


        // We can Specify Activity to be launched here

        Intent in=new Intent(this,MainActivity.class);
        PendingIntent pin= PendingIntent.getActivity(this,0,in,0);
        builder.setContentIntent(pin);


        // Auto Cancel Notification after click (to launch activity)
        // builder.setAutoCancel(true);

        // For Permanent Notification
        //builder.setOngoing(true);

        // EXTRA Code needed (for devcies < 8.0), since we are creating channels

        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager)(getSystemService(NOTIFICATION_SERVICE));

        Notification notification =  builder.build();



        //////////// EXTRA CODE  to Handle Oreo Devices   ///////////

        ////// Since Oreo Devices uses Notification Channels    /////

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Create the NotificationChannel, but only on API 26+ because

            // the NotificationChannel class is new and not in the support library

            CharSequence name = "My Channel Name";

            String description = "My Channel Description";

            int importance = NotificationManager.IMPORTANCE_NONE;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system

            notificationManager.createNotificationChannel(channel);

            Log.d("MYMESSAGE","NEW CODE Oreo");
        }



        // DONT Notify here
        // It will be done by ForegroundService
        //notificationManager.notify(20,notification);

        //notificationManager.cancel(20);



        return notification;

    }


    class myjob implements Runnable
    {
        @Override
        public void run() {

            runningflag=true;

            for(int i=1;i<=100;i++)
            {

                Notification notification = simpleNotification("Status",i+" % DOwnloaded");
                startForeground(1,notification);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            runningflag=false;
        }
    }
}
