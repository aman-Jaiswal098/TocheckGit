package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class cart_add extends AppCompatActivity {

    SQLiteDatabase sqdb;
    SQLite sqLite;
    String todelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_add);
        ImageView imageView = findViewById(R.id.card_imge);
        TextView textView = findViewById(R.id.card_name);
        TextView remove = findViewById(R.id.remove);
        sqLite =new SQLite(this);



        String selectQuery = "SELECT  * FROM " + "stud_table";
        sqdb = sqLite.getReadableDatabase();

        Cursor cursor =sqdb.rawQuery(selectQuery,null);
        long count = DatabaseUtils.queryNumEntries(sqdb, sqLite.TABLE_NAME);
        Log.d("deleteQuery1", String.valueOf(count));
        if(cursor.moveToFirst())
        {
            do {

               String y =cursor.getString(0);
                todelete=y;
                Picasso.get().load(cursor.getString(1)).into(imageView);
                textView.setText(cursor.getString(0));
//                Log.d("datamila", x);
            }while(cursor.moveToNext());
        }

//        Intent data=getIntent();
//       data.getStringArrayExtra("Image");
//        data.getStringArrayExtra("Name");
//        String Name = getIntent().getStringExtra("Name");
//        String Image = getIntent().getStringExtra("Image");
//        textView.setText(Name);
//        Picasso.get().load(Image).into(imageView);
////        String Name = getIntent().getStringExtra("Name");


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sqdb.delete(sqLite.TABLE_NAME, "NAME"+ "=" + todelete, null);
                sqdb.execSQL("delete from "+sqLite.TABLE_NAME+" where Name='"+todelete+"'");
                long count = DatabaseUtils.queryNumEntries(sqdb, sqLite.TABLE_NAME);


                Log.d("deleteQuery", String.valueOf(count));
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Removed",Toast.LENGTH_SHORT).show();

            }
        });


    }
}