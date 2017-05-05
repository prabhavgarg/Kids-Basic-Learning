package com.example.boss.learn;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

/**
 * Created by BOSS on 05-May-17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>{

    private List<Images> imagesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageButton title1,title2;

        public MyViewHolder(View view) {
            super(view);
            title1 = (ImageButton) view.findViewById(R.id.image_title1);
            title2 = (ImageButton) view.findViewById(R.id.image_title2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);

    }

    public ImageAdapter(List<Images> imagesList) {
        this.imagesList =imagesList ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_raw, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Images img = imagesList.get(position);
        holder.title1.setImageResource(img.getImage1());
        holder.title2.setImageResource(img.getImage2());
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}
