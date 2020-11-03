package com.calc.client.impl;
import java.io.IOException;
import java.net.http.HttpResponse;

public interface Client {
    HttpResponse get(String ex) throws IOException, InterruptedException;
    HttpResponse post(String ex) throws IOException, InterruptedException;
}
