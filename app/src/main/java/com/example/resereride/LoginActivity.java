package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btn1;
EditText edt1,edt2;
TextView forgetpassword,signup;
MyDatabase db;
Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1=(Button) findViewById(R.id.btn1);
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        forgetpassword=(TextView) findViewById(R.id.frgtpswrdtxt);
        signup=(TextView) findViewById(R.id.signuptxt);
        db=new MyDatabase(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkConnecion())
                {
                        String phone=edt1.getText().toString();
                        String password=edt2.getText().toString();
                        try {
                            if (db.verify(phone, password)) {
                                Toast.makeText(getApplicationContext(), "Login Succesfuul!", Toast.LENGTH_SHORT).show();
                                Intent it=new Intent(LoginActivity.this,BookingActivity.class);
                                startActivity(it);
                            } else {
                                edt1.setError("Wrong username or passward");
                                edt2.setError("Wrong username or passward");
                            }
                        }catch (Exception e)
                        {
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                else
                {
                    Toast.makeText(LoginActivity.this,"Please check your connection and try again",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Screen is'nt made yet
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(LoginActivity.this,CreateNewAccountPhoneGetting.class);
                startActivity(it);
            }
        });
    }
    public boolean checkConnecion()
    {
        ConnectivityManager cm=(ConnectivityManager) LoginActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo= cm.getActiveNetworkInfo();
        if(netInfo!=null&& (netInfo.getType()==cm.TYPE_WIFI||netInfo.getType()==cm.TYPE_MOBILE))
        {
            return true;
        }
        return false;
    }
}
