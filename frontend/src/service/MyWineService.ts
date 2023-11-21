import { Wine } from '../classes/WineClass';

const bordeau = new Wine(0, "Bon bordeau", 2020, "", "", "", "", 2);
const coteDuRhone = new Wine(1, "Meilleur Cote du rhône", 2021, "", "", "", "", 2);
const listeDeVins = [ bordeau, coteDuRhone ]

export function getWineData() {
    return listeDeVins
}

export function getOneWineData(id: number) {
  try {
    const oneWineData = listeDeVins.find(Object => Object.id === id);
    if (oneWineData) {
      return oneWineData;
    } else {
      throw new Error(`No wine found with ID: ${id}`);
    }
  } catch (error) {
    throw error;
  }
  
}