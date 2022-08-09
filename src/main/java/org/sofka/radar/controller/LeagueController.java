package org.sofka.radar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
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

    @GetMapping("/searchleague")
    private Flux<Object> getLeagueById(String idLeague){
        String uri = "http://localhost:3000/radare/"+idLeague;
        RestTemplate restTemplate = new RestTemplate();
        Object[] radarList = restTemplate.getForObject(uri,Object[].class);
        return Flux.just(radarList);
    }

    @GetMapping("/searchstudent")
    private List<Object> getLeagueByIdLeagueByIdStudent(String idLeague, String idStudent){
        String uri = "https://restcountries.com/v2/name/argentina?fullText=true";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(coutries);
    }


}
