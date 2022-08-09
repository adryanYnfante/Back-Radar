package org.sofka.radar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueController {

    @GetMapping
    private List<Object> getAllLeague(){
        String uri = "https://restcountries.com/v2/name/argentina?fullText=true";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(coutries);
    }

    @GetMapping
    private List<Object> getLeagueById(String idLeague){
        String uri = "https://restcountries.com/v2/name/argentina?fullText=true";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(coutries);
    }

    @GetMapping
    private List<Object> getLeagueByIdLeagueByIdStudent(String idLeague, String idStudent){
        String uri = "https://restcountries.com/v2/name/argentina?fullText=true";
        RestTemplate restTemplate = new RestTemplate();
        Object[] coutries = restTemplate.getForObject(uri,Object[].class);
        return Arrays.asList(coutries);
    }


}
