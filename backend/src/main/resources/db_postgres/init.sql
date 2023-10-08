CREATE TABLE wine (
  wine_id serial PRIMARY key,
  name varchar(100),
  year integer,
  type varchar(100),
  country varchar(100),
  ean varchar(100),
  comments varchar(1000)
);