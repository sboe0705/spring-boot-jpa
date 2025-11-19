-- create schema
create table "announcement" ("audience" varchar(255), "priority" tinyint not null check ("priority" between 0 and 2), "id" bigint not null, primary key ("id"));
create table "comment" ("likes" integer not null, "id" bigint not null, primary key ("id"));
create table "content" ("id" bigint not null, "text" varchar(255) not null, "title" varchar(255) not null, primary key ("id"));
create sequence "content_seq" start with 1 increment by 50;
-- migrate data
insert into "content" ("id", "title", "text") select "id", "title", "text" from "article";
alter table "article" drop column "title";
alter table "article" drop column "text";
-- add constraints
alter table if exists "announcement" add constraint "FK9nlf9bei31dwjq12pwq6rmqcc" foreign key ("id") references "content";
alter table if exists "article" add constraint "FKbeyck6cwbaex60v96x6tmx6vf" foreign key ("id") references "content";
alter table if exists "comment" add constraint "FKipac5vwyd8t9ec03mynxnh18u" foreign key ("id") references "content";
-- migrate sequences
alter sequence "content_seq" restart with (select base_value from information_schema.sequences where sequence_name = 'article_seq');
drop sequence if exists "article_seq";
