package io.renatofreire.poc_spring_graphql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    private String ISBN;
    private String title;
    private String publisher;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book() {
    }

    public Book(String ISBN, String title, String publisher, Author author) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String IBAN) {
        this.ISBN = IBAN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
