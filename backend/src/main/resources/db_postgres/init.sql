CREATE TABLE wine (
  wine_id serial PRIMARY key,
  name varchar(100),
  available_year integer,
  type varchar(100),
  country varchar(100),
  ean varchar(100),
  comments varchar(1000)
);

CREATE TABLE my_wine (
  my_wine_id serial PRIMARY key,
  position varchar(100),
  quantity integer,
  wine_ref_id integer,
  CONSTRAINT wine_FK FOREIGN KEY (wine_ref_id) REFERENCES wine (wine_id)
);