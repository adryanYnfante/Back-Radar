package org.sofka.radar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.model.KnowlegdeArea;
import org.sofka.radar.model.RadarExterno;
import org.sofka.radar.service.LeagueService;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LeagueControllerTest {

    @Mock
    LeagueService leagueService;

    private WebTestClient client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        LeagueController router = new LeagueController(leagueService);

        //simulacion de peticion a handler por medio del router
        this.client = WebTestClient.bindToController(router)
                .configureClient().baseUrl("/league").build();
    }

    @Test
    void obtener() {

        this.client.get().exchange().expectStatus()
                .isOk()
                .expectBodyList(RadarExterno.class);
    }
}