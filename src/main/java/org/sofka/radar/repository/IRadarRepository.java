package org.sofka.radar.repository;

import org.sofka.radar.document.RadarDocument;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.Radar;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IRadarRepository extends ReactiveMongoRepository<RadarDocument, String>,
        ReactiveQueryByExampleExecutor<RadarDocument> {
    Mono<RadarDocument> findByName(String name);

}
