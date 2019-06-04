package com.example.ankur.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADD extends AppCompatActivity{

    EditText dat,top,depart,no,orgy;
    Button butt;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myDB=new DBHelper(this);

        dat=findViewById(R.id.dataa);
        top=findViewById(R.id.topix);
        depart=findViewById(R.id.dept);
        no=findViewById(R.id.numb);
        orgy=findViewById(R.id.org);
        butt=findViewById(R.id.but);
        butt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean result;
                        result=myDB.insertData(dat.getText().toString(),top.getText().toString(),orgy.getText().toString()/*,depart.getText().toString(),Integer.parseInt(no.getText().toString())*/);
                        if(result==true){
                            Toast.makeText(ADD.this, "Success", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(ADD.this,"Failure",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}