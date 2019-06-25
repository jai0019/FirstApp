package com.example.firstapp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TwentyFive extends AppCompatActivity {

    Toolbar toolbar1;
    TabLayout tabLayout;
    ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_five);

       toolbar1=findViewById(R.id.toolbar1);
       tabLayout =findViewById(R.id.tabs1);
       vp1=findViewById(R.id.vp1);

       setSupportActionBar(toolbar1);

        tabLayout.addTab( tabLayout.newTab().setText("ONE") );
        tabLayout.addTab( tabLayout.newTab().setText("TWO") );
        tabLayout.addTab( tabLayout.newTab().setText("THREE") );

        mypageradapter myad=new mypageradapter(getSupportFragmentManager());
        vp1.setAdapter(myad);

        // link tabs with viewpager
        tabLayout.setupWithViewPager(vp1);
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int i) {
            if(i==0)
                return "Contacts";
            else if(i==1)
                return "Chats";
            else
                return "Profile";

        }
    }
}
