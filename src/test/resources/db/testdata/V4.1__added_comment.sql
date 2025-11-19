insert into "content" ("id", "title", "text") values (next value for "content_seq", 'Great Article!', 'I really enjoyed reading this piece, very insightful and well-written.');
insert into "comment" ("id", "likes") values ((select max("id") from "content"), 100);
