package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name= "wine")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "wine_id")
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
