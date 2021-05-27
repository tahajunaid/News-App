package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    TextView msource, mtitle, mdescription, mauthor, mpublishedAt;
    ImageView murlToImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        msource = findViewById(R.id.rsource);
        mtitle = findViewById(R.id.rtitle);
        murlToImage = findViewById(R.id.rurlToImage);
        mpublishedAt = findViewById(R.id.rpublishedAt);
        mauthor = findViewById(R.id.rauthor);
        mdescription = findViewById(R.id.rdescription);
        Intent intent = getIntent();
        Model news = (Model) intent.getSerializableExtra("news");
        mtitle.setText(news.getTitle());
        mauthor.setText(news.getAuthor());
        mdescription.setText(news.getDescription());
        mpublishedAt.setText(news.getPublishedAt());
        msource.setText(news.getSource());
        Picasso.get().load(news.getUrlToImage()).into(murlToImage);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}