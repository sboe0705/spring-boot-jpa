alter table if exists "announcement" alter column "priority" set data type varchar(255);
update "announcement" set "priority" = 'LOW' where "priority" = 0;
update "announcement" set "priority" = 'MEDIUM' where "priority" = 1;
update "announcement" set "priority" = 'HIGH' where "priority" = 2;
