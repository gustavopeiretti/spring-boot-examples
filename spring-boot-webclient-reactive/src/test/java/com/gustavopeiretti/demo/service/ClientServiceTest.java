package com.gustavopeiretti.demo.service;

import com.gustavopeiretti.demo.exception.ApiWebClientException;
import com.gustavopeiretti.demo.model.ClientRequest;
import com.gustavopeiretti.demo.model.ClientResponse;
import com.gustavopeiretti.demo.webclient.ApiWebClient;
import io.netty.handler.timeout.ReadTimeoutException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);

    @Autowired
    private ApiWebClient webClient;

    private ClientAndServer mockServer;

    @BeforeEach
    public void startServer() {
        mockServer = ClientAndServer.startClientAndServer(8899);
    }

    @AfterEach
    public void stopServer() {
        mockServer.stop();
    }


    @Test
    void createShouldReturnTheResponse() {

        // set up mock server with a delay of 1 seconds
        mockServer.when(HttpRequest.request().withMethod("POST")
                .withPath("/accounts")).
                respond(HttpResponse.response()
                        .withBody("{ \"name\": \"Frank\", \"email\": \"frank@mail.com\"}")
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withDelay(TimeUnit.MILLISECONDS, 1000));

        // given: a new client
        ClientRequest request = new ClientRequest();
        request.setName("Frank");
        request.setName("frank@mail.com");

        // when: send a request
        ClientResponse response = webClient.createClient(request);

        // then: response should be ok
        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("Frank");
        assertThat(response.getEmail()).isEqualTo("frank@mail.com");

    }

    @Test
    void createWithTimeoutShouldThrowReadTimeOut() {

        // set up mock server with a delay of 5 seconds
        mockServer.when(HttpRequest.request().withMethod("POST")
                .withPath("/accounts")).
                respond(HttpResponse.response()
                        .withBody("{ \"name\": \"Frank\", \"email\": \"frank@mail.com\"}")
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withDelay(TimeUnit.MILLISECONDS, 5000));


        // given: a new client
        ClientRequest request = new ClientRequest();
        request.setName("Frank");
        request.setName("frank@mail.com");

        // when: send a request and takes a long time
        // then: throw a Timeout
        assertThrows(ReadTimeoutException.class, () -> webClient.createClient(request));
    }

    @Test
    void createWithStatusShouldThrowACustomException() {

        // set up mock server with a http status 500
        mockServer.when(HttpRequest.request().withMethod("POST")
                .withPath("/accounts"))
                .respond(HttpResponse.response().withStatusCode(500)
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withDelay(TimeUnit.MILLISECONDS, 1000));

        // given: a new client
        ClientRequest request = new ClientRequest();
        request.setName("Frank");
        request.setName("frank@mail.com");

        // when: send a request and a 500 error occurs
        // then: throw a ApiWebClientException
        ApiWebClientException apiWebClientException = assertThrows(ApiWebClientException.class, () -> webClient.createClient(request));
        assertTrue(apiWebClientException.getMessage().contains("HTTP Status 500 error"));

    }
}
