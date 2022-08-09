package org.sofka.radar.repository;

import org.sofka.radar.document.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<UserDocument, String>,
        ReactiveQueryByExampleExecutor<UserDocument> {
}
