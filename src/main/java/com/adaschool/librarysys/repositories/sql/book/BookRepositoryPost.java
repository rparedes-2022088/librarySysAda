package com.adaschool.librarysys.repositories.sql.book;

import com.adaschool.librarysys.models.Book;
import com.adaschool.librarysys.models.post.BookPost;
import com.adaschool.librarysys.repositories.BookRepository;
import com.adaschool.librarysys.util.caster.BookCaster;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("postgres")
@RequiredArgsConstructor
@Repository
public class BookRepositoryPost implements BookRepository {
    private final BookRepositorySql BookRepositorySql;
    private final BookCaster bookCaster;
    
    @Override
    public Book createBook(Book book) {
        BookPost BookPost = bookCaster.bookToBookPostgres(book);
        BookPost newBook = BookRepositorySql.save(BookPost);
        return bookCaster.bookPostgresToBook(newBook);
    }

    @Override
    public List<Book> getBooks() {
        return BookRepositorySql.findAll().stream()
                .map(bookCaster::bookPostgresToBook)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findBookById(String idBook) {
        Optional<BookPost> BookPost = BookRepositorySql.findById(Long.parseLong(idBook));
        return BookPost.map(bookCaster::bookPostgresToBook);
    }

    @Override
    public Book updateBook(Book book) {
        BookPost BookPost = bookCaster.bookToBookPostgres(book);
        BookPost newBook = BookRepositorySql.save(BookPost);
        return bookCaster.bookPostgresToBook(newBook);
    }

    @Override
    public void deleteBook(String idBook) {
        BookRepositorySql.deleteById(Long.parseLong(idBook));
    }
}
