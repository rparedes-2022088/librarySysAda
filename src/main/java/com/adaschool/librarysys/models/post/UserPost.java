package com.adaschool.librarysys.models.post;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserPost{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_us")
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String rol;
}
