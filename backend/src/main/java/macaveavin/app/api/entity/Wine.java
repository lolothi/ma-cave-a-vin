package macaveavin.app.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wine_id;

    @Column(name= "name")
    private String name;

    @Column(name= "year")
    private Integer year;

    @Column(name= "type")
    private WineTypeEnum type;

    @Column(name= "country")
    private String country;

    @Column(name= "ean")
    private String ean;

    @Column(name= "comments")
    private String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Wine(String name, Integer year, WineTypeEnum type, String country, String ean, String comments) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.country = country;
        this.ean = ean;
        this.comments = comments;
    }
}
