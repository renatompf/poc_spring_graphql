# poc_spring_graphql

## Description:
This was a small project impleted in [JAVA 17](https://www.java.com/en/) to understand how does [Spring for GraphQL](https://spring.io/projects/spring-graphql) works.<br>
To handle the data I used [PostgresQL](https://www.postgresql.org).

## How to run it:
In order to run this project you will need [Docker](https://www.docker.com/) and Java 17 - or higher.

In order to run this project the simpler way would be to make:

```shell
make run
```

This way you will start a container running the database and the app itself. Everything will start automatically.<br>

To stop it, you can simply make:
```shell
make stop
```

## How to test it:
Once your application has started you can go to`localhost:8080/graphiql` and try the following queries:

### Queries:

1. Get All Books:
    ```graphql
       query {
           books {
             ISBN
             title
             publisher
           }
        }
    ```
2. Get Book By Id:
    ```graphql
       query {
           booksById(bookISBN: "857904910-5") {
                   title
                   publisher
         }
       }
    ```
3. Get ALl Authors:
    ```graphql
       query {
           authors {
             id
             name
           }
        }
    ```
4. Get Author By Id:
    ```graphql
       query {
           authorsById(authorId: 1) {
              name
           }
       }
    ```
   
### Mutations:

1. Add new Book:
    ```graphql
        mutation{
            books(newBook: {
                ISBN: "0321349601",
                title: "Java Concurrency in Practice",
                publisher: "Addison-Wesley Professional",
                authorId: 1
            }){
                title
            }
        }
    ```
2. Add new User:
    ```graphql
        mutation{
          authors(newAuthor:{
               name: "Joshua Bloch"
             }){
                 id
             }
         }
    ```
3. Delete Book by Id:
    ```graphql
        mutation{
            deleteBook(bookISBN: "857904910-5")
        }
    ```
   
4.  Update User Name By Id:
    ```graphql
        mutation{
              updateAuthorName(authorId: 1, updatedAuthor: {
                   name: "John Who"
              })
                {
                    id
                    name 
                }
        }
    ```
    
These are just some examples to guide you. Feel free to use them as you want and play around with it! 
