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
import java.util.Base64;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HttpClientAuthenticationDemo {

    private static HttpClient httpClient=HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofMillis(3000))
            .build();
    public static void main(String[] args){
        HttpRequest httpRequest=HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/basic-auth/user/pass"))
                .header("Authorization",getAuthenticatedCredentials("user","pass"))
                .build();
        HttpResponse httpResponse=null;
        try {
           httpResponse= httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
           HttpHeaders headers= httpResponse.headers();
           headers.map().entrySet().stream().forEach(entry->{
               System.out.println(entry.getKey()+","+entry.getValue());
           });
            System.out.println(httpResponse.body().toString());



        }
        catch (IOException ex){

        }
        catch(InterruptedException ex){

        }

    }

    private static String getAuthenticatedCredentials(String name, String password){
        String valueToEncode = name + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
