package com.example.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseDemoActivity extends AppCompatActivity {

    TextView tv1;
    DatabaseReference mainref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database_demo);

        tv1=findViewById(R.id.tv1);

        //This should be the first line to use Firebase
        FirebaseApp.initializeApp(this);

        //This Refers to Firebase Database Service
        FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();

        //Create a Reference to "student"
        mainref = firebaseDatabase.getReference("student");
    }

    public void go(View v)
    {
        //Fetch all data under "student"
        mainref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tv1.setText(dataSnapshot.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
