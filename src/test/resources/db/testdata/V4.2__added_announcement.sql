insert into "content" ("id", "title", "text") values (next value for "content_seq", 'System Maintenance', 'The platform will undergo scheduled maintenance tonight between 02:00 and 03:00 UTC.');
insert into "announcement" ("id", "priority", "audience") values ((select max("id") from "content"), 0, 'All users');
