package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name= "wine")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wine_id;

    @Column(name= "name")
    private String name;

    @Column(name= "available_year")
    private Integer available_year;

    @Column(name= "type")
    private WineTypeEnum type;

    @Column(name= "country")
    private String country;

    @Column(name= "producer")
    private String producer;
    //fr:cépage
    @Column(name= "variety")
    private String variety;
    //fr:appelation
    @Column(name= "designation")
    private String designation;

    @Column(name= "ean")
    private String ean;

    @Column(name= "picture_link")
    private String picture_link;

    @Column(name= "with_food")
    private String with_food;

    @Column(name= "note")
    private Integer note;

    @Column(name= "comments")
    private String comments;

    @Column(name= "tag")
    private String tag;

    @Column(name= "quantity_tot")
    private Integer quantity_tot;

    @Column(name= "quantity_in_wine_Cellar")
    private Integer quantity_in_wine_Cellar;

    public void setTag(String tag) {
        this.tag = tag;
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

    public void setQuantity_tot(Integer quantity_tot) {
        this.quantity_tot = quantity_tot;
    }

    public void setQuantity_in_wine_Cellar(Integer quantity_in_wine_Cellar) {
        this.quantity_in_wine_Cellar = quantity_in_wine_Cellar;
    }

    public Wine(String name, Integer available_year, WineTypeEnum type, String country, String producer, String variety, String designation, String ean, String picture_link, String with_food, Integer note, String comments, String tag, Integer quantity_tot, Integer quantity_in_wine_Cellar) {
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

    public Wine() {
    }
}
