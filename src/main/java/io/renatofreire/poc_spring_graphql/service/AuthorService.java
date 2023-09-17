package io.renatofreire.poc_spring_graphql.service;

import io.renatofreire.poc_spring_graphql.dto.AuthorInput;
import io.renatofreire.poc_spring_graphql.model.Author;
import io.renatofreire.poc_spring_graphql.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author getById(final Long id){
        return authorRepository.findById(id).orElseGet(Author::new);
    }

    public Author createNewAuthor(final AuthorInput newAuthor){
        Author authorToSave = new Author(newAuthor.name());
        return authorRepository.save(authorToSave);
    }

    public Author updateAuthorName(final Long authorId, final AuthorInput updatedAuthor){
        Author author = authorRepository.findById(authorId).orElseThrow(EntityNotFoundException::new);
        author.setName(updatedAuthor.name());
        return authorRepository.save(author);
    }

}
