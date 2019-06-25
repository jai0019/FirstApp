package com.example.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseDemoActivity2 extends AppCompatActivity {

    DatabaseReference mainref;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database_demo2);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

        FirebaseApp.initializeApp(this);

        FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();

        mainref =  firebaseDatabase.getReference("student");

        mainref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tv1.setText(dataSnapshot.toString());

                tv2.setText("");

               for(DataSnapshot singlestudentdata: dataSnapshot.getChildren())
               {
                   Student3 st = singlestudentdata.getValue(Student3.class);

                   tv2.append(st.rollno+" "+st.name+" "+st.marks+"\n");
               }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
