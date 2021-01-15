package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
import com.example.musicplayer.adpter.Mainadpter;
import com.example.musicplayer.adpter.sareesadpter;
//import com.example.musicplayer.adpter.sliderAdapter;
import com.example.musicplayer.adpter.sliderAdpter;
import com.example.musicplayer.model.sareesmodel;
//import com.example.musicplayer.model.sliderItem;
import com.example.musicplayer.model.sliderModel;
import android.os.AsyncTask;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class  MainActivity<SingleArray> extends AppCompatActivity {
    BottomNavigationView  bottomNavigationView;
ImageView add_cart_empty ,for_user;
    TextView textView,textView2;

    ArrayList<String> mainelist = new ArrayList<>();
//    String[] SingleArray;
//    Bundle bundle =new Bundle();
//    bundle.putStringArray("some string",SingleArray)


    ArrayList<sliderModel> sliderModelsArrayList;
    String [] countdata;

//    RequestQueue mRequestQueue;

    sliderAdpter msliderAdpter;

    RecyclerView recyclerview, recyclerView2 , sliderRecycler;
    private ImageView showSheet, addCart;
    private BottomSheetDialog bottomSheetDialog;
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recyclerview = findViewById(R.id.mainerecycler);
        recyclerView2 =findViewById(R.id.Recentlyplayed);
        sliderRecycler =findViewById(R.id.slider_re);
        for_user=findViewById(R.id.for_user);
//        Log.d("dataComming", String.valueOf(sharedPreferences.getString("count"," ")));

        add_cart_empty =findViewById(R.id.add_cart_empty);
        textView = findViewById(R.id.textView5);
//        textView2 = findViewById(R.id.count);

//      `  SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//          sharedPreferences.getString("Name",textView.getText().toString());
////        String Image2= sharedPreferences.getString("Image",textView2.getText().toString());
//          sharedPreferences.getString("count",textView2.getText().toString());`
//if( Image2 !=null && Count3!=null && Name1!=null){
//    Picasso.get().load(sharedPreferences.getString("Image"," ")).into(add_cart_empty);
//    textView.setText( String.valueOf(sharedPreferences.getString("count"," ")));
//    textView2.setText(sharedPreferences.getString("Name"," "));
//}count
//else {
//    Toast.makeText(getApplicationContext()," ",Toast.LENGTH_LONG).show();
//}
        showSheet = findViewById(R.id.openDialog);
        addCart = findViewById(R.id.add_cart);
        sliderModelsArrayList = new ArrayList<>();


        countdata = getIntent().getStringArrayExtra("CartData");
//
//        mRequestQueue = Volley.newRequestQueue(this);
//        parseJSON();

//        showSheet = findViewById(R.id.btn);
//        TextView textView = bottomSheetDialog.findViewById(R.id.getLink);





        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.page_1:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                        startActivity(intent);
                        return  true;
                    case R.id.page_2:
                        Toast.makeText(getApplicationContext(),"Categories",Toast.LENGTH_LONG).show();
                        return  true;

                    case R.id.page_3:
                        Toast.makeText(getApplicationContext(),"Notification",Toast.LENGTH_LONG).show();
                        return  true;
                    case R.id.page_4:
                        Toast.makeText(getApplicationContext(),"Serach",Toast.LENGTH_LONG).show();
                        return  true;
                }
                return false;
            }
        });
        mainelist.add("");
        mainelist.add(" ");

        recyclerview.setAdapter(new Mainadpter(mainelist,this));


//        showSheet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomSheet bottomSheet = new BottomSheet();
//                bottomSheet.show(getSupportFragmentManager(),"TAG");
//            }
//        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(getApplicationContext(),cart_add.class);
                startActivity(intent);
            }
        });

        for_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"TAG");
            }
        });




    }



}