package macaveavin.app.api.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import macaveavin.app.api.entity.WineTypeEnum;

@Data
public class WineDto {

    private Long wine_id;

    private String name;

    private Integer year;

    private WineTypeEnum type;

    private String country;

    private String ean;

    private String comments;

    public Long getWine_id() {
        return wine_id;
    }

    public void setWine_id(Long wine_id) {
        this.wine_id = wine_id;
    }

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

    public WineDto(Long wine_id, String name, Integer year, WineTypeEnum type, String country, String ean, String comments) {
        this.wine_id = wine_id;
        this.name = name;
        this.year = year;
        this.type = type;
        this.country = country;
        this.ean = ean;
        this.comments = comments;
    }

    public WineDto() {
    }
}
