package org.sofka.radar.controller;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.model.KnowlegdeArea;
import org.sofka.radar.model.Radar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @GetMapping
    private Flux<Object> getAllLeague(){
        String uri = "http://localhost:3000/radar";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Flux.just(coutries);
    }

    @GetMapping("/searchleague/{id}")
    private Flux<Object> getLeagueById(@PathVariable String id){
        String uri = "http://localhost:3000/radar/"+id;
        RestTemplate restTemplate = new RestTemplate();
        Object radarList = restTemplate.getForObject(uri,Object.class);
        return Flux.just(radarList);
    }

    @GetMapping("/searchstudent")
    private Mono<Object> getLeagueByIdLeagueByIdStudent(String idLeague, String idStudent){
        String uri = "http://localhost:3000/radar/";
        RestTemplate restTemplate = new RestTemplate();
        RadarDocument[] radarList = restTemplate.getForObject(uri,RadarDocument[].class);
        return Mono.just(radarList);
    }


}
