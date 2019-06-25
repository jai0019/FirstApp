package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class AutoCompleteDemo extends AppCompatActivity {

    ArrayList<String> al=new ArrayList<>();

    AutoCompleteTextView atv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_demo);

        al.add("amritsar");
        al.add("ludhiana");
        al.add("jalandhar");
        al.add("ambala");
        al.add("chandigarh");
        al.add("delhi");
        al.add("mumbai");
        al.add("pune");
        al.add("vellore");
        al.add("banglore");
        al.add("kochi");
        al.add("chennai");
        al.add("noida");
        al.add("gurgaon");
        al.add("kashmir");
        al.add("gujrat");

        atv1=findViewById(R.id.atv1);

        ArrayAdapter<String> myad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);

        atv1.setAdapter(myad);

    }
}
