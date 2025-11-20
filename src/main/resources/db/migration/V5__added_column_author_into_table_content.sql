alter table if exists "content" add column "author_id" bigint;
alter table if exists "content" add constraint "fk_content_user" foreign key ("author_id") references "user";
-- create and assign (technical) user
delete from "user" where firstname = 'unknown' and lastname = 'unknown';
insert into "user" (id, firstname, lastname) values (next value for "user_seq", 'unknown', 'unknown');
update content set author_id = (select id from "user" where firstname = 'unknown' and lastname = 'unknown');
alter table if exists "content" alter column "author_id" set not null;
