package com.adaschool.librarysys.repositories.sql.user;

import com.adaschool.librarysys.models.post.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositorySql extends JpaRepository<UserPost, Long> {
    Optional<UserPost> findByEmail(String email);
    Optional<UserPost> findUserByUsername(String username);
}
