create database book;
use book;

create table author(
    id varchar(100) not null,
    author varchar(50),
    primary key (id)
);

create table book(
    id varchar(100) not null,
    name varchar(30),
    type varchar(30),
    page_count int,
    author_id varchar(100) not null,
    primary key (id),
    constraint fk_book_author foreign key (author_id) references author(id)
);