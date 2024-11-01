package com.adaschool.librarysys.util.caster;

import com.adaschool.librarysys.dto.UserResponse;
import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.models.mongo.UserMongo;
import com.adaschool.librarysys.models.post.UserPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserCaster {
    public UserPost userToUserPostgres(User user) {
        UserPost UserPost = new UserPost();
        UserPost.setId((user.getId() != null && !user.getId().isEmpty())
                ? Long.parseLong(user.getId()) : null);
        UserPost.setName(user.getName());
        UserPost.setUsername(user.getUsername());
        UserPost.setEmail(user.getEmail());
        UserPost.setPassword(user.getPassword());
        UserPost.setRol(user.getRol());
        return UserPost;
    }

    public User userPostgresToUser(UserPost UserPost) {
        User user = new User();
        user.setId(String.valueOf(UserPost.getId()));
        user.setName(UserPost.getName());
        user.setUsername(UserPost.getUsername());
        user.setEmail(UserPost.getEmail());
        user.setPassword(UserPost.getPassword());
        user.setRol(UserPost.getRol());
        return user;
    }

    public UserMongo userToUserMongo(User user) {
        UserMongo userMongo = new UserMongo();
        userMongo.setId(user.getId());
        userMongo.setName(user.getName());
        userMongo.setUsername(user.getUsername());
        userMongo.setEmail(user.getEmail());
        userMongo.setPassword(user.getPassword());
        userMongo.setRol(user.getRol());
        return userMongo;
    }

    public User userMongoToUser(UserMongo userMongo) {
        User user = new User();
        user.setId(userMongo.getId());
        user.setName(userMongo.getName());
        user.setUsername(userMongo.getUsername());
        user.setEmail(userMongo.getEmail());
        user.setPassword(userMongo.getPassword());
        user.setRol(userMongo.getRol());
        return user;
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setRol(user.getRol());
        return userResponse;
    }
}
