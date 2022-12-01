package com.example.assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {

    @SerializedName("value")
    private WebSearch[] webSearches;

    @SerializedName("_type")
    String type;
    @SerializedName("totalCount")
    String totalCount;

    public List<WebSearch> getWebSearches() {
        return Arrays.asList (webSearches);
    }

    public String getType() {
        return type;
    }

    public String getTotalCount() {
        return totalCount;
    }
}
