package com.adaschool.librarysys.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "book")
public class BookMongo {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
}
