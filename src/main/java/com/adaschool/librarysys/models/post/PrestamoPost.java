package com.adaschool.librarysys.models.post;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prestamo")
public class PrestamoPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pre")
    private Long id;
    private Long idLibro;
    private Long idUsuario;
}