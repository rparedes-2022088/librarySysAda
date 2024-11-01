package com.adaschool.librarysys.repositories.mongo.prestamo;

import com.adaschool.librarysys.models.mongo.PrestamoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestamoRepositoryNoSql extends MongoRepository<PrestamoMongo, String> {
}