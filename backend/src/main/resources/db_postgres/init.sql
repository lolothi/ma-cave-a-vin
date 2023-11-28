CREATE TABLE wine (
  wine_id serial PRIMARY key,
  name varchar(100),
  available_year integer,
  type varchar(100),
  country varchar(100),
  producer varchar(100),
  variety varchar(100),
  designation varchar(100),
  ean varchar(100),
  with_food varchar(100),
  note integer,
  comments varchar(1000),
  picture_link varchar(100),
  quantity_tot integer,
  quantity_in_wine_Cellar integer,
  tag varchar(100)
);

CREATE TABLE my_wine (
                         my_wine_id integer generated always as IDENTITY,
                         position varchar(100),
                         position_opt varchar(100),
                         quantity integer,
                         wine_id integer,
                         primary KEY(my_wine_id),
                         CONSTRAINT wine_FK FOREIGN KEY (wine_id) REFERENCES wine(wine_id)
);
