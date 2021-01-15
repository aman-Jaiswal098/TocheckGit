package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Set;

public class Product_page extends AppCompatActivity {


    SQLiteDatabase sqdb;
    SQLite sqLite;

    ImageView imageView , click_to_addcart;
    View addpro;
TextView dressName, sareesName, price;

//    int count = 0;

    ArrayList<String> addproduct = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        imageView=findViewById(R.id.return_to_main);
        click_to_addcart = findViewById(R.id.click_to_addcart);
        dressName =  findViewById(R.id.DressName);
        sareesName = findViewById(R.id.sareesName);
        price = findViewById(R.id.price);
        addpro =  findViewById(R.id.buyproduct);
        TextView buyView = findViewById(R.id.buy);
        sqLite =new SQLite(this);
        sqdb = sqLite.getWritableDatabase();

        RoundedImageView RoundedImageView = findViewById(R.id.roundedImageView);
        final String Image=getIntent().getStringExtra("imageName");
        final String Name =getIntent().getStringExtra("SariName") ;
        final String Price = getIntent().getStringExtra("price");
        dressName.setText(Name);
    buyView.setText(Price);

        Picasso.get().load(Image).fit().centerInside().into(RoundedImageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
finish();
                Toast.makeText(getApplicationContext(),"Close",Toast.LENGTH_SHORT).show();
            }
        });
        addpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                count++;
//                addproduct.add(Image);
//                addproduct.add(String.valueOf(count));
//                addproduct.add(Name);

//                Intent n= new Intent(getApplicationContext(),cart_add.class);
//                n.putExtra("Image",Image);
//                n.putExtra("Name",Name);
//                n.putExtra("Count",String.valueOf(count));
////
////                Log.d("dataComming", String.valueOf(addproduct));
//                startActivity(n);
//                Log.d("dataComming", String.valueOf(addproduct));
//                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                SharedPreferences.Editor editor = sharedPrefs.edit();
//                editor.putString("Image", Image);
//                editor.putString("Name", Name);
//                editor.putString("count",String.valueOf(count));
//                editor.commit();
                Toast.makeText(getApplicationContext(),"Thank You !",Toast.LENGTH_SHORT).show();

            }
        });


        click_to_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Image=getIntent().getStringExtra("imageName");
                final String Name =getIntent().getStringExtra("SariName") ;
                final String Price = getIntent().getStringExtra("price");
                dressName.setText(Name);


                String insertQuery = "INSERT INTO " + sqLite.TABLE_NAME + " VALUES('" + (Name.toString()) + "','" + Image +
                        "');";
                sqdb.execSQL(insertQuery);

                Log.d("datetime", Name);
                Log.d("datetime2", Image);
                Toast.makeText(getApplicationContext(),"Added to Cart",Toast.LENGTH_LONG).show();

            }
        });





    }


}