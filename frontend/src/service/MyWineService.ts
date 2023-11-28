import axios, { AxiosError } from "axios";
import { Wine } from "../classes/WineClass";

// for tests
// const bordeau = new Wine(0, "Bon bordeau", 2020, "", "", "", "", 2);
// const coteDuRhone = new Wine(1, "Meilleur Cote du rhône", 2021, "", "", "", "", 2);
// const listeDeVins = [ bordeau, coteDuRhone ]

export default {
  async getWines(): Promise<Wine[]> {
    try {
      const response = await axios.get("/api/wine");
      return response.data;
    } catch (error: unknown) {
      if (axios.isAxiosError(error)) {
        throw (error as AxiosError).response;
      } else {
        throw error;
      }
    }
  },

  async getOneWine(id: number): Promise<Wine> {
    try {
      console.log("---wineID:", id);
      const response = await axios.get(`/api/wine/${id}`);
      return response.data;
      // return coteDuRhone;
    } catch (error: unknown) {
      if (axios.isAxiosError(error)) {
        throw (error as AxiosError).response;
      } else {
        throw error;
      }
    }
  },

  // async updateWine(id: number, newFields:object): Promise<Wine> {
  //   try {
  //     const response = await axios.get(`/api/wine/${id}`);
  //     console.log("---wineID:", id);
  //     return response.data;
  //   } catch (error: unknown) {
  //     if (axios.isAxiosError(error)) {
  //       throw (error as AxiosError).response;
  //     } else {
  //       throw error;
  //     }
  //   }
  // },
};
