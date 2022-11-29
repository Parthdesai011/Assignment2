package com.example.assignment2;

import com.google.gson.annotations.SerializedName;

public class APIResponse {

    @SerializedName("value")
    private WebSearch[] webSearches;
    @SerializedName("_type")
    String type;
    String totalCount;

    public WebSearch[] getWebSearches() {
        return webSearches;
    }

    public String getType() {
        return type;
    }

    public String getTotalCount() {
        return totalCount;
    }
}
