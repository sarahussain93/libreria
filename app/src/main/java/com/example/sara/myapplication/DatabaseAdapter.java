package com.example.sara.myapplication;

/**
 * Created by sara on 21/09/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    static final String DATABASE_NAME = "libreria.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "libri" + "( "
            + "id" + " integer primary key autoincrement,"
            + "nome  text,autore text,isbn text); ";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;
    private Cursor cursor;

    public DatabaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public DatabaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String name, String author,String isbn) {
        ContentValues newValues = new ContentValues();
        newValues.put("nome", name);
        newValues.put("autore",author);
        newValues.put("isbn",isbn);
        db.insert("libri", null, newValues);

    }

    public int deleteEntry(String nome) {

        String where = "nome=?";
        int numberOFEntriesDeleted = db.delete("libri", where,
                new String[] { nome });
        return numberOFEntriesDeleted;
    }

    /*public Cursor getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (db == null) {
            return null;
        }
        return db.rawQuery("select * from libri order by nome", null);
    }*/
    public List<String> getAllRecord() {
        List<String> studentList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + "libri";
        db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                studentList.add(cursor.getString(0));
                studentList.add(cursor.getString(1));
                studentList.add(cursor.getString(2));
                studentList.add(cursor.getString(3));
            } while (cursor.moveToNext());
        } db.close();
        return studentList;
    }


    /*public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?",
                new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }*/

    public void updateEntry(String name, String author,String isbn) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("nome", name);
        updatedValues.put("autore", author);
        updatedValues.put("isbn", isbn);

        String where = "nome = ? ";
        db.update("libri", updatedValues, where, new String[] { name });
    }


}