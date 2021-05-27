package com.example.newsapp.ui.slideshow;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsapp.CustomAdapter;
import com.example.newsapp.Model;
import com.example.newsapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {
    RecyclerView mRV;
    List<Model> modelList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    ProgressDialog pd;
    JSONArray news;
    Context mA;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        mA = root.getContext();
        mRV = root.findViewById(R.id.recyclerview);
        mRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mA);
        mRV.setLayoutManager(layoutManager);
        pd = new ProgressDialog(mA);

        RequestQueue queue = Volley.newRequestQueue(mA);
        String url = "https://saurav.tech/NewsAPI/top-headlines/category/business/in.json";
        pd.setTitle("Loading data..");
        pd.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            news = response.getJSONArray("articles");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        pd.dismiss();
                        try {
                            showData(news, mA);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(mA, "That didnt work", Toast.LENGTH_SHORT);


                    }
                });

        queue.add(jsonObjectRequest);

        return root;
    }

    private void showData(JSONArray news, Context context) throws JSONException {
        for (int i = 0; i < news.length(); i++) {
            JSONObject news1 = news.getJSONObject(i);
            Model model = new Model(news1);
            modelList.add(model);
            adapter = new CustomAdapter(mA, modelList, context);
            mRV.setAdapter(adapter);
            Toast.makeText(context, "hello showdata", Toast.LENGTH_LONG);
            System.out.println(news1.getJSONObject("source").getString("name").toString() + "\n" +
                    news1.getString("author").toString() + "\n" +
                    news1.getString("title").toString() + "\n" +
                    news1.getString("description").toString() + "\n" +
                    news1.getString("url").toString() + "\n" +
                    news1.getString("urlToImage").toString() + "\n" +
                    news1.getString("publishedAt").toString() + "\n" +
                    news1.getString("content").toString());
        }
    }
}