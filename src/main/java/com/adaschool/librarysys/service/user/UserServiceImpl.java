package com.adaschool.librarysys.service.user;

import com.adaschool.librarysys.dto.UserRequestUpdate;
import com.adaschool.librarysys.dto.UserResponse;
import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.repositories.UserRepository;
import com.adaschool.librarysys.util.caster.UserCaster;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserCaster userCaster;

    private static final String USER_NOT_FOUND = "Usuario no encontrado con el ID: ";

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(userCaster::userToUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(String idUser) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idUser);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de id de libro invalido para Postgres: " + idUser);
            }
        }
        User user = userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        return userCaster.userToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(String idUser, UserRequestUpdate userRequestUpdate) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idUser);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de id de libro invalido para Postgres: " + idUser);
            }
        }
        User user = userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        user.setName(userRequestUpdate.getName());
        user.setUsername(userRequestUpdate.getUsername());
        user.setEmail(userRequestUpdate.getEmail());
        User update = userRepository.updateUser(user);
        return userCaster.userToUserResponse(update);
    }

    @Override
    public void deleteUser(String idUser) {
        if(profile.equals("postgres")) {
            try {
                Long id = Long.parseLong(idUser);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de id de libro invalido para Postgres: " + idUser);
            }
        }
        userRepository.findUserById(idUser)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND + idUser));
        userRepository.deleteUser(idUser);
    }
}
