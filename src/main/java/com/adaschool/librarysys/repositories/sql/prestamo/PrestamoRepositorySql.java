package com.adaschool.librarysys.repositories.sql.prestamo;

import com.adaschool.librarysys.models.post.PrestamoPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepositorySql extends JpaRepository<PrestamoPost, Long> {
}