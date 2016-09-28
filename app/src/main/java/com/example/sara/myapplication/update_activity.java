package com.example.sara.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class update_activity extends AppCompatActivity {

    EditText name;
    EditText author;
    EditText iisbn;

    DatabaseAdapter DatabaseAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);

        // create a instance of SQLite Database
        DatabaseAdapter=new DatabaseAdapter(this);
        DatabaseAdapter=DatabaseAdapter.open();

        // Edit Text
        name = (EditText) findViewById(R.id.nome);
        author = (EditText) findViewById(R.id.autore);
        iisbn = (EditText) findViewById(R.id.isbn);

        // Create button
        Button aggiorna = (Button) findViewById(R.id.aggiorna);

        // button click event
        aggiorna.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                final Dialog dialog = new Dialog(update_activity.this);
                dialog.setContentView(R.layout.activity_update_activity);
                dialog.setTitle("aggiorna");

                String nome = name.getText().toString();
                String autore = author.getText().toString();
                String isbn = iisbn.getText().toString();

                // creating new product
                DatabaseAdapter.updateEntry(nome, autore, isbn);
                Toast.makeText(update_activity.this, "Aggiornato con successo", Toast.LENGTH_LONG).show();
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