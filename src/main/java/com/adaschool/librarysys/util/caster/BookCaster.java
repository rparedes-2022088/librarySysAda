package com.adaschool.librarysys.util.caster;

import com.adaschool.librarysys.models.Book;
import com.adaschool.librarysys.models.mongo.BookMongo;
import com.adaschool.librarysys.models.post.BookPost;
import org.springframework.stereotype.Component;

@Component
public class BookCaster {
    public BookPost bookToBookPostgres(Book book) {
        BookPost BookPost = new BookPost();
        BookPost.setId((book.getId() != null && !book.getId().isEmpty())
                ? Long.parseLong(book.getId()) : null);
        BookPost.setTitle(book.getTitle());
        BookPost.setAuthor(book.getAuthor());
        BookPost.setIsbn(book.getIsbn());
        return BookPost;
    }
    
    public Book bookPostgresToBook(BookPost BookPost) {
        Book book = new Book();
        book.setId(String.valueOf(BookPost.getId()));
        book.setTitle(BookPost.getTitle());
        book.setAuthor(BookPost.getAuthor());
        book.setIsbn(BookPost.getIsbn());
        return book;
    }
    
    public BookMongo bookToBookMongo(Book book) {
        BookMongo bookMongo = new BookMongo();
        bookMongo.setId(book.getId());
        bookMongo.setTitle(book.getTitle());
        bookMongo.setAuthor(book.getAuthor());
        bookMongo.setIsbn(book.getIsbn());
        return bookMongo;
    }
    
    public Book bookMongoToBook(BookMongo bookMongo) {
        Book book = new Book();
        book.setId(bookMongo.getId());
        book.setTitle(bookMongo.getTitle());
        book.setAuthor(bookMongo.getAuthor());
        book.setIsbn(bookMongo.getIsbn());
        return book;
    }
}
