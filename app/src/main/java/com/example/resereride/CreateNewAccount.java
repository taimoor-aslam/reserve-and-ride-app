package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.mikhaellopez.circularimageview.CircularImageView;

public class CreateNewAccount extends AppCompatActivity {
    EditText namedt,emailedt,passwordedt,cnic;
    RadioGroup gender;
    CircularImageView circularImageView;
    String sex;
    RadioButton btn;
    Button signupbtn;
    Intent intent;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        namedt=(EditText) findViewById(R.id.fullnameedt);
        emailedt=(EditText) findViewById(R.id.emailedt);
        passwordedt=(EditText) findViewById(R.id.passedt);
        cnic=(EditText) findViewById(R.id.cnicedt);
        gender=(RadioGroup) findViewById(R.id.radiobtngrp);
        circularImageView=(CircularImageView) findViewById(R.id.myimage);
        db=new MyDatabase(this);
        signupbtn=(Button) findViewById(R.id.signupbtn);
        /** design circular image **/
        loadCircularImage(circularImageView);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertIntoDB();
                intent=new Intent(CreateNewAccount.this,BookingActivity.class);
                startActivity(intent);
            }
        });

    }
   public void InsertIntoDB()
   {
       String name=namedt.getText().toString();
       intent=getIntent();
       String phone=intent.getStringExtra("phone");
       String email=emailedt.getText().toString();
       String passcode=passwordedt.getText().toString();
       String Cnic=cnic.getText().toString();
       gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               btn=(RadioButton) findViewById(checkedId);
               sex=btn.getText().toString();
           }
       });
       try {
           db.insert(name, phone, Cnic, email, passcode, sex);
       }catch (Exception e)
       {
           Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
       }
   }
    /** CircularImageView code we have used third party library for it**/
    public void loadCircularImage(CircularImageView circularImageView)
    {
        // Set Color
        circularImageView.setCircleColor(Color.WHITE);
// or with gradient
        circularImageView.setCircleColorStart(Color.BLACK);
        circularImageView.setCircleColorEnd(Color.RED);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);
// or with gradient
        circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Add Shadow with default param
        circularImageView.setShadowEnable(true);
// or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.RED);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);
    }
    /** Circular Image code ends here **/
}
