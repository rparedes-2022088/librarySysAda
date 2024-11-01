package com.adaschool.librarysys.dto;

import lombok.Data;

@Data
public class UserRequestLogin {
    private String username;
    private String password;
}
