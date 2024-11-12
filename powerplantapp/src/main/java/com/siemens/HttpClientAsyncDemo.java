package com.siemens;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.scanner.Constant;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientAsyncDemo {

    private static HttpClient httpClient=HttpClient.newHttpClient();
    public static void main(String[] args){
        HttpRequest httpRequest=HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .build();


        CompletableFuture<HttpResponse<String>> completableFuture=
                httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        completableFuture.thenApply(HttpResponse::body)
                .thenApply(body->parseJsonArray(body))
                .thenAccept(jsonArray-> {

                    if(jsonArray!=null){
                        Stream<Object> jsonStream= IntStream.
                                range(0,jsonArray.length()).mapToObj(jsonArray::get);
                        jsonStream.forEach(obj->{
                            final JSONObject jsonObjectInstance= (JSONObject) obj;
                            if(!jsonObjectInstance.isNull("capital"))
                                System.out.println(jsonObjectInstance.get("name")+","+jsonObjectInstance.get("capital"));

                        });

                    }


                }).exceptionally(ex->{
                    System.out.println("Request Failed"+ex.getMessage());
                    return null;
                });



    }


    private static JSONArray parseJsonArray(String responseBody){
        try{
            System.out.println(responseBody);
            return new JSONArray(responseBody);
        }catch (JSONException ex){
                 return null;
        }

    }
}
