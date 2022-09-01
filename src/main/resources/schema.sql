drop table if exists user;

create table user (
    id int not null auto_increment,
    name varchar(128) not null,
    email varchar(128) not null,
    primary key (id)
) default character set utf8 collate utf8_general_ci;