package com.example.sara.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class admin_activity extends AppCompatActivity{

    Button add;
    Button update;
    Button delete;
    Button view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);

        // Buttons
        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        view = (Button) findViewById(R.id.view);
        // view products click event
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(admin_activity.this, addupdel_activity.class);
                startActivity(admin);
            }
        });
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent visualizza = new Intent(admin_activity.this, view_activity.class);
                startActivity(visualizza);
            }
        });
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent visualizza = new Intent(admin_activity.this, aggiorna_activity.class);
                startActivity(visualizza);
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent visualizza = new Intent(admin_activity.this, delete_activity.class);
                startActivity(visualizza);
            }
        });
    }
}