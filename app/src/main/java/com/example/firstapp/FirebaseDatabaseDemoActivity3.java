package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseDemoActivity3 extends AppCompatActivity {


    DatabaseReference mainref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database_demo3);

        //This should be the first line to use Firebase
        FirebaseApp.initializeApp(this);

        //This Refers to Firebase Database Service
        FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();

        //Create a Reference to "student"
        mainref = firebaseDatabase.getReference("student");
    }

    public void go(View v)
    {
        Student3 obj=new Student3();
        obj.setRollno(4);
        obj.setName("AMRINDER");
        obj.setMarks(99);

        mainref.child("4").setValue(obj);

        Toast.makeText(this, "Record Added", Toast.LENGTH_SHORT).show();
    }

    public void go2(View v)
    {
        Student3 obj2=new Student3();
        obj2.setRollno(4);
        obj2.setName("RAHUL");
        obj2.setMarks(95);

        mainref.child("4").setValue(obj2);

        Toast.makeText(this, "Rollno 4 Updated", Toast.LENGTH_SHORT).show();



    }

    public void go3(View v)
    {
        mainref.child("4").removeValue();

        Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
    }

    public void go4(View v)
    {
        mainref.child("4").child("marks").setValue(85);

        Toast.makeText(this, "Marks Updated", Toast.LENGTH_SHORT).show();
    }
}
