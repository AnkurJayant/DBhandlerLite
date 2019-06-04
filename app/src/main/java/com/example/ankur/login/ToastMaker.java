package com.example.ankur.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ToastMaker extends AppCompatActivity{

    public void ToastMethod(Context c,String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();

    }
}