package com.adaschool.librarysys.repositories.mongo.user;

import com.adaschool.librarysys.models.mongo.UserMongo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("mongo")
@Repository
public interface UserRepositoryNoSql extends MongoRepository<UserMongo, String> {
    Optional<UserMongo> findByUsername(String username);
    Optional<UserMongo> findByEmail(String email);
}