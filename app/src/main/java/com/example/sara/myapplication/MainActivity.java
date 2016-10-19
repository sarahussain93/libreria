package com.example.sara.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.admin);
        b2 = (Button) findViewById(R.id.utenti);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(MainActivity.this, admin_activity.class);
                startActivity(admin);
            }
        });




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(MainActivity.this, utenti_activity.class);
                startActivity(admin);
            }
        });

}


    }
