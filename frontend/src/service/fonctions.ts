class Wine {
  name:String;
  year:number; 
  bottlesNumber:number

  constructor(name:String, year:number, bottlesNumber:number) {
    this.name = name;
    this.year = year;
    this.bottlesNumber = bottlesNumber
  }
}

const bordeau = new Wine("Bon bordeau", 2020, 2);
const coteDuRhone = new Wine("Meilleur Cote du rhône", 2021, 2);

export function getWineData() {
    return [ bordeau, coteDuRhone ]
  }