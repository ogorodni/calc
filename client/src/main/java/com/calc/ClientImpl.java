package com.calc;
import com.calc.domain.Exercise;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientImpl implements Client {
    private HttpClient httpClient;
    private String url;

    ClientImpl(String url) {
        httpClient = HttpClient.newBuilder().build();
        this.url = url;
    }

    @Override
    public HttpResponse get(Exercise ex) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + '?' + ex.toHTMPParams()))
                .GET()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse post(Exercise ex) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept","application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(ex)))
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
