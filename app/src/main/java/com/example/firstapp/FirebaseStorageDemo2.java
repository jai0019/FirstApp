package com.example.firstapp;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class FirebaseStorageDemo2 extends AppCompatActivity {

    StorageReference mainref;
    TextView tv1;
    ProgressBar pbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_storage_demo2);

        tv1=findViewById(R.id.tv1);
        pbar1=findViewById(R.id.pbar1);

        FirebaseApp.initializeApp(this);

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        mainref = firebaseStorage.getReference();
    }

    public void go(View v)
    {
         //Download Penguins.jpg from Cloud Storage

        //REference of File on Cloud
        StorageReference myfile = mainref.child("Penguins.jpg");

        // Local Path of File
        File localfile = new File( "/mnt/sdcard/Penguins.jpg");

        // Start Download
        FileDownloadTask  downloadTask1 =  myfile.getFile(localfile);

        downloadTask1.addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                tv1.setText("Download Complete");
                tv1.setTextColor(Color.GREEN);
            }
        });

        downloadTask1.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                tv1.setText(e.toString());
                tv1.setTextColor(Color.RED);
            }
        });

        downloadTask1.addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {

                int per = (int)  ( taskSnapshot.getBytesTransferred() *100 / taskSnapshot.getTotalByteCount());
                tv1.setText(per+" %");
                pbar1.setProgress(per);

            }
        });

    }

    public void go2(View v)
    {
        File localfile =  new File("/mnt/sdcard/one.jpg");

        if(localfile.exists())
        {
            StorageReference newfile = mainref.child("folder1/one.jpg");

            Uri uri = Uri.fromFile(localfile);
            UploadTask uploadTask1 = newfile.putFile(uri);

            uploadTask1.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    tv1.setText("UPLOAD to Cloud SUCCESSFULLY !!!");
                }
            });

            uploadTask1.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    tv1.setText(e.toString());
                }
            });

            uploadTask1.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                    int per=(int)(taskSnapshot.getBytesTransferred()*100 / taskSnapshot.getTotalByteCount());
                    tv1.setText(per+" %");
                    pbar1.setProgress(per);
                }
            });


        }
        else
        {
            Toast.makeText(this, "one.jpg not found in /mnt/sdcard", Toast.LENGTH_SHORT).show();
        }

    }
}
