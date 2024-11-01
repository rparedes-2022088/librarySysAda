package com.adaschool.librarysys.models;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
}
