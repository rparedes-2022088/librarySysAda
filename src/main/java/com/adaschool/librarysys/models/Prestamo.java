package com.adaschool.librarysys.models;

import lombok.Data;

@Data
public class Prestamo {
    private String id;
    private String idLibro;
    private String idUsuario;
}
