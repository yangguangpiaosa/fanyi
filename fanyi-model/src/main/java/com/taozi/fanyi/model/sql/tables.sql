create table user(id int primary key, email varchar(30), user_name varchar(30), user_pass varchar(50), user_type char(1));
insert into user values(1, 'admin@admin.com', 'admin', 'MjEyMzJmMjk3YTU3YTVhNzQzODk0YTBlNGE4MDFmYzM=', 'N');

create table mask(id int primary key, user_id int, role_id int);
insert into mask values(1,1,1);

create table role(id int primary key, description varchar(100));
insert into role values(1,'base role');

create table authentication(id int primary key, role_id int, auth_id int);
insert into authentication values(1,1,1);

create table authority(id int primary key, action_key varchar(50));
insert into authority values(1, '/home');

create table exception(id int primary key, user_id int, authority_id int, expt_type char(1)); --add or remove