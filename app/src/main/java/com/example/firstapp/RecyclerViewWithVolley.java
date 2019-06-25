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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecyclerViewWithVolley extends AppCompatActivity
{

    List<Teacher> al=new ArrayList<>();

    RecyclerView rcv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view_with_volley);

        rcv=(RecyclerView)(findViewById(R.id.rcv1));

        final MyRecyclerAdapter myad=new MyRecyclerAdapter();

        rcv.setAdapter(myad);

        //Specifying Layout Manager to RecyclerView is Compulsary for Proper Rendering

        LinearLayoutManager simpleverticallayout= new LinearLayoutManager(this);
        rcv.setLayoutManager(simpleverticallayout);

        Log.d("MYMESSAGE","On Create of RecyclerView Demo Called");


        String url="http://vmmeducation.com/viewteachers";

        StringRequest request2=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    //Extract ans array from mainjson object
                    JSONObject mainjson = new JSONObject(response);
                    JSONArray ar = mainjson.getJSONArray("ans");
                    String s=ar.toString();

                    // now convert jsonarray to java list
                    Gson gson=new Gson();
                    al = Arrays.asList( gson.fromJson( s ,Teacher[].class)  );

                   //Refresh Adapter
                   myad.notifyDataSetChanged();

                }
                catch(Exception ex) {

                    ex.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MYMESSAGE",error.toString());
            }
        });

        //Send Request
        Volley.newRequestQueue(this).add(request2);

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

            Teacher tc=al.get(position);

            tv1.setText("Tid "+tc.tid);
            tv2.setText("Name "+tc.name);
            Picasso.with(getApplicationContext()).load(tc.photo).resize(200,100).into(imv1);

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

