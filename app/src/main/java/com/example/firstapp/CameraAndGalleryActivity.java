package com.example.firstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class CameraAndGalleryActivity extends AppCompatActivity {

    ImageView imv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_and_gallery);

        imv1= findViewById(R.id.imv1);
    }

    //Camera
    public void go(View v)
    {
        Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        /*
        File f=new File("/mnt/sdcard/one.jpg");
        Uri myuri = Uri.fromFile(f);
        in.putExtra(MediaStore.EXTRA_OUTPUT,myuri);
        */

        startActivityForResult(in,80);
    }

    //Gallery
    public void go2(View v)
    {
        Intent galleryintent=new Intent(Intent.ACTION_PICK);
        galleryintent.setType("image/*");

        startActivityForResult(galleryintent,90);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent backintent) {

        if(requestCode==80)     // from Camera
        {
            if(resultCode==RESULT_OK)
            {

                 Bitmap bmp = (Bitmap)(backintent.getExtras().get("data"));
                 imv1.setImageBitmap(bmp);


                 // Method 2
                 //imv1.setImageURI(myuri);

                //imv1.setImageURI(backintent.getData());
            }
        }
        else if(requestCode==90)  // from Gallery
        {
            if(resultCode==RESULT_OK)
            {
                Uri uri = backintent.getData();
                imv1.setImageURI(uri);
            }
        }

    }
}
