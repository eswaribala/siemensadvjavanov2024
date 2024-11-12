package com.siemens;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientDemo {

    private static HttpClient httpClient=HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofMillis(3000))
            .build();
    public static void main(String[] args){
        HttpRequest httpRequest=HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://restcountries.com/v2/all"))
                .build();
        HttpResponse httpResponse=null;
        try {
           httpResponse= httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
           HttpHeaders headers= httpResponse.headers();
           headers.map().entrySet().stream().forEach(entry->{
               System.out.println(entry.getKey()+","+entry.getValue());
           });
           JSONArray jsonArray=new JSONArray(httpResponse.body().toString());

           Stream<Object> jsonStream= IntStream.
                   range(0,jsonArray.length()).mapToObj(jsonArray::get);

           jsonStream.forEach(obj->{
               final JSONObject jsonObjectInstance= (JSONObject) obj;
               if(!jsonObjectInstance.isNull("capital"))
                System.out.println(jsonObjectInstance.get("name")+","+jsonObjectInstance.get("capital"));

           });



        }
        catch (IOException ex){

        }
        catch(InterruptedException ex){

        }

    }
}
