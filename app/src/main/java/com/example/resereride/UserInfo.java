package com.example.resereride;

import android.content.pm.PackageManager;

public class UserInfo {
    private String Name,Email,Phone,Password,Gender;
    UserInfo(String name,String email,String phone,String password,String gender)
    {
        Name=name;
        Email=email;
        Phone=phone;
        Password=password;
        Gender=gender;
    }
    public void setPhone(String phone)
    {
        Phone=phone;
    }

}
