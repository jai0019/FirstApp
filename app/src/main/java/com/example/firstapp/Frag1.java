package com.example.firstapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Frag1 extends Fragment {

    TextView tv111;
    Button bt111;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        tv111 = getActivity().findViewById(R.id.tv111);
        bt111 = getActivity().findViewById(R.id.bt111);

        bt111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv111.setText(Math.random()+"");
            }
        });

    }
}
