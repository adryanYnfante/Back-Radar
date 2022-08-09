package org.sofka.radar.controller;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.Radar;
import org.sofka.radar.repository.IRadarRepository;
import org.sofka.radar.repository.IUserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/radar")
public class RadarController {

    final
    IRadarRepository radarRepository;

    public RadarController(IRadarRepository radarRepository) {
        this.radarRepository = radarRepository;
    }


    /**
     * Permite obtener todas las Radares almacenadas.
     *
     * @return lista de radars.
     */
    @GetMapping
    public Flux<RadarDocument> getRadarAll() {
        return radarRepository.findAll();
    }

    /**
     * Permite guardar en base de datos un radar
     *
     * @param radar tarea a ser almacenada
     * @return radar almacenada con su id incluido
     */
    @PostMapping
    public Mono<RadarDocument> saveRadar(@RequestBody RadarDocument radar) {
        return radarRepository.save(radar);
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param idRadar id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    @GetMapping("/searchbyid")
    public Mono<RadarDocument> getUserId(String idRadar) {
        return radarRepository.findById(idRadar);
    }
}
