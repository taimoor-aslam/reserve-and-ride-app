package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CitiesDisplayActivity extends AppCompatActivity {
ListView listView;
Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_display);
        listView=(ListView) findViewById(R.id.myCitiesLisiew);
        final String [] cities={"ISLAMABAD","LAHORE","BAHAWALPURE","FAISLABAD","KARACHI","MAILSI","MULTAN"};
        ArrayAdapter adap=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,cities);
        listView.setAdapter(adap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                it=new Intent();
                it.putExtra("ClickedBus",cities[position]);
                setResult(RESULT_OK,it);
                finish();
            }
        });
    }
}
