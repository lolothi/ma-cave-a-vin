package macaveavin.app.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wine_id;

    @Column(name= "name")
    private String name;

    @Column(name= "year")
    private Integer year;

    @Column(name= "type")
    private String type;

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

    public wine(String name, Integer year, String country, String ean, String comments) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.ean = ean;
        this.comments = comments;
    }
}
