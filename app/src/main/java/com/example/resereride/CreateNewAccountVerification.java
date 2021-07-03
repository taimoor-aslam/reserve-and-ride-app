package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CreateNewAccountVerification extends AppCompatActivity {
ImageButton backbtn;
Button continuebtn;
ImageView editnmbr;
Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account_verification);
        backbtn=(ImageButton) findViewById(R.id.backicon);
        continuebtn=(Button) findViewById(R.id.continuebtn);
        editnmbr=(ImageView) findViewById(R.id.editicon);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(CreateNewAccountVerification.this,CreateNewAccount.class);
                Intent intent=getIntent();
                it.putExtra("phone",intent.getExtras().getString("phone"));
                startActivity(it);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(CreateNewAccountVerification.this,CreateNewAccountPhoneGetting.class);
                startActivity(it);
            }
        });
        //code is'nt done
        editnmbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(CreateNewAccountVerification.this,CreateNewAccountPhoneGetting.class);
                startActivity(it);

            }
        });
    }
}
