import axios, { AxiosError } from "axios";
import { Wine } from "../classes/WineClass";

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
      const response = await axios.get(`/api/wine/${id}`);
      console.log("---wineID:", id);
      return response.data;
    } catch (error: unknown) {
      if (axios.isAxiosError(error)) {
        throw (error as AxiosError).response;
      } else {
        throw error;
      }
    }
  },
};
