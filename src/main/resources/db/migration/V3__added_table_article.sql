create table "article" ("id" bigint not null, "summary" varchar(255), "text" varchar(255) not null, "title" varchar(255) not null, "topic" varchar(255), primary key ("id"));
create sequence "article_seq" start with 1 increment by 50;
