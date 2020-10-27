package dev.experto.demo.service;

import dev.experto.demo.webclient.ApiWebClient;
import dev.experto.demo.model.ClientRequest;
import dev.experto.demo.model.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ApiWebClient webClient;

    public ClientService(ApiWebClient webClient) {
        this.webClient = webClient;
    }

    public ClientResponse searchClient(ClientRequest request) {
        log.info("Call web client");
        return webClient.createClient(request);
    }

}
