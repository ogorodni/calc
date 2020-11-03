package com.calc.client.impl;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientImpl implements Client {
    private final HttpClient httpClient;
    private final String url;

    public ClientImpl(String url) {
        httpClient = HttpClient.newBuilder().build();
        this.url = url;
    }

    @Override
    public HttpResponse get(String expr) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "?expr=" + expr))
                .GET()
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse post(String ex) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept","application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(ex))
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
