package com.adaschool.librarysys.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private String rol;
}
