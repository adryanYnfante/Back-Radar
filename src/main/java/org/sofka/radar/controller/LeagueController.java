package org.sofka.radar.controller;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.model.RadarExterno;
import org.sofka.radar.service.LeagueService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/api/league")
public class LeagueController {

    final
    LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private Mono<List<RadarExterno>> getAllLeague() {
        return leagueService.getData().collectList();

    }

    @GetMapping("/searchleague/{id}")
    private Flux<Object> getLeagueById(@PathVariable String id) {
        String uri = "http://localhost:3000/radar/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Object radarList = restTemplate.getForObject(uri, Object.class);
        return Flux.just(radarList);
    }

    @GetMapping("/searchstudent")
    private Mono<Object> getLeagueByIdLeagueByIdStudent(String idLeague, String idStudent) {
        String uri = "http://localhost:3000/radar/";
        RestTemplate restTemplate = new RestTemplate();
        RadarDocument[] radarList = restTemplate.getForObject(uri, RadarDocument[].class);
        return Mono.just(radarList);
    }


}
