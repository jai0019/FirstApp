package com.example.firstapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TwentyTwoActivity extends AppCompatActivity {

    ViewPager vp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_two);

        vp1=findViewById(R.id.vp1);

        FragmentManager frm=getSupportFragmentManager();

        mypageradapter myad = new mypageradapter(frm);
        vp1.setAdapter(myad);

    }

    class mypageradapter extends FragmentPagerAdapter
    {
        mypageradapter(FragmentManager frm)
        {
            super(frm);
        }

        @Override
        public Fragment getItem(int i) {
           if(i==0)
               return new Frag1();
           else if(i==1)
               return new Frag2();
           else
               return new Frag3();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
