package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class Test extends AppCompatActivity {
    TextView test;
    MyDatabase dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        test=(TextView) findViewById(R.id.test);
        dataBaseHelper=new MyDatabase(this);
        test.setText(dataBaseHelper.show());
    }
}
