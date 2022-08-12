package org.sofka.radar.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.bson.json.JsonObject;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.KnowlegdeArea;
import org.sofka.radar.model.Radar;
import org.sofka.radar.model.RadarExterno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class LeagueService {



    @Autowired
    private WebClient webClient;


    public Flux<RadarExterno > getData(){

        return  webClient.get()
                .uri("/ligas")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RadarExterno.class);
    }

    public Flux<RadarExterno > getDataById(String idStudent){

        return  webClient.get()
                .uri("/ligas/"+idStudent)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RadarExterno.class);
    }
}
