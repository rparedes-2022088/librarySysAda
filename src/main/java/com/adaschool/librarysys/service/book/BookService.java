package com.adaschool.librarysys.service.book;

import com.adaschool.librarysys.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> getBooks();

    Book findBookById(String idBook);

    Book updateBook(String idBook, Book book);

    void deleteBook(String idBook);
}
