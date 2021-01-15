package com.example.musicplayer.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.model.gownmodel;

import java.util.ArrayList;

public class gownadpter extends RecyclerView.Adapter<gownadpter.TonyView> {
     ArrayList<gownmodel> gownsmodelArrayList;

    public gownadpter(ArrayList<gownmodel> tonykakkarmodelArrayList) {
        this.gownsmodelArrayList = tonykakkarmodelArrayList;
    }

    @NonNull
    @Override
    public gownadpter.TonyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gowns_lehengas_layout,parent,false);
        return new TonyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gownadpter.TonyView holder, int position) {
        holder.imageView.setImageResource(gownsmodelArrayList.get(position).getTonySongImg());
        holder.textView.setText(gownsmodelArrayList.get(position).getTonySongName());

    }

    @Override
    public int getItemCount() {
        return gownsmodelArrayList.size();
    }

    public class TonyView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public TonyView(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.tonyImag);
            textView = itemView.findViewById(R.id.tonykakkarsongName);
        }
    }
}
