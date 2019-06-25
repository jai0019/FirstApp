package com.example.firstapp;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class FirbaseStorageDemo1 extends AppCompatActivity {

    StorageReference mainref;

    TextView tv1;
    ImageView imv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firbase_storage_demo1);

        tv1=findViewById(R.id.tv1);
        imv1=findViewById(R.id.imv1);

        FirebaseApp.initializeApp(this);

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        // Reference to main Bucket
        mainref = firebaseStorage.getReference();
    }

    public void go(View v)
    {
        StorageReference myfile = mainref.child("Desert.jpg");

        Task<StorageMetadata> mytask =   myfile.getMetadata();

        mytask.addOnSuccessListener(new OnSuccessListener<StorageMetadata>() {
            @Override
            public void onSuccess(StorageMetadata storageMetadata) {
                tv1.setText( storageMetadata.getName()+"\n"+
                             storageMetadata.getPath()+"\n"+
                             storageMetadata.getContentType()+"\n"+
                             storageMetadata.getSizeBytes() );
            }
        });

        mytask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                tv1.setText(e.toString());
            }
        });

    }


    public void go2(View v)
    {
        StorageReference myfile = mainref.child("Desert.jpg");

        Task<Uri> mytask2 = myfile.getDownloadUrl();

        mytask2.addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                tv1.setText(uri.toString());
                Picasso.with(FirbaseStorageDemo1.this).load(uri.toString()).into(imv1);

            }
        });

        mytask2.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                tv1.setText(e.toString());
            }
        });

    }
}
