package com.adaschool.librarysys.models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String rol;
}