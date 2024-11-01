package com.adaschool.librarysys.repositories.mongo.book;

import com.adaschool.librarysys.models.Book;
import com.adaschool.librarysys.models.mongo.BookMongo;
import com.adaschool.librarysys.repositories.BookRepository;
import com.adaschool.librarysys.util.caster.BookCaster;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("mongo")
@RequiredArgsConstructor
@Repository
public class BookRepositoryMongo implements BookRepository {
    private final BookRepositoryNoSql bookRepositoryMongoNoSql;

    private final BookCaster bookCaster;

    @Override
    public Book createBook(Book book) {
        BookMongo bookMongo = bookCaster.bookToBookMongo(book);
        BookMongo newBook = bookRepositoryMongoNoSql.save(bookMongo);
        return bookCaster.bookMongoToBook(newBook);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepositoryMongoNoSql.findAll().stream()
                .map(bookCaster::bookMongoToBook)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findBookById(String idBook) {
        Optional<BookMongo> bookMongo = bookRepositoryMongoNoSql.findById(idBook);
        return bookMongo.map(bookCaster::bookMongoToBook);
    }

    @Override
    public Book updateBook(Book book) {
        BookMongo bookMongo = bookCaster.bookToBookMongo(book);
        BookMongo newBook = bookRepositoryMongoNoSql.save(bookMongo);
        return bookCaster.bookMongoToBook(newBook);
    }

    @Override
    public void deleteBook(String idBook) {
        bookRepositoryMongoNoSql.deleteById(idBook);
    }
}
