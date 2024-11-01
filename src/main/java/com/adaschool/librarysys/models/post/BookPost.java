package com.adaschool.librarysys.models.post;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bo")
    private Long id;
    private String title;
    private String author;
    private String isbn;
}