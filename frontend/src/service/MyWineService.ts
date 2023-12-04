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
    try {
      console.log("TRY", newBottle);
      const response = await axios.post("/api/wine", { name: 'toto' }, {
        headers: {
          'Content-Type': 'application/json'
        }});
        console.log("TRY-ok", response.data);
    } catch (error: unknown) {
      console.log("EEERRRRRROOOORR");
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
