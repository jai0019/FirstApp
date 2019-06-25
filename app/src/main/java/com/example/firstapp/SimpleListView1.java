package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SimpleListView1 extends AppCompatActivity {

    ArrayList<String> al=new ArrayList<>();

    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view1);

        al.add("C");
        al.add("Java");
        al.add("Python");
        al.add("PHP");
        al.add("Android");
        al.add("C++");
        al.add("NodeJS");
        al.add("Swift");
        al.add("Kotlin");
        al.add("C");
        al.add("Java");
        al.add("Python");
        al.add("PHP");
        al.add("Android");
        al.add("C++");
        al.add("NodeJS");
        al.add("Swift");
        al.add("Kotlin");

        lv1=findViewById(R.id.lv1);

        ArrayAdapter<String> ad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, al);

        lv1.setAdapter(ad);
    }
}
