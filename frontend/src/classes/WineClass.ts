export class Wine {
    id:number;
    name:String;
    available_year:number; 
    type: string;
    country: string;
    ean: string;
    comments: string;
    bottlesNumber:number
  
    constructor(id:number, name:String, available_year:number, type: string, country: string, ean: string, comments: string, bottlesNumber:number) {
      this.id = id;
      this.name = name;
      this.available_year = available_year;
      this.type = type;
      this.country = country;
      this.ean = ean;
      this.comments = comments;
      this.bottlesNumber = bottlesNumber
    }
  }