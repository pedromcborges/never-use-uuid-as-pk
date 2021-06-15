create table user_string (id varchar(36) primary key not null, name varchar(255));
create table user_binary (id binary(16) primary key not null, name varchar(255));

DELIMITER #
CREATE FUNCTION UUID_TO_BIN(uuid CHAR(36), f BOOLEAN)
    RETURNS BINARY(16)
    DETERMINISTIC
BEGIN
    RETURN UNHEX(CONCAT(
            IF(f,SUBSTRING(uuid, 15, 4),SUBSTRING(uuid, 1, 8)),
            SUBSTRING(uuid, 10, 4),
            IF(f,SUBSTRING(uuid, 1, 8),SUBSTRING(uuid, 15, 4)),
            SUBSTRING(uuid, 20, 4),
            SUBSTRING(uuid, 25))
        );
END #
DELIMITER ;

delimiter #
create procedure load_user_string_data()
begin
    declare v_max int unsigned default 1000000;
    declare v_counter int unsigned default 0;

    truncate table user_string;
    start transaction;
    while v_counter < v_max do
            insert into user_string values (uuid(), 'name');
            set v_counter=v_counter+1;
        end while;
    commit;
end #
delimiter ;

delimiter #
create procedure load_user_binary_data()
begin
    declare v_max int unsigned default 1000000;
    declare v_counter int unsigned default 0;

    truncate table user_binary;
    start transaction;
    while v_counter < v_max do
            insert into user_binary values (UUID_TO_BIN(uuid(), true), 'name');
            set v_counter=v_counter+1;
        end while;
    commit;
end #
delimiter ;

call load_user_string_data();
call load_user_binary_data();