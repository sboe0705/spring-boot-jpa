create sequence "user_seq" start with 1 increment by 50;
create table "user" (id bigint not null, firstname varchar(255) not null, lastname varchar(255) not null, primary key (id));
