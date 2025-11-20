alter table if exists "content" add column "author_id" bigint;
alter table if exists "content" add constraint "fk_content_user" foreign key ("author_id") references "user";
