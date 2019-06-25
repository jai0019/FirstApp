package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class VolleyDemo3 extends AppCompatActivity {

    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_demo3);

        tv1=findViewById(R.id.tv1);

    }

    public void go(View v)
    {
        String s= "[ " +
                   "{\"tid\":0,\"name\":\"new name\",\"photo\":\"http://vmmeducation.com/vmmrestapi/tphotos/0.jpg\"}," +
                   "{\"tid\":1,\"name\":\"kamal kumar\",\"photo\":\"http://vmmeducation.com/vmmrestapi/tphotos/1.jpg\"}," +
                   "{\"tid\":2,\"name\":\"raman kumar\",\"photo\":\"http://vmmeducation.com/vmmrestapi/tphotos/2.jpg\"}," +
                   "{\"tid\":3,\"name\":\"sandeep singh\",\"photo\":\"http://vmmeducation.com/vmmrestapi/tphotos/3.jpg\"}," +
                   "{\"tid\":4,\"name\":\"komal sharma\",\"photo\":\"http://vmmeducation.com/vmmrestapi/tphotos/4.jpg\"}  " +
                   "  ]";

        Gson gson=new Gson();

        List<Teacher> al  = Arrays.asList(   gson.fromJson(s, Teacher[].class) );

        //tv1.setText("SIZE of List "+al.size());

        for(Teacher tc: al)
        {
            tv1.append(tc.tid+" "+tc.name+" "+tc.photo+"\n");
        }

    }

    public void go2(View v)
    {
        String url="http://vmmeducation.com/allteachers";

        StringRequest request2=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson=new Gson();

                List<Teacher> al = Arrays.asList( gson.fromJson(response, Teacher[].class) );

                for(Teacher tc: al)
                {
                    tv1.append(tc.tid+" "+tc.name+" "+tc.photo+"\n");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv1.setText(error.toString());
            }
        });

        //Send Request
        Volley.newRequestQueue(this).add(request2);

    }

    public void go3(View v)
    {
        //192.168.43.70
      //  http://192.168.43.70:8084/AdvJava2019_AJAX/FetchAllStudents
        String url="http://172.16.0.108:8084/AdvJava2019_AJAX/FetchAllStudents";

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
                    List<Student2> al = Arrays.asList( gson.fromJson( s , Student2[].class)  );

                    tv1.setText("");
                    for(Student2 st: al)
                    {
                        tv1.append( st.rollno+" "+st.name+" "+st.marks+" "+st.photo+"\n" );
                    }

                }
                catch(Exception ex) {

                    ex.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv1.setText(error.toString());
            }
        });

        //Send Request
        Volley.newRequestQueue(this).add(request2);

    }

}
