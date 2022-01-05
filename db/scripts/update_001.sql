CREATE TABLE If NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   email TEXT,
   name TEXT,
   password TEXT
);
CREATE TABLE If NOT EXISTS candidate (
   id SERIAL PRIMARY KEY,
   name TEXT
);
CREATE TABLE If NOT EXISTS post (
   id SERIAL PRIMARY KEY,
   name TEXT
);