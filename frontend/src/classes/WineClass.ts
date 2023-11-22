export class Wine {
    wine_id:number;
    name:String;
    available_year:number; 
    type: string;
    country: string;
    ean: string;
    comments: string;
    bottlesNumber:number
  
    constructor(wine_id:number, name:String, available_year:number, type: string, country: string, ean: string, comments: string, bottlesNumber:number) {
      this.wine_id = wine_id;
      this.name = name;
      this.available_year = available_year;
      this.type = type;
      this.country = country;
      this.ean = ean;
      this.comments = comments;
      this.bottlesNumber = bottlesNumber
    }
  }