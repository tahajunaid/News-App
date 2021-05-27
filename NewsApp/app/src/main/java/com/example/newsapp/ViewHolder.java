package com.example.newsapp;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView msource, mtitle, mdescription, murl, mpublishedAt, mcontent;
    ImageView murlToImage;
    View mView;
    Context mmainActivity;

    public ViewHolder(@NonNull View itemView, List<Model> modelList, Context mainActivity, Context context) {
        super(itemView);
        mView = itemView;
        mmainActivity = mainActivity;
        msource = itemView.findViewById(R.id.rsource);
        mtitle = itemView.findViewById(R.id.rtitle);
        murlToImage = itemView.findViewById(R.id.rurlToImage);
        mpublishedAt = itemView.findViewById(R.id.rpublishedAt);
    }
}
