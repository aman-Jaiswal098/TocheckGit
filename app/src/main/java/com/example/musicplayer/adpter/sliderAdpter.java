package com.example.musicplayer.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.model.sliderModel;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class sliderAdpter extends RecyclerView.Adapter<sliderAdpter.SliderView> {



    ArrayList<sliderModel> sliderModelsArrayList;

    public sliderAdpter(ArrayList<sliderModel> sliderModelsArrayList) {
        this.sliderModelsArrayList = sliderModelsArrayList;

    }


    @NonNull
    @Override
    public SliderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_contain,parent,false);

        return new SliderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderView holder, int position) {
//        holder.roundedImageView.setImageResource(Integer.parseInt(sliderModelsArrayList.get(position).getImg()));

       sliderModel currentItem =sliderModelsArrayList.get(position);

        String imgUrl = currentItem.getImg();

        Picasso.get().load(imgUrl).fit().centerInside().into(holder.roundedImageView);

    }

    @Override
    public int getItemCount() {
        return sliderModelsArrayList.size();
    }


//
//    public Object getItem(int position) {
//        return sliderModelsArrayList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }




    public class SliderView extends RecyclerView.ViewHolder {
        RoundedImageView roundedImageView;
        public SliderView(@NonNull View itemView ) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.slider_items);


        }
    }
}
