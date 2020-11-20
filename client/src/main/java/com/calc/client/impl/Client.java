package com.calc.client.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final HttpClient httpClient;
    private final String url;

    public Client(String url) {
        httpClient = HttpClient.newBuilder().build();
        this.url = url;
    }

    public BigDecimal get(String expr) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "?expr=" + expr))
                .GET()
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return new BigDecimal(response.body().toString());
    }

    public BigDecimal post(String ex) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept","application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(ex))
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return new BigDecimal(response.body().toString());
    }
}
