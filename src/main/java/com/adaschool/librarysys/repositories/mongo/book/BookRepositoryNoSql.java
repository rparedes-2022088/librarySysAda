package com.adaschool.librarysys.repositories.mongo.book;

import com.adaschool.librarysys.models.Book;
import com.adaschool.librarysys.models.mongo.BookMongo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("mongo")
@Repository
public interface BookRepositoryNoSql extends MongoRepository<BookMongo, String> {

}
