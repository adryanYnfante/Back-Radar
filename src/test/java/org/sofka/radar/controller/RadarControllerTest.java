package org.sofka.radar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.model.KnowlegdeArea;
import org.sofka.radar.service.RadarService;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RadarControllerTest {

    @Mock
    private RadarService radarService;

    private WebTestClient client;

    @BeforeEach
    void setUp() {
        //se crean los mocks
        MockitoAnnotations.openMocks(this);


        RadarController router = new RadarController(radarService);

        //simulacion de peticion a handler por medio del router
        this.client = WebTestClient.bindToController(router)
                .configureClient().baseUrl("/api/radar").build();



    }


    @Test
    void saveRadar() {
        List<KnowlegdeArea> list = new ArrayList<>();
        list.add(new KnowlegdeArea("Pruebas","3.4"));
        list.add(new KnowlegdeArea("Front","4.4"));

        RadarDocument radar = RadarDocument.builder()
                .identification("1234")
                .name("ciclo 3")
                .knowlegdeAreas(list)
                .build();

        when(radarService.saveRadar(any(RadarDocument.class))).thenReturn(Mono.just(radar));

        this.client.post().bodyValue(radar).exchange().expectStatus()
                .isOk()
                .expectBody(RadarDocument.class)
                .isEqualTo(radar);
    }

    @Test
    void getRadarById() {

        List<KnowlegdeArea> list = new ArrayList<>();
        list.add(new KnowlegdeArea("Pruebas","3.4"));
        list.add(new KnowlegdeArea("Front","4.4"));

        RadarDocument radar = RadarDocument.builder()
                .identification("1234")
                .name("ciclo 3")
                .knowlegdeAreas(list)
                .build();


        when(radarService.getRadarId("1234")).thenReturn(Mono.just(radar));

        this.client.get().uri("/searchbyid/1234").exchange().expectStatus()
                .isOk()
                .expectBody(RadarDocument.class)
                .isEqualTo(radar);
    }


    @Test
    void getRadarByName() {
        List<KnowlegdeArea> list = new ArrayList<>();
        list.add(new KnowlegdeArea("Pruebas","3.4"));
        list.add(new KnowlegdeArea("Front","4.4"));

        RadarDocument radar = RadarDocument.builder()
                .identification("1234")
                .name("ciclo 3")
                .knowlegdeAreas(list)
                .build();

        when(radarService.getRadarName("ciclo 3")).thenReturn(Mono.just(radar));

        this.client.get().uri("/searchbyname/ciclo 3").exchange().expectStatus()
                .isOk()
                .expectBody(RadarDocument.class)
                .isEqualTo(radar);
    }
}