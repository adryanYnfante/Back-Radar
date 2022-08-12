package org.sofka.radar.service;

import org.sofka.radar.document.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class LeagueService {



    @Autowired
    private WebClient webClient;


    public Flux<UserDocument> getData(){

        return  webClient.get()
                .uri("/posts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UserDocument.class);
    }
}
