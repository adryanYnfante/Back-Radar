package org.sofka.radar.controller;

import org.sofka.radar.model.RadarExterno;
import org.sofka.radar.service.LeagueService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Este controller permite consumir una api externa,
 * en la clase WebClientConfigration se parametriza la
 * URL base.
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/league")
public class LeagueController {

    final
    LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    /**
     * llamomos al servicio que nos permite consumir la API externa.
     *
     * @return retornamos el body en formato JSON
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private Mono<List<RadarExterno>> getAllLeague() {
        return leagueService.getData().collectList();

    }

    @GetMapping(path = "/searchstudent/{idRadar}", produces = MediaType.APPLICATION_JSON_VALUE)
    private Mono<List<RadarExterno>> getLeagueByIdLeagueByIdStudent(String idStudent) {
        return leagueService.getDataById(idStudent).collectList();
    }
}
