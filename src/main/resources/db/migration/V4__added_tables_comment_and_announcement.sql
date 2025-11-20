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
alter table if exists "announcement" add constraint "fk_announcement_content" foreign key ("id") references "content";
alter table if exists "article" add constraint "fk_article_content" foreign key ("id") references "content";
alter table if exists "comment" add constraint "fk_comment_content" foreign key ("id") references "content";
-- migrate sequences
alter sequence "content_seq" restart with (select base_value from information_schema.sequences where sequence_name = 'article_seq');
drop sequence if exists "article_seq";
