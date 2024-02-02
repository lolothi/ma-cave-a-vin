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
    private Long wineId;

    @Column(name= "name")
    private String name;

    @Column(name= "available_year")
    private Integer availableYear;

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
    private String pictureLink;

    @Column(name= "with_food")
    private String withFood;

    @Column(name= "note")
    private Integer note;

    @Column(name= "comments")
    private String comments;

    @Column(name= "tag")
    private String tag;

    @Column(name= "quantity_tot")
    private Integer quantityTot;

    @Column(name= "quantity_in_wine_Cellar")
    private Integer quantityInWineCellar;

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

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public void setWithFood(String withFood) {
        this.withFood = withFood;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableYear(Integer availableYear) {
        this.availableYear = availableYear;
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

    public void setQuantityTot(Integer quantityTot) {
        this.quantityTot = quantityTot;
    }

    public void setQuantityInWineCellar(Integer quantityInWineCellar) {
        this.quantityInWineCellar = quantityInWineCellar;
    }

    public Wine(String name, Integer availableYear, WineTypeEnum type, String country, String producer, String variety, String designation, String ean, String pictureLink, String withFood, Integer note, String comments, String tag, Integer quantityTot, Integer quantityInWineCellar) {
        this.name = name;
        this.availableYear = availableYear;
        this.type = type;
        this.country = country;
        this.producer = producer;
        this.variety = variety;
        this.designation = designation;
        this.ean = ean;
        this.pictureLink = pictureLink;
        this.withFood = withFood;
        this.note = note;
        this.comments = comments;
        this.tag = tag;
        this.quantityTot = quantityTot;
        this.quantityInWineCellar = quantityInWineCellar;
    }

    public Wine() {
    }
}
