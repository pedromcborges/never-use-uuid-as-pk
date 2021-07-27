create table address
(
    id           bigint not null auto_increment,
    user_id      bigint not null,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user (id)
);
create table address_hybrid
(
    id           bigint not null auto_increment,
    user_id      bigint not null,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_hybrid (id)
);
create table address_uuid_varchar
(
    id           varchar(36) not null unique,
    user_id      varchar(36) not null,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_uuid_varchar (id)
);
create table address_uuid_bin
(
    id           binary(16) not null unique,
    user_id      binary(16) not null,
    street       varchar(256),
    neighborhood varchar(256),
    city         varchar(256),
    country      varchar(256),
    number       integer,
    primary key (id),
    foreign key (user_id) references user_uuid_bin (id)
);