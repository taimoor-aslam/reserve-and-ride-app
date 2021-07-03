package com.example.resereride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewAccountPhoneGetting extends AppCompatActivity {
Intent it;
EditText phoneEdt;
Button continuebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account_phone_getting);
        phoneEdt=(EditText) findViewById(R.id.nmbredt);
        continuebtn=(Button) findViewById(R.id.phonebtn);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it=new Intent(CreateNewAccountPhoneGetting.this,CreateNewAccountVerification.class);
                it.putExtra("phone",phoneEdt.getText().toString());
                startActivity(it);
            }
        });

    }
}
