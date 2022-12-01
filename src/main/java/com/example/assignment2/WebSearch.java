package com.example.assignment2;


import com.google.gson.annotations.SerializedName;

public class WebSearch {

    //Private variables
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String description;


    //getter methods
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return  title ;
    }
}
