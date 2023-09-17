package io.renatofreire.poc_spring_graphql.dto;

public record BookInput(
        String ISBN,
        String title,
        String publisher,
        Long authorId
) {
}
