CREATE TABLE If NOT EXISTS candidate (
   id SERIAL PRIMARY KEY,
   name TEXT,
   cityId integer,
   createdTime date
);
CREATE TABLE If NOT EXISTS post (
   id SERIAL PRIMARY KEY,
   name TEXT,
   cityId int,
   createdTime date
);
CREATE TABLE If NOT EXISTS city (
   id SERIAL PRIMARY KEY,
   name TEXT
);
CREATE TABLE If NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   email TEXT,
   name TEXT,
   password TEXT,
   createdTime date
);

insert into city("name") values ('Moscow');
insert into city("name") values ('Stalingrad');
insert into city("name") values ('Uhta');