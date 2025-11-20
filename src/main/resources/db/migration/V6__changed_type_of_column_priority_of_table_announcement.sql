alter table if exists "announcement" add column "priority_new" enum ('HIGH','LOW','MEDIUM');
update "announcement" set priority_new = 'HIGH' where priority = 0;
update "announcement" set priority_new = 'MEDIUM' where priority = 1;
update "announcement" set priority_new = 'LOW' where priority = 2;
alter table if exists "announcement" drop column "priority";
alter table if exists "announcement" rename column "priority_new" to "priority";
