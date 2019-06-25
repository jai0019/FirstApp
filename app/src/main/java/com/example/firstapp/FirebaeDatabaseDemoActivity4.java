package com.example.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaeDatabaseDemoActivity4 extends AppCompatActivity {

    DatabaseReference mainref;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebae_database_demo4);

        tv1=findViewById(R.id.tv1);
        FirebaseApp.initializeApp(this);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        mainref = firebaseDatabase.getReference("EMP");

    }

    public void go(View v)
    {
        Employee obj=new Employee(222,"AMRINDER",6000,"CSE");
        mainref.push().setValue(obj);
        Toast.makeText(this, "Record Added", Toast.LENGTH_SHORT).show();

    }

    public void go2(View v)
    {
        mainref.orderByChild("dept").equalTo("CSE").addListenerForSingleValueEvent(new ValueEventListener() {
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
