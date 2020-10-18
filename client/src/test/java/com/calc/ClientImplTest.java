package com.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@ExtendWith(MockServerExtension.class)
@MockServerSettings(ports = {8080})
class ClientImplTest {

    @Test
    void post(MockServerClient mockServer) throws IOException, InterruptedException {
        mockServer.when(request().withMethod("POST").withPath("/calc").withBody("2 + 3"))
                .respond(response().withStatusCode(200).withBody("Result = 5"));
        ClientImpl client = new ClientImpl("http://localhost:8080/calc");
        HttpResponse response = client.post("2 + 3");
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Result = 5", response.body());
    }

    @Test
    void get(MockServerClient mockServer) throws IOException, InterruptedException {
        String ex = "1%20+%202";
        mockServer.when(request().withMethod("GET")
                .withPath("/calc")
                )
                .respond(response().withStatusCode(200).withBody("Result = 5"));
        ClientImpl client = new ClientImpl("http://localhost:8080/calc");
        HttpResponse response = client.get(ex);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Result = 5", response.body());
    }
}