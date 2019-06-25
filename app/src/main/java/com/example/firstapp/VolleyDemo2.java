package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class VolleyDemo2 extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    ImageView imv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_demo2);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        imv1=findViewById(R.id.imv1);
    }

    public void go(View v)
    {
        String jsonObject = "{\"rollno\": 12,\"name\": \"abc\",\"marks\": 90}";

        //Convert JSONObject to Java Object (POJO)
        Gson gson=new Gson();
        Student2 obj = gson.fromJson(jsonObject , Student2.class );

        tv1.setText( obj.rollno+" "+obj.name+" "+obj.marks );
    }

    public void go2(View v)
    {
        String url  = "http://vmmeducation.com/teacher/1";

        //Prepare Request and Response
        StringRequest request1 = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv1.setText(response);

                Gson gson=new Gson();
                Teacher tc = gson.fromJson(response, Teacher.class);

                tv2.setText(tc.tid+"");
                tv3.setText(tc.name);
                Picasso.with(VolleyDemo2.this).load(tc.photo).into(imv1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv1.setText(error.toString());
            }
        });

        // Send Request to Server
        Volley.newRequestQueue(this).add(request1);
    }
}
