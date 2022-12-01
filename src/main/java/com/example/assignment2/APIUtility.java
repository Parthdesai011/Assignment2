package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.net.ssl.SSLSession;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class APIUtility {

    public static APIResponse getWebSearchFromRapidApi (String searchTerm) throws IOException, InterruptedException {

        searchTerm = searchTerm.replaceAll(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/WebSearchAPI?q="+searchTerm+"&pageNumber=1&pageSize=10&autoCorrect=true"))
                .header("X-RapidAPI-Key", "c2f31521fbmshf8ba604ad9ee0a7p1a1a33jsn1dd12cb65231")
                .header("X-RapidAPI-Host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = new HttpResponse<>() {
            @Override
            public int statusCode() {
                return 0;
            }

            @Override
            public HttpRequest request() {
                return null;
            }

            @Override
            public Optional<HttpResponse<String>> previousResponse() {
                return Optional.empty();
            }

            @Override
            public HttpHeaders headers() {
                return null;
            }

            @Override
            public String body() {
                return null;
            }

            @Override
            public Optional<SSLSession> sslSession() {
                return Optional.empty();
            }

            @Override
            public URI uri() {
                return null;
            }

            @Override
            public HttpClient.Version version() {
                return null;
            }
        };
        System.out.println(response.body());

        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        APIResponse apiResponse =gson.fromJson(response.body(),APIResponse.class);


        return apiResponse;




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
