package com.example.musicplayer.adpter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

//import com.android.volley.RequestQueue;
import com.example.musicplayer.R;
import com.example.musicplayer.model.sareesmodel;
import com.example.musicplayer.model.sliderModel;
import com.example.musicplayer.model.gownmodel;
import com.example.musicplayer.model.salwarsuitsmodel;

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
public class Mainadpter extends RecyclerView.Adapter<Mainadpter.MainView> {


    ArrayList<String> data;
    Context context;


    public Mainadpter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }




    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return R.layout.allrecyclerview;
        }
        if (position == 1){
            return R.layout.mutilple_dress;
        }

        return super.getItemViewType(position);
    }


    @NonNull
    @Override
    public Mainadpter.MainView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType,parent, false);

        return new MainView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mainadpter.MainView holder, int position) {
        holder.Alliteams(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MainView extends RecyclerView.ViewHolder {
        public MainView(@NonNull View itemView) {
            super(itemView);
        }
        public  void Alliteams(int position){
            if (position == 0){
//ArrayList<recentlyplayedmodel> recentlyplayedmodelArrayList = new ArrayList<>();
//
//    recentlyplayedmodelArrayList.add(new recentlyplayedmodel(R.drawable.img1,"Saree"));
//    recentlyplayedmodelArrayList.add(new recentlyplayedmodel(R.drawable.img2,"Saree"));
//    recentlyplayedmodelArrayList.add(new recentlyplayedmodel(R.drawable.img3,"Saree"));
//    recentlyplayedmodelArrayList.add(new recentlyplayedmodel(R.drawable.img1,"Saree"));


//
//    ((RecyclerView) itemView.findViewById(R.id.Recentlyplayed)).setAdapter(new recentlyplayedadpter(recentlyplayedmodelArrayList));

                ArrayList<salwarsuitsmodel> SalwarsuitsmodelArrayList = new ArrayList<>();
                SalwarsuitsmodelArrayList.add(new salwarsuitsmodel(R.drawable.img2,"Salwar Suit"));
                SalwarsuitsmodelArrayList.add(new salwarsuitsmodel(R.drawable.img3,"Salwar Suit"));
                SalwarsuitsmodelArrayList.add(new salwarsuitsmodel(R.drawable.img1,"Salwar Suit"));

                ((RecyclerView) itemView.findViewById(R.id.Trendingnow)).setAdapter(new salwarsuitsadpter(SalwarsuitsmodelArrayList));



                ArrayList<gownmodel> gownsmodelArrayList = new ArrayList<>();
                gownsmodelArrayList.add(new gownmodel(R.drawable.img1, "Gowns"));
                gownsmodelArrayList.add(new gownmodel(R.drawable.img2, "Gowns"));
                gownsmodelArrayList.add(new gownmodel(R.drawable.img3, "Gowns"));
                gownsmodelArrayList.add(new gownmodel(R.drawable.img2, "Gowns"));
                gownsmodelArrayList.add(new gownmodel(R.drawable.img1, "Gowns"));



                ((RecyclerView) itemView.findViewById(R.id.recyclerTony)).setAdapter(new gownadpter(gownsmodelArrayList));



////    sliderModelsArrayList.add(new sliderModel(R.drawable.sarees));
////    sliderModelsArrayList.add(new sliderModel(R.drawable.sarees));
////    sliderModelsArrayList.add(new sliderModel(R.drawable.sarees));
////    sliderModelsArrayList.add(new sliderModel(R.drawable.sarees));


//    new JsonTask().execute("https://api.npoint.io/31abe6b9044891e377cc");
                new JsonTask().execute("https://jsonware.com/json/8fffdd37b28628d79ee6ddad64e93f38.json");


            }



        }
        private  class JsonTask extends AsyncTask<String , String , String> {



            ArrayList<sliderModel> sliderModelsArrayList = new ArrayList<>();
            ArrayList<sareesmodel> sareesmodelArrayList = new ArrayList<>();


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("WrongThread")
            @Override
            protected String doInBackground(String... aman) {

                HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {
                    URL url = new URL(aman[0]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";

                    while ((line =reader.readLine())!=null){
                        buffer.append(line+"\n");
                        try {

                            JSONObject obj = new JSONObject(line);
                            JSONArray pl=obj.getJSONArray("sarees");
                            JSONArray p2=obj.getJSONArray("poster");


                            for (int i=0; i< pl.length(); i++){
                                JSONObject sarees = pl.getJSONObject(i);

                                String imageUrl = sarees.getString("imgUrl");
                                String NameSari = sarees.getString("dressName");
                                String prodPrice = sarees.getString("dressPrice");
                                String detailsProd = sarees.getString("details");
//                                sliderModelsArrayList.add(new sliderModel(imageUrl));

                                sareesmodelArrayList.add(new sareesmodel(imageUrl,NameSari,prodPrice) );
                            }
                            for (int i=0; i< p2.length(); i++){
                                JSONObject poster = p2.getJSONObject(i);

                                String imageUrl = poster.getString("imgUrl");

                                sliderModelsArrayList.add(new sliderModel(imageUrl));

                            }


                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                    return buffer.toString();
                }catch (MalformedURLException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connection!= null){
                        connection.disconnect();
                    }
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return null;
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);



                ((RecyclerView) itemView.findViewById(R.id.slider_re)).setAdapter(new sliderAdpter(sliderModelsArrayList));
                ((RecyclerView) itemView.findViewById(R.id.Recentlyplayed)).setAdapter(new sareesadpter(sareesmodelArrayList));

            }
        }



    }
}
