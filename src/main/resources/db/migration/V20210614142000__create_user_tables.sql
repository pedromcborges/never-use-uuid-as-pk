create table user_varchar
(
    id   bigint not null auto_increment,
    uuid varchar(36),
    name varchar(255),
    primary key (id)
);
create table user_bin
(
    id   bigint not null auto_increment,
    uuid binary(16),
    name varchar(255),
    primary key (id)
);
create table user_uuid_varchar
(
    id   varchar(36) not null,
    name varchar(255),
    primary key (id)
);
create table user_uuid_bin
(
    id   binary(16) not null,
    name varchar(255),
    primary key (id)
);
