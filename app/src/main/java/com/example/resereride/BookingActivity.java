package com.example.resereride;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {
    EditText goingfromedt,goingtoedt,srchbus;
    Button donebtn;
    Intent it;
    Intent intentData=getIntent();
    final int ACTICVITY_CONSTANT=1000;
    final int ACTIVITY_CONSTANT1=2000;
    final int ACTIVITY_CONSTANT2=3000;

    final Calendar myCalender=Calendar.getInstance();
    EditText datepickereEdt;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        goingfromedt=(EditText) findViewById(R.id.bookingedt1);
        goingtoedt=(EditText) findViewById(R.id.bookingedt2);
        srchbus=(EditText) findViewById(R.id.bussericeedt);
        donebtn=(Button) findViewById(R.id.bookingbtn);
        datepickereEdt=(EditText) findViewById(R.id.bookingedt3);
       date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH,month);
                myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLable();
            }

           private void updateLable() {
                String myFormat="MM/dd/yy";
                SimpleDateFormat sdf=new SimpleDateFormat(myFormat, Locale.US);
               datepickereEdt.setText(sdf.format(myCalender.getTime()));
           }
       };
        datepickereEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(BookingActivity.this,date,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        goingtoedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(BookingActivity.this,CitiesDisplayActivity.class);
                startActivityForResult(it,ACTICVITY_CONSTANT);
            }
        });
        goingfromedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(BookingActivity.this,CitiesDisplayActivity.class);
                startActivityForResult(it,ACTIVITY_CONSTANT1);

            }
        });
        srchbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(BookingActivity.this,BusServices.class);
                startActivityForResult(it,ACTIVITY_CONSTANT2);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
         //   Toast.makeText(getApplicationContext(),"Hollo",Toast.LENGTH_SHORT).show();
            if (resultCode == RESULT_OK && requestCode == ACTICVITY_CONSTANT) {
                if (data.hasExtra("ClickedBus")) {
                    goingtoedt.setText(data.getStringExtra("ClickedBus"));
                }
            } else if (resultCode == RESULT_OK && requestCode == ACTIVITY_CONSTANT1) {
                if (data.hasExtra("ClickedBus")) {
                    goingfromedt.setText(data.getStringExtra("ClickedBus"));
                }
            }
            else if(resultCode==RESULT_OK&& requestCode==ACTIVITY_CONSTANT2)
            {
                if(data.hasExtra("serviceName"))
                {
                  //  Toast.makeText(getApplicationContext(),"Hollo",Toast.LENGTH_SHORT).show();
                    srchbus.setText(data.getStringExtra("serviceName"));
                }
            }
        } catch (Exception e) {
            Toast.makeText(this,"Sorry No Route Available",Toast.LENGTH_SHORT).show();
        }
    }
}
