BEGIN;

-- Create the Author table
CREATE TABLE IF NOT EXISTS author
(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Create the Book table
CREATE TABLE IF NOT EXISTS book
(
      ISBN VARCHAR(255) PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      publisher VARCHAR(255),
      author_id INTEGER REFERENCES author(id)
);

COMMIT;