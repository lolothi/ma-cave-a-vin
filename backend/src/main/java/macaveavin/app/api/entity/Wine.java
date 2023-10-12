package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name= "ean")
    private String ean;

    @Column(name= "comments")
    private String comments;

    public Long getWine_id() {
        return wine_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailable_year() {
        return available_year;
    }

    public void setAvailable_year(Integer available_year) {
        this.available_year = available_year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public WineTypeEnum getType() {
        return type;
    }

    public void setType(WineTypeEnum type) {
        this.type = type;
    }

    public Wine(String name, Integer available_year, WineTypeEnum type, String country, String ean, String comments) {
        this.name = name;
        this.available_year = available_year;
        this.type = type;
        this.country = country;
        this.ean = ean;
        this.comments = comments;
    }

    public Wine() {
    }
}
