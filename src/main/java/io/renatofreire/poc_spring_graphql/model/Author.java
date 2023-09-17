package io.renatofreire.poc_spring_graphql.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "author")
@Entity
public class Author {

    @Id
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
