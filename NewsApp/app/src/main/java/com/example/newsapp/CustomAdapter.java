package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context mainActivity;
    List<Model> modelList;

    Context context;

    public CustomAdapter(Context mainActivity, List<Model> modelList, Context context) {
        this.mainActivity = mainActivity;
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView, modelList, mainActivity, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.msource.setText(modelList.get(position).getSource());
        holder.mtitle.setText(modelList.get(position).getTitle());
        //holder.mdescription.setText(modelList.get(position).getDescription());
        Picasso.get().load(modelList.get(position).getUrlToImage()).into(holder.murlToImage);
        holder.mpublishedAt.setText(modelList.get(position).getPublishedAt());
        //holder.mcontent.setText(modelList.get(position).getContent());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, DisplayActivity.class);
//                intent.putExtra("title", modelList.get(position).getTitle());
//                intent.putExtra("imgurl", modelList.get(position).getUrlToImage());
//                intent.putExtra("desc", modelList.get(position).getDescription());
                intent.putExtra("news", modelList.get(position));
                mainActivity.startActivity(intent);
            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(modelList.get(position).getUrl()));
                mainActivity.startActivity(i);
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
