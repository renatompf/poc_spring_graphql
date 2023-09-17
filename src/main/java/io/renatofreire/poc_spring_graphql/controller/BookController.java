package io.renatofreire.poc_spring_graphql.controller;

import io.renatofreire.poc_spring_graphql.dto.BookInput;
import io.renatofreire.poc_spring_graphql.model.Book;
import io.renatofreire.poc_spring_graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping(name = "books")
    List<Book> getAll(){
        return bookService.getAll();
    }

    @QueryMapping(name = "booksById")
    Book getById(@Argument String bookISBN){
        return bookService.getById(bookISBN);
    }

    @MutationMapping("books")
    Book addNewBook(@Argument BookInput newBook){
        return bookService.addBook(newBook);
    }

    @MutationMapping("deleteBook")
    Boolean addNewBook(@Argument String bookISBN){
        return bookService.deleteBook(bookISBN);
    }

}
