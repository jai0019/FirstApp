package com.example.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FirebaseDatabaseActivity5 extends AppCompatActivity {

    RecyclerView rcv1;
    ArrayList<Student3> al;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_database5);

        al=new ArrayList<>();

        rcv1= findViewById(R.id.rcv1);

        final MyRecyclerAdapter myad=new MyRecyclerAdapter();
        rcv1.setAdapter(myad);

        LinearLayoutManager simpleverticallayout= new LinearLayoutManager(this);
        rcv1.setLayoutManager(simpleverticallayout);


        FirebaseApp.initializeApp(this);

        FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();

        DatabaseReference mainref = firebaseDatabase.getReference("student");

        mainref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                al.clear();

                for(DataSnapshot singlestudentdata: dataSnapshot.getChildren())
                {
                     Student3 st = singlestudentdata.getValue(Student3.class);
                     al.add(st);
                }

                Toast.makeText(FirebaseDatabaseActivity5.this, "SIZE "+al.size(), Toast.LENGTH_SHORT).show();

                // Refresh Adapter to show changes in RecyclerView
                myad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    /////// Inner Class  ////////

    // Create ur own RecyclerAdapter

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>
    {

        // Define ur own View Holder (Refers to Single Row)
        class MyViewHolder extends RecyclerView.ViewHolder
        {
            CardView singlecardview;

            // We have Changed View (which represent single row) to CardView in whole code

            public MyViewHolder(CardView itemView) {

                super(itemView);
                singlecardview = (itemView);
            }

        }


        // Inflate ur Single Row / CardView from XML here
        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater  = LayoutInflater.from(parent.getContext());

            View viewthatcontainscardview = inflater.inflate(R.layout.singlerow6,parent,false);

            CardView cardView = (CardView) (viewthatcontainscardview.findViewById(R.id.cardview1));


            // This will call Constructor of MyViewHolder, which will further copy its reference

            // to customview (instance variable name) to make its usable in all other methods of class

            Log.d("MYMESSAGE","On CreateView Holder Done");

            return new MyViewHolder(cardView);

        }


        @Override
        public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, final int position) {

            CardView localcardview = holder.singlecardview;


            TextView tv1,tv2,tv3;

            tv1=(TextView)(localcardview.findViewById(R.id.tv111));
            tv2=(TextView)(localcardview.findViewById(R.id.tv222));
            tv3=(TextView)(localcardview.findViewById(R.id.tv333));

            Student3 st=al.get(position);

            tv1.setText("Rollno "+st.getRollno());
            tv2.setText("Name "+st.getName());
            tv3.setText("Marks : "+st.getMarks());

            Log.d("MYMESSAGE","On Bind Of View Holder Called");

        }


        @Override
        public int getItemCount() {
            Log.d("MYMESSAGE","get Item Count Called");
            return al.size();
        }

    }

    ////////////////////////////




}
