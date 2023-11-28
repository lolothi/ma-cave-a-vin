export class Wine {
  wine_id: number;
  name: String;
  available_year: number;
  type: string;
  country: string;
  producer: string;
  variety: string;
  designation: string;
  ean: string;
  picture_link: string;
  with_food: string;
  note: number;
  comments: string;
  tag: string;
  quantity_tot: number;
  quantity_in_wine_cellar: number;

  constructor(
    wine_id: number,
    name: String,
    available_year: number,
    type: string,
    country: string,
    producer: string,
    variety: string,
    designation: string,
    ean: string,
    picture_link: string,
    with_food: string,
    note: number,
    comments: string,
    tag: string,
    quantity_tot: number,
    quantity_in_wine_cellar: number
  ) {
    this.wine_id = wine_id;
    this.name = name;
    this.available_year = available_year;
    this.type = type;
    this.country = country;
    this.producer = producer;
    this.variety = variety;
    this.designation = designation;
    this.ean = ean;
    this.picture_link = picture_link;
    this.with_food = with_food;
    this.note = note;
    this.comments = comments;
    this.tag = tag;
    this.quantity_tot = quantity_tot;
    this.quantity_in_wine_cellar = quantity_in_wine_cellar;
  }
}
