package com.adaschool.librarysys.dto;

import lombok.Data;

@Data
public class UserResponseLogin {
    private String token;
    private Long expiresIn;
}
