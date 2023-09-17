package io.renatofreire.poc_spring_graphql.repository;

import io.renatofreire.poc_spring_graphql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
