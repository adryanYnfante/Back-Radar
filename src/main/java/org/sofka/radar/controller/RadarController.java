package org.sofka.radar.controller;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.Radar;
import org.sofka.radar.repository.IRadarRepository;
import org.sofka.radar.repository.IUserRepository;
import org.sofka.radar.service.RadarService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/radar")
public class RadarController {

    final
    RadarService radarService;

    public RadarController(RadarService radarService) {
        this.radarService = radarService;
    }


    /**
     * Permite obtener todas las Radares almacenadas.
     *
     * @return lista de radars.
     */
    @GetMapping
    public Flux<RadarDocument> getRadarAll() {
        return radarService.getRadarAll();
    }

    /**
     * Permite guardar en base de datos un radar
     *
     * @param radar tarea a ser almacenada
     * @return radar almacenada con su id incluido
     */
    @PostMapping
    public Mono<RadarDocument> saveRadar(@RequestBody RadarDocument radar) {
        return radarService.saveRadar(radar);
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param idRadar id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    @GetMapping("/searchbyid/{idRadar}")
    public Mono<RadarDocument> getRadarById(@PathVariable String idRadar) {
        return radarService.getRadarId(idRadar);
    }

    @PutMapping("/update/{id}")
    public Mono<RadarDocument> updateRadarById(@PathVariable String id,@RequestBody  RadarDocument radar){
        return radarService.saveRadar(new RadarDocument(id, radar.getName(),radar.getKnowlegdeAreas()));
    }

    @GetMapping("/searchbyname/{name}")
    public Mono<RadarDocument> getRadarByName(@PathVariable String name){
        return radarService.getRadarName(name);
    }
}
