alter table if exists "content" add column "author_id" bigint not null;
alter table if exists "content" add constraint "FKi5yutdmsp0amanhhki4u3gx33" foreign key ("author_id") references "user";
