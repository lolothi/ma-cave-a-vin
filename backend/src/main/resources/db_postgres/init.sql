CREATE TABLE wine (
  wine_id integer generated always as IDENTITY,
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
  tag varchar(100),
  primary KEY(wine_id)
);

CREATE TABLE cellar (
    cellar_id integer generated always as IDENTITY,
    name varchar(100),
    quantity_location_x integer,
    quantity_location_y integer,
    quantity_location_z integer,
    quantity_bottle_max integer,
    primary KEY(cellar_id)

);

CREATE TABLE cellar_place (
    cellar_place_id integer generated always as IDENTITY,
    position_x integer,
    position_y integer,
    position_z integer,
    position_opt varchar(100),
    quantity_bottle_max integer DEFAULT 0,
    cellar_id integer,
    primary KEY(cellar_place_id),
    CONSTRAINT cellar_FK FOREIGN KEY (cellar_id) REFERENCES cellar(cellar_id)
);
-- table de liaison
CREATE TABLE cellar_place_wine (
                                   cellar_place_wine_id integer generated always as IDENTITY,
                                   cellar_place_id integer,
                                   wine_id integer,
                                   quantity_bottle integer DEFAULT 0,
                                   PRIMARY KEY (cellar_place_id, wine_id),
                                   FOREIGN KEY (cellar_place_id) REFERENCES cellar_place(cellar_place_id),
                                   FOREIGN KEY (wine_id) REFERENCES wine(wine_id)
);