package org.sofka.radar.service;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.repository.IRadarRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RadarService {

    final
    IRadarRepository radarRepository;

    public RadarService(IRadarRepository radarRepository) {
        this.radarRepository = radarRepository;
    }

    /**
     * Permite guardar en base de datos un radar
     *
     * @param radar tarea a ser almacenada
     * @return radar almacenada con su id incluido
     */
    public Mono<RadarDocument> saveRadar(RadarDocument radar){

        return radarRepository.save(radar);
    }


    /**
     * Permite obtener todas las radar almacenadas.
     *
     * @return lista de radars.
     */
    public Flux<RadarDocument> getRadarAll(){
        return radarRepository.findAll();
    }

    /**
     * Obtiene un objeto entity a partir de su id
     *
     * @param idRadar id de la tarea a buscar
     * @return objeto completo encontrado.
     */
    public Mono<RadarDocument> getRadarId(String idRadar){
        return radarRepository.findById(idRadar);
    }
}
