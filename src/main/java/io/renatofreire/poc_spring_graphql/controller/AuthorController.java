package io.renatofreire.poc_spring_graphql.controller;

import io.renatofreire.poc_spring_graphql.dto.AuthorInput;
import io.renatofreire.poc_spring_graphql.model.Author;
import io.renatofreire.poc_spring_graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping(name = "authors")
    List<Author> getAll(){
        return authorService.getAll();
    }

    @QueryMapping(name = "authorsById")
    Author getById(@Argument Long authorId){
        return authorService.getById(authorId);
    }

    @MutationMapping("authors")
    Author addNewAuthor(@Argument AuthorInput newAuthor){
        return authorService.createNewAuthor(newAuthor);
    }

    @MutationMapping("updateAuthorName")
    Author updateAuthorName(@Argument Long authorId, @Argument AuthorInput updatedAuthor){
        return authorService.updateAuthorName(authorId, updatedAuthor);
    }

}
