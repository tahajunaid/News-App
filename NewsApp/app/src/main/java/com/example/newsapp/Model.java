package com.example.newsapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Model implements Serializable {
    String source, author, title, description, url, urlToImage, publishedAt, content;

    public Model(JSONObject news) throws JSONException {

        this.source = news.getJSONObject("source").getString("name").toString();
        this.author = news.getString("author").toString();
        this.title = news.getString("title").toString();
        this.description = news.getString("description").toString();
        this.url = news.getString("url").toString();
        this.urlToImage = news.getString("urlToImage").toString();
        this.publishedAt = news.getString("publishedAt").toString();
        this.content = news.getString("content").toString();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
