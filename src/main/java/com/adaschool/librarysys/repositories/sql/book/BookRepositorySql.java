package com.adaschool.librarysys.repositories.sql.book;

import com.adaschool.librarysys.models.post.BookPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositorySql extends JpaRepository<BookPost, Long> {
}
