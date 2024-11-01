package com.adaschool.librarysys.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String name;
    private String username;
    private String email;
    private String rol;
}
