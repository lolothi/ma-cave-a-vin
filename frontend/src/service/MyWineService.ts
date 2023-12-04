import axios, { AxiosError } from "axios";
import { Wine } from "../classes/WineClass";

const api = '/api';

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

  async addWine(newBottle: Wine) {
    console.log("PROOOO", newBottle);
    try {
      console.log("TRY");
      axios.post(`${api}/wine`, { 'name':'toto'}, {
        headers: {
          // 'Authorization': 'Bearer YOUR_API_KEY',
          // 'Content-Type': 'application/json',
          'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
          'Access-Control-Allow-Origin': '*',
        }});
        console.log("TRY-ok");
    } catch (error) {
      console.log("ERREUR: ", error);
      throw error;
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
