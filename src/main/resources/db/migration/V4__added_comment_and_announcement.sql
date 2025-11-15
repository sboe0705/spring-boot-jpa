create table "announcement" ("audience" varchar(255), "priority" tinyint not null check ("priority" between 0 and 2), "id" bigint not null, primary key ("id"));
create table "comment" ("likes" integer not null, "id" bigint not null, primary key ("id"));
create table "content" ("id" bigint not null, "text" varchar(255) not null, "title" varchar(255) not null, primary key ("id"));
create sequence "content_seq" start with 1 increment by 50;
alter table if exists "announcement" add constraint "FK9nlf9bei31dwjq12pwq6rmqcc" foreign key ("id") references "content";
alter table if exists "article" add constraint "FKbeyck6cwbaex60v96x6tmx6vf" foreign key ("id") references "content";
alter table if exists "comment" add constraint "FKipac5vwyd8t9ec03mynxnh18u" foreign key ("id") references "content";
drop sequence if exists "article_seq";
