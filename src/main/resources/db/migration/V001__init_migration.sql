CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.product
(
    id               serial NOT NULL primary key,
    name             text NOT NULL,
    cost             integer
    );
-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.user
(
    id               serial NOT NULL primary key,
    name             text NOT NULL,
    password         text NOT NULL,
    role             text NOT NULL
    );



