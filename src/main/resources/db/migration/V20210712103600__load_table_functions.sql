DELIMITER #
CREATE FUNCTION UUID_TO_BIN(uuid CHAR(36), f BOOLEAN)
    RETURNS BINARY(16)
    DETERMINISTIC
BEGIN
    RETURN UNHEX(CONCAT(
            IF(f, SUBSTRING(uuid, 15, 4), SUBSTRING(uuid, 1, 8)),
            SUBSTRING(uuid, 10, 4),
            IF(f, SUBSTRING(uuid, 1, 8), SUBSTRING(uuid, 15, 4)),
            SUBSTRING(uuid, 20, 4),
            SUBSTRING(uuid, 25))
        );
END #
DELIMITER ;

delimiter #
create procedure load_user_data()
begin
    declare v_max int unsigned default 10;
    declare v_counter int unsigned default 1;

    start transaction;
    while v_counter < v_max
        do
            insert into user (id, name) values (v_counter, 'name');
            insert into address (user_id, street, neighborhood, city, country, number)
            VALUES (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50);
            set v_counter = v_counter + 1;
        end while;
    commit;
end #
delimiter ;

delimiter #
create procedure load_user_bin_data()
begin
    declare v_max int unsigned default 10;
    declare v_counter int unsigned default 1;

    start transaction;
    while v_counter < v_max
        do
            insert into user_bin (id, external_id, name) values (v_counter, UUID_TO_BIN(uuid(), true), 'name');
            insert into address_bin (user_id, street, neighborhood, city, country, number)
            VALUES (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50),
                   (v_counter, 'street', 'neighborhood', 'city', 'country', 50);
            set v_counter = v_counter + 1;
        end while;
    commit;
end #
delimiter ;

delimiter #
create procedure load_user_uuid_varchar_data()
begin
    declare v_max int unsigned default 10;
    declare v_counter int unsigned default 1;
    declare identity varchar(36) default uuid();

    start transaction;
    while v_counter < v_max
        do
            insert into user_uuid_varchar (id, name) values (identity, 'name');
            insert into address_uuid_varchar (user_id, street, neighborhood, city, country, number)
            VALUES (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50);
            set v_counter = v_counter + 1;
            set identity = uuid();
        end while;
    commit;
end #
delimiter ;

delimiter #
create procedure load_user_uuid_bin_data()
begin
    declare v_max int unsigned default 10;
    declare v_counter int unsigned default 1;
    declare identity binary(16) default UUID_TO_BIN(uuid(), true);

    start transaction;
    while v_counter < v_max
        do
            insert into user_uuid_bin (id, name) values (identity, 'name');
            insert into address_uuid_bin (user_id, street, neighborhood, city, country, number)
            VALUES (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50),
                   (identity, 'street', 'neighborhood', 'city', 'country', 50);
            set v_counter = v_counter + 1;
            set identity = UUID_TO_BIN(uuid(), true);
        end while;
    commit;
end #
delimiter ;

call load_user_data();
call load_user_bin_data();
call load_user_uuid_varchar_data();
call load_user_uuid_bin_data();