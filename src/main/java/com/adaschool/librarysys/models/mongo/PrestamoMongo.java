package com.adaschool.librarysys.models.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "prestamo")
public class PrestamoMongo {
    @Id
    private String id;
    private String idLibro;
    private String idUsuario;
}