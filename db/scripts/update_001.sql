CREATE TABLE If NOT EXISTS candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   cityId integer
);
CREATE TABLE If NOT EXISTS post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   cityId int
);
CREATE TABLE If NOT EXISTS city (
   id SERIAL PRIMARY KEY,
   name TEXT
);
CREATE TABLE If NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   email TEXT,
   name TEXT,
   password TEXT
);