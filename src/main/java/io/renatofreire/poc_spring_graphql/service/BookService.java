package io.renatofreire.poc_spring_graphql.service;

import io.renatofreire.poc_spring_graphql.dto.BookInput;
import io.renatofreire.poc_spring_graphql.model.Author;
import io.renatofreire.poc_spring_graphql.model.Book;
import io.renatofreire.poc_spring_graphql.repository.AuthorRepository;
import io.renatofreire.poc_spring_graphql.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getById(final String bookISBN){
        return bookRepository.findById(bookISBN).orElseGet(Book::new);
    }

    public Book addBook(final BookInput newBook){
        Author author = authorRepository.findById(newBook.authorId()).orElseThrow(EntityNotFoundException::new);

        Book bookToSave = new Book(newBook.ISBN(), newBook.title(), newBook.publisher(), author);

        return bookRepository.save(bookToSave);
    }

    public boolean deleteBook(final String bookISBN){
        Book book = bookRepository.findById(bookISBN).orElseThrow(EntityNotFoundException::new);
        bookRepository.delete(book);
        return true;
    }

}
