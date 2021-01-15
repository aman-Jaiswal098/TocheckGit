package com.example.musicplayer.adpter;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.Product_page;
import com.example.musicplayer.R;
import com.example.musicplayer.model.sareesmodel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class sareesadpter extends RecyclerView.Adapter<sareesadpter.recentlyView> {
    Dialog dialog;
    ArrayList<sareesmodel> sareesmodelArrayList;

    public sareesadpter(ArrayList<sareesmodel> sareesmodelArrayList) {
        this.sareesmodelArrayList = sareesmodelArrayList;
    }

    @NonNull
    @Override
    public sareesadpter.recentlyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.sarees_layout, parent, false);

        return new recentlyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final sareesadpter.recentlyView holder, final int position) {
//    holder.imageView.setImageResource(recentlyplayedmodelArrayList.get(position).getImage());

        sareesmodel currentItem =sareesmodelArrayList.get(position);
        String imageUrl = currentItem.getImage();

        Picasso.get().load(imageUrl).into(holder.imageView);
        holder.textView.setText(sareesmodelArrayList.get(position).getSongName());
        holder.proPrice.setText(sareesmodelArrayList.get(position).getProductPrice());



holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), Product_page.class);
        intent.putExtra("imageName",sareesmodelArrayList.get(position).getImage());
        intent.putExtra("SariName",sareesmodelArrayList.get(position).getSongName());
        intent.putExtra("price",sareesmodelArrayList.get(position).getProductPrice());


        v.getContext().startActivity(intent);

    }
});

    }

    @Override
    public int getItemCount() {
        return sareesmodelArrayList.size();
    }
    public class recentlyView extends RecyclerView.ViewHolder {
       ImageView imageView;
       TextView textView ,proPrice;
       public ConstraintLayout constraintLayout;
        public recentlyView(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.sareesImg);
            textView = itemView.findViewById(R.id.sareesName);
            proPrice = itemView.findViewById(R.id.price);
            constraintLayout =itemView.findViewById(R.id.reactlyID);
        }


    }
}
