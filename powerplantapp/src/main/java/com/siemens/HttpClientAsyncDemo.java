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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientAsyncDemo {

    private static    HttpClient httpClient=HttpClient.newHttpClient();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HttpRequest httpRequest=HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://restcountries.com/v2/all"))
                .build();

        CompletableFuture<HttpResponse<String>> completableFuture=
                httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

       completableFuture
                .thenApply(HttpResponse::body)
               .thenApply(HttpClientAsyncDemo::parseJsonArray)
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
                }).join();

    }


    private static JSONArray parseJsonArray(String responseBody){
        try{
            System.out.println(responseBody);
            return new JSONArray(responseBody);
        }catch (JSONException ex){
            System.out.println(ex.getMessage());
                 return null;
        }

    }
}
