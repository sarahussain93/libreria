package com.example.sara.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_librarian extends AppCompatActivity {


    Button view;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian);

        add = (Button) findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(activity_librarian.this, addupdel_activity.class);
                startActivity(admin);
            }
        });
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent visualizza = new Intent(activity_librarian.this, view_activity.class);
                startActivity(visualizza);
            }
        });
    }
}
