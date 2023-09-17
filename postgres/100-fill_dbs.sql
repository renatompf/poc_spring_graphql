BEGIN;

-- Insert authors
insert into author (id, name) values (1, 'Joshua Bloch');
insert into author (id, name) values (2, 'Martin Odersky');
insert into author (id, name) values (3, 'Salim Virani');
insert into author (id, name) values (4, 'Neha Narkhede');
insert into author (id, name) values (5, 'Rod Johnson');

-- Insert books
insert into book (isbn, title, publisher, author_id) values ('857904910-5', 'Effective Java', 'Tech Books Inc', 1);
insert into book (isbn, title, publisher, author_id) values ('972301677-X', 'Programming in Scala', 'Scala Publications', 2);
insert into book (isbn, title, publisher, author_id) values ('062674333-8', 'Mastering Redis', 'Tech Guru Press', 3);
insert into book (isbn, title, publisher, author_id) values ('242838548-8', 'Kafka: The Definitive Guide', 'Stream Processing Inc', 4);
insert into book (isbn, title, publisher, author_id) values ('179950578-2', 'Spring in Action', 'Spring Books Ltd', 5);

COMMIT;
