package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BusServices extends AppCompatActivity {
//TextView txt1;
//Intent it;
//String username;
//Spinner sp1;
//Spinner sp2;
//ArrayAdapter<String> adp;
//
//String [] cities={"To","Lahore","Islamabad","Karachi","Vehari","Faislabad","Multan","Bahawalpur"};
//String[] cities2={"From","Lahore","Islamabad","Karachi","Vehari","Faislabad","Multan","Bahawalpur"};
    private RecyclerView myRecyleView;
    private MyAdap mytRecycleAdap;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_servise);
//        txt1=(TextView) findViewById(R.id.txt1);
//        it=getIntent();
//        username=it.getStringExtra("username");
//        txt1.setText("Hello "+username);
//        sp1=(Spinner) findViewById(R.id.sp1);
//        sp2=(Spinner) findViewById(R.id.sp2);
//        adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities);
//        sp1.setAdapter(adp);
//        adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities2);
//        sp2.setAdapter(adp);
        myRecyleView=(RecyclerView) findViewById(R.id.recycleriew);
        myRecyleView.setHasFixedSize(true);
        myRecyleView.setLayoutManager(new LinearLayoutManager(this));
       // myRecyleView.setLayoutManager(myRecylceManager);
        String servicesName[]={"Faisal Movers","Skyways","Daewoo","Niazi Express","Shauja Express","Bilal Travels",
       "Sandhu Express","New Khan","Crystal Lines","Power International","Mian Coaches","Kohistan","Rajput Travels","Bahawalpur Express"
        ,"New Subhan","ITC Cruzer"};
        mytRecycleAdap=new MyAdap(servicesName);
        myRecyleView.setAdapter(mytRecycleAdap);



    }
}
