package com.example.firstapp;


import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.CardView;

import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.StaggeredGridLayoutManager;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.LinearLayout;

import android.widget.TextView;

import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;



public class RecyclerViewWithCardView extends AppCompatActivity
{

    ArrayList<Student2> al=new ArrayList<>();

    RecyclerView rcv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view_with_card_view);

        al.add(new Student2(1,"abc",90,"https://picsum.photos/300/200/?random&q=1"));
        al.add(new Student2(2,"Shalinder",92,"https://picsum.photos/300/200/?random&q=2"));
        al.add(new Student2(3,"Rahul",89,"https://picsum.photos/300/200/?random&q=3"));
        al.add(new Student2(1,"abc",90,"https://picsum.photos/300/200/?random&q=4"));
        al.add(new Student2(2,"Shalinder",92,"https://picsum.photos/300/200/?random&q=5"));
        al.add(new Student2(3,"Rahul",89,"https://picsum.photos/300/200/?random&q=6"));



        rcv=(RecyclerView)(findViewById(R.id.rcv1));

        MyRecyclerAdapter myad=new MyRecyclerAdapter();

        rcv.setAdapter(myad);


        //Specifying Layout Manager to RecyclerView is Compulsary for Proper Rendering

        LinearLayoutManager simpleverticallayout= new LinearLayoutManager(this);
        rcv.setLayoutManager(simpleverticallayout);

        Log.d("MYMESSAGE","On Create of RecyclerView Demo Called");

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

            View viewthatcontainscardview = inflater.inflate(R.layout.singlerow5,parent,false);

            CardView cardView = (CardView) (viewthatcontainscardview.findViewById(R.id.cardview1));


            // This will call Constructor of MyViewHolder, which will further copy its reference

            // to customview (instance variable name) to make its usable in all other methods of class

            Log.d("MYMESSAGE","On CreateView Holder Done");

            return new MyViewHolder(cardView);

        }


        @Override
        public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, final int position) {

            CardView localcardview = holder.singlecardview;

            localcardview.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(),position+" clicked",Toast.LENGTH_LONG).show();

                }

            });


            TextView tv1,tv2;
            ImageView imv1;

            tv1=(TextView)(localcardview.findViewById(R.id.tv111));
            tv2=(TextView)(localcardview.findViewById(R.id.tv222));
            imv1=(ImageView)(localcardview.findViewById(R.id.imv111));

            Student2 st=al.get(position);

            tv1.setText("Rollno "+st.getRollno());
            tv2.setText("Name "+st.getName());
            Picasso.with(getApplicationContext()).load(st.photo).resize(200,100).into(imv1);

            Log.d("MYMESSAGE","On Bind Of View Holder Called");

        }


        @Override
        public int getItemCount() {
            Log.d("MYMESSAGE","get Item Count Called");
            return al.size();
        }

    }

    ////////////////////////////



    public void go(View v)
    {

        //Specifying Layout Manager to RecyclerView is Compulsary for Proper Rendering

        LinearLayoutManager simpleverticallayout= new LinearLayoutManager(this);
        rcv.setLayoutManager(simpleverticallayout);

    }


    public void go2(View v)
    {

        // Change Layout Manager of Recycler View

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        rcv.setLayoutManager(gridLayoutManager);



    }



}

