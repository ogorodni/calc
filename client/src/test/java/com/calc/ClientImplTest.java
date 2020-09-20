package com.calc;

import com.calc.domain.Exercise;
import com.calc.domain.Operation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;
import org.mockserver.model.NottableString;
import org.mockserver.model.Parameter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@ExtendWith(MockServerExtension.class)
@MockServerSettings(ports = {8080})
class ClientImplTest {

    @Test
    void post(MockServerClient mockServer) throws IOException, InterruptedException {
        Exercise ex = new Exercise(Operation.SUM, BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        mockServer.when(request().withMethod("POST").withPath("/calc").withBody(new Gson().toJson(ex)))
                .respond(response().withStatusCode(200).withBody("Result = 5"));
        ClientImpl client = new ClientImpl("http://localhost:8080/calc");
        HttpResponse response = client.post(ex);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Result = 5", response.body());
    }

    @Test
    void get(MockServerClient mockServer) throws IOException, InterruptedException {
        Exercise ex = new Exercise(Operation.SUM, BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        mockServer.when(request().withMethod("GET")
                .withPath("/calc")
//                .withPathParameters(new Parameter("operation", "SUM"), new Parameter("param1", "2.00"), new Parameter("param2", "3.00"))
                )
                .respond(response().withStatusCode(200).withBody("Result = 5"));
        ClientImpl client = new ClientImpl("http://localhost:8080/calc");
        HttpResponse response = client.get(ex);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Result = 5", response.body());
    }
}