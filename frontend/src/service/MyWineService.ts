import { Wine } from '../classes/WineClass';
import axios from "axios";

//a CHANGER
const APIwine = "192.168.1.29:9000/wine"

const bordeau = new Wine(0, "Bon bordeau", 2020, "", "", "", "", 2);
const coteDuRhone = new Wine(1, "Meilleur Cote du rhône", 2021, "", "", "", "", 2);
const listeDeVins = [ bordeau, coteDuRhone ]

export default {
//   getWines() {
//     return listeDeVins
// },
async getWines() {
  return axios
  // .get(`${APIwine}`)
  .get('http://192.168.1.29:9000/wine')
  .then((res) => {
   res.data, 
   console.log(res.data)})
  .catch((err)=> {throw err.response;})
},

  async getOneWine(id: number) {
   return axios
   .get(`${APIwine}/${id}`)
   .then((res) => {
    res.data, 
    console.log(res.data)})
   .catch((err)=> {throw err.response;})
}

//   getOneWineData(id: number) {
//   try {
//     const oneWineData = listeDeVins.find(Object => Object.id === id);
//     if (oneWineData) {
//       return oneWineData;
//     } else {
//       throw new Error(`No wine found with ID: ${id}`);
//     }
//   } catch (error) {
//     throw error;
//   }
  
// }


};