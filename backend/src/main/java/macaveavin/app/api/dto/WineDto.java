package macaveavin.app.api.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import macaveavin.app.api.entity.WineTypeEnum;

@Getter
@Data
public class WineDto {

    private Long wine_id;

    private String name;

    private Integer available_year;

    private WineTypeEnum type;

    private String country;

    private String producer;
    //fr:cépage
    private String variety;
    //fr:appelation
    private String designation;

    private String ean;

    private String picture_link;

    private String with_food;

    private Integer note;

    private String comments;

    private String tag;

    private Integer quantity_tot;

    private Integer quantity_in_wine_Cellar;



    public void setWine_id(Long wine_id) {
        this.wine_id = wine_id;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    public void setWith_food(String with_food) {
        this.with_food = with_food;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable_year(Integer available_year) {
        this.available_year = available_year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setType(WineTypeEnum type) {
        this.type = type;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setQuantity_tot(Integer quantity_tot) {
        this.quantity_tot = quantity_tot;
    }

    public void setQuantity_in_wine_Cellar(Integer quantity_in_wine_Cellar) {
        this.quantity_in_wine_Cellar = quantity_in_wine_Cellar;
    }

    public WineDto(Long wine_id, String name, Integer available_year, WineTypeEnum type, String country, String producer, String variety, String designation, String ean, String picture_link, String with_food, Integer note, String comments, String tag, Integer quantity_tot, Integer quantity_in_wine_Cellar) {
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
        this.quantity_in_wine_Cellar = quantity_in_wine_Cellar;
    }


    public WineDto() {
    }
}
