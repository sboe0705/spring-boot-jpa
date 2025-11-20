alter table if exists "user" drop constraint if exists unique_fullname;
alter table if exists "user" add constraint unique_fullname unique ("firstname", "lastname");
