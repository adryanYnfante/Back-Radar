package org.sofka.radar.controller;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.service.LeagueService;
import org.sofka.radar.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/league")
public class LeagueController {

    final
    LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }


    @GetMapping
    private Flux<UserDocument> getAllLeague() {
        return leagueService.getData();

        /*
        String uri = "http://localhost:3000/radar";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Flux.just(coutries);*/
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
