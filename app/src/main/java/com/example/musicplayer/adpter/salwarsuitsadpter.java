package com.example.musicplayer.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.model.salwarsuitsmodel;

import java.util.ArrayList;

public class salwarsuitsadpter extends RecyclerView.Adapter<salwarsuitsadpter.trendingView> {


    ArrayList<salwarsuitsmodel> SalwarsuitsmodelArrayList;

    public salwarsuitsadpter(ArrayList<salwarsuitsmodel> trendingnowmodelArrayList) {
        this.SalwarsuitsmodelArrayList = trendingnowmodelArrayList;
    }

    @NonNull
    @Override
    public trendingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.salwar_layout, parent,false);
        return new trendingView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull trendingView holder, int position) {
        holder.imageView.setImageResource(SalwarsuitsmodelArrayList.get(position).getImg());
        holder.textView.setText((SalwarsuitsmodelArrayList.get(position).getSongName()));

    }

    @Override
    public int getItemCount() {
        return SalwarsuitsmodelArrayList.size();
    }

    public class trendingView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public trendingView(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.trendingImag);
            textView =itemView.findViewById(R.id.trendingsongName);
        }
    }
}
