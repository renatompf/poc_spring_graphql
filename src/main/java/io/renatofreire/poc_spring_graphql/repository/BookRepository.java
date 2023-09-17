package io.renatofreire.poc_spring_graphql.repository;

import io.renatofreire.poc_spring_graphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
