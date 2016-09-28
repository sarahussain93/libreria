package com.example.sara.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class delete_activity extends AppCompatActivity {

    EditText name;


    DatabaseAdapter DatabaseAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_activity);

        // create a instance of SQLite Database
        DatabaseAdapter=new DatabaseAdapter(this);
        DatabaseAdapter=DatabaseAdapter.open();

        // Edit Text
        name = (EditText) findViewById(R.id.nome);

        // Create button
        Button aggiungi = (Button) findViewById(R.id.elimina);

        // button click event
        aggiungi.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                final Dialog dialog = new Dialog(delete_activity.this);
                dialog.setContentView(R.layout.activity_delete_activity);
                dialog.setTitle("Elimina");

                String nome = name.getText().toString();

                // creating new product
                DatabaseAdapter.deleteEntry(nome);
                Toast.makeText(delete_activity.this, "Eliminato con successo", Toast.LENGTH_LONG).show();
                finish();
                dialog.dismiss();
            }
        });

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        DatabaseAdapter.close();
    }



}