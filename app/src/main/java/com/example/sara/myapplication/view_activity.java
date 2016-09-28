package com.example.sara.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class view_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);

        GridView gvproduct=(GridView)findViewById(R.id.gvproduct);
        List<String> li=new ArrayList<>();
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,li);
        dataAdapter.setDropDownViewResource(R.layout.activity_view_activity);

        try {
            SQLiteDatabase db=openOrCreateDatabase("libreria.db",MODE_PRIVATE,null);
            Cursor cr=db.rawQuery("SELECT * FROM libri",null);
            if(cr!=null) {
                if (cr.moveToFirst()) {
                    do {

                        String no = cr.getString(0);
                        String name = cr.getString(1);
                        String type = cr.getString(2);
                        String qty = cr.getString(3);


                        //li.add(no);
                        li.add(name);
                        li.add(type);
                        li.add(qty);

                        gvproduct.setAdapter(dataAdapter);
                    } while (cr.moveToNext());
                } else {
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();
                }
                cr.close();
                db.close();
            }
            }catch(Exception e)
            {
                Toast.makeText(getApplicationContext(), "No data found"+e.getMessage(), Toast.LENGTH_LONG).show();
            }

            //Toast.makeText(getBaseContext(),"Name: "+name+"Roll No: "+roll+"Course: "+course , Toast.LENGTH_LONG).show();
        }
    }

