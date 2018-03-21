create database weixin;
create table admin(
id int primary key auto_increment,
aname char(20)  unique not null,
apassword char(20) not null

)
drop table admin;
create sequence seq_aid start with 100 increment by  1;
insert into admin(aname,apassword) values ('admin','a');