package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {


    public static void getWebSearchFromRapidApi (String searchTerm) throws IOException, InterruptedException {

        searchTerm = searchTerm.replaceAll("", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/WebSearchAPI?q="+searchTerm+"&pageNumber=1&pageSize=10&autoCorrect=true"))
                .header("X-RapidAPI-Key", "c2f31521fbmshf8ba604ad9ee0a7p1a1a33jsn1dd12cb65231")
                .header("X-RapidAPI-Host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<Path> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("WebSearch.json")));
        System.out.println(response.body());


    }


    public static APIResponse getWebSearches(){

        Gson gson =new Gson();
        APIResponse apiResponse = null;

        try (FileReader fileReader = new FileReader("WebSearch.json");
             JsonReader jsonReader =new JsonReader(fileReader);
             )
        {
            apiResponse =gson.fromJson(jsonReader,APIResponse.class);
        }

        catch (Exception e){
            e.printStackTrace();
        }


        return apiResponse;
    }



}
