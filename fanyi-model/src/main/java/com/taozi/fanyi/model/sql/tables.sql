--sys
create table user(id int primary key, email varchar(30), user_name varchar(30), user_pass varchar(50), user_type char(1));
insert into user values(1, 'admin@admin.com', 'admin', 'MjEyMzJmMjk3YTU3YTVhNzQzODk0YTBlNGE4MDFmYzM=', 'N');

create table mask(id int primary key, user_id int, role_id int);
insert into mask values(1,1,1);

create table role(id int primary key, description varchar(100));
insert into role values(1,'base role');

create table authentication(id int primary key, role_id int, auth_id int);
insert into authentication values(1,1,1);
insert into authentication values(2,1,2);
insert into authentication values(3,1,3);
insert into authentication values(4,1,4);
insert into authentication values(5,1,5);
insert into authentication values(6,1,6);
insert into authentication values(7,1,7);

create table authority(id int primary key, action_key varchar(50));
insert into authority values(1, '/home');
insert into authority values(2, '/topic');
insert into authority values(3, '/topic/add');
insert into authority values(4, '/topic/addSave');
insert into authority values(5, '/topic/delete');
insert into authority values(6, '/topic/edit');
insert into authority values(7, '/topic/editSave');

create table exception(id int primary key, user_id int, authority_id int, expt_type char(1)); --add or remove

--biz
create table biz_topic(id int unsigned primary key auto_increment, user_id int, title varchar(50), content varchar(1000)) AUTO_INCREMENT=1;