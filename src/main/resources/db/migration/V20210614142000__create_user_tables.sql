create table user
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);
create table user_hybrid
(
    id   bigint not null auto_increment,
    external_id binary(16) unique not null,
    name varchar(255),
    primary key (id)
);
create table user_uuid_varchar
(
    id   varchar(36) not null unique,
    name varchar(255),
    primary key (id)
);
create table user_uuid_bin
(
    id   binary(16) not null unique,
    name varchar(255),
    primary key (id)
);
