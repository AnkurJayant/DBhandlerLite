package com.example.ankur.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DBHelper extends SQLiteOpenHelper{
    public static final String DB_Name="Seminar.db";
    public static final String Table_Name="Seminar";
    public static final String col_1="Sem_id";
    public static final String col_2="Date";
    public static final String col_3="Topic";
    public static final String col_4="Name_Of_ORG";
    public static final String col_5="Dept";
    public static final String col_6="No_Of_Students";
    SQLiteDatabase mydb=getWritableDatabase();
    String Query = "create tabl"+Table_Name + "(Sem_id INTEGER PRIMARY KEY AUTOINCREMENT,Date dat,Topic varchar(25),Name_Of_ORG varchar(30),Dept varchar(20),No_Of_Students INTEGER)";
    public DBHelper(Context context) {
        super(context, DB_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
        onCreate(db);
    }
    public boolean insertData(String date,String topic,String ORG/*,String deptment,int numb*/){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col_2,date);
        cv.put(col_3,topic);
        cv.put(col_4,ORG);
        /*cv.put(col_5,deptment);
        cv.put(col_6,numb);*/
        long result=myDB.insert(Table_Name,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }

}
