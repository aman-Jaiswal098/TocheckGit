package com.example.musicplayer;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.opengl.GLDebugHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;




public class SQLite extends SQLiteOpenHelper {
    private  static  final String DATABASE_NAME="cart_database.db";
    public  static final String TABLE_NAME = "stud_table";
//    public  static  final  String PRODUCTNO = "productNo";
    public  static  final  String NAME = "name";
    public  static  final  String IMAGES = "images";
    private  static  final  int DATABASE_VERSION = 1;




    public SQLite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    public SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }
//
//    public SQLite(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {

db.execSQL("CREATE TABLE "+TABLE_NAME+"("+NAME+" VARCHAR(25),"+IMAGES+" VARCHAR(500))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
