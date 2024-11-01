package com.adaschool.librarysys.repositories.sql.user;

import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.models.post.UserPost;
import com.adaschool.librarysys.repositories.UserRepository;
import com.adaschool.librarysys.util.caster.UserCaster;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("postgres")
@Repository
@RequiredArgsConstructor
public class UserRepositoryPost implements UserRepository {

    private final UserRepositorySql userRepositorySql;
    private final UserCaster userCaster;

    @Override
    public User createUser(User user) {
        UserPost UserPost = userCaster.userToUserPostgres(user);
        UserPost newUser = userRepositorySql.save(UserPost);
        return userCaster.userPostgresToUser(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepositorySql.findAll().stream()
                .map(userCaster::userPostgresToUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUserById(String id) {
        Optional<UserPost> UserPost = userRepositorySql.findById(Long.parseLong(id));
        return UserPost.map(userCaster::userPostgresToUser);
    }

    @Override
    public User updateUser(User user) {
        UserPost UserPost = userCaster.userToUserPostgres(user);
        UserPost newUser = userRepositorySql.save(UserPost);
        return userCaster.userPostgresToUser(newUser);
    }

    @Override
    public void deleteUser(String idUser) {
        userRepositorySql.deleteById(Long.parseLong(idUser));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<UserPost> UserPost = userRepositorySql.findByEmail(email);
        return UserPost.map(userCaster::userPostgresToUser);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<UserPost> UserPost = userRepositorySql.findByUsername(username);
        return UserPost.map(userCaster::userPostgresToUser);
    }
}
