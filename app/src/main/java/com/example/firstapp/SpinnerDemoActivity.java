package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SpinnerDemoActivity extends AppCompatActivity {


    ArrayList<Student> al = new ArrayList<>();
    Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

        al.add(new Student(1,"ABC","http://lorempixel.com/400/200/"));
        al.add(new Student(2,"DEF","http://lorempixel.com/400/200/sports/"));
        al.add(new Student(3,"XYZ","http://lorempixel.com/400/200/sports/Dummy-Text/"));
        al.add(new Student(4,"MNO","http://lorempixel.com/400/200/sports"));
        al.add(new Student(5,"MNO","http://lorempixel.com/400/200/sports"));
        al.add(new Student(6,"MNO","http://lorempixel.com/400/200/sports"));
        al.add(new Student(7,"MNO","http://lorempixel.com/400/200/sports"));

        sp1 = (findViewById(R.id.sp1));

        myadapter myad = new myadapter();

        sp1.setAdapter(myad);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SpinnerDemoActivity.this, position+" Selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




    class myadapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return al.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position*10;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView==null) {
                LayoutInflater l = LayoutInflater.from(getApplicationContext());
                convertView = l.inflate(R.layout.single_row_design, parent, false);
            }

            ImageView imv_photo = convertView.findViewById(R.id.imv_photo);
            TextView tv_rn = convertView.findViewById(R.id.tv_rn);
            TextView tv_name = convertView.findViewById(R.id.tv_name);

            Student s = al.get(position);

            tv_rn.setText(s.rn+"");
            tv_name.setText("Name : "+s.name);
            Picasso.with(getApplicationContext()).load(s.photo).into(imv_photo);

            return convertView;
        }
    }


}
