package org.sofka.radar.service;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IUserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class LeagueService {

    private final String url = "http://localhost:8080/";
    private WebClient webClient;

    public LeagueService(WebClient.Builder webClientBuilder) {

        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Flux<UserDocument> getData(){

        return  webClient.get()
                .uri("league")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UserDocument.class);
    }
}
