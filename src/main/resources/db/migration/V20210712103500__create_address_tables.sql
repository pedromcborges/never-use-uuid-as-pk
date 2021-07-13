create table address_varchar
(
    id           bigint not null auto_increment,
    user_id      bigint,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_varchar(id)
);
create table address_bin
(
    id           bigint not null auto_increment,
    user_id      bigint,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_bin(id)
);
create table address_uuid_varchar
(
    id           bigint not null auto_increment,
    user_id      varchar(36),
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_uuid_varchar(id)
);
create table address_uuid_bin
(
    id           bigint not null auto_increment,
    user_id      binary(16),
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_uuid_bin(id)
);