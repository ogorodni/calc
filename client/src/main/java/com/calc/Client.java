package com.calc;
import com.calc.domain.Exercise;
import java.io.IOException;
import java.net.http.HttpResponse;

public interface Client {
    HttpResponse get(Exercise ex) throws IOException, InterruptedException;
    HttpResponse post(Exercise ex) throws IOException, InterruptedException;
}
