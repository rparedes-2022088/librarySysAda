package com.adaschool.librarysys.service.user;

import com.adaschool.librarysys.dto.UserRequestUpdate;
import com.adaschool.librarysys.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    UserResponse findUserById(String idUser);

    UserResponse updateUser(String idUser, UserRequestUpdate userRequestUpdate);

    void deleteUser(String idUser);
}
