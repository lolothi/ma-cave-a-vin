package macaveavin.app.api.dto;

import lombok.Data;
import lombok.Getter;
import macaveavin.app.api.entity.WineTypeEnum;

@Data
public class WineDto {

    private Long wineId;

    private String name;

    private Integer availableYear;

    private WineTypeEnum type;

    private String country;

    private String producer;
    //fr:cépage
    private String variety;
    //fr:appelation
    private String designation;

    private String ean;

    private String pictureLink;

    private String withFood;

    private Integer note;

    private String comments;

    private String tag;

    private Integer quantityTot;

    private Integer quantityInWineCellar;

    public Long getWineId() {
        return wineId;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailableYear() {
        return availableYear;
    }

    public WineTypeEnum getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getProducer() {
        return producer;
    }

    public String getVariety() {
        return variety;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEan() {
        return ean;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public String getWithFood() {
        return withFood;
    }

    public Integer getNote() {
        return note;
    }

    public String getComments() {
        return comments;
    }

    public String getTag() {
        return tag;
    }

    public Integer getQuantityTot() {
        return quantityTot;
    }

    public Integer getQuantityInWineCellar() {
        return quantityInWineCellar;
    }

    public void setWineId(Long wineId) {
        this.wineId = wineId;
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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setQuantityTot(Integer quantityTot) {
        this.quantityTot = quantityTot;
    }

    public void setQuantityInWineCellar(Integer quantityInWineCellar) {
        this.quantityInWineCellar = quantityInWineCellar;
    }

    public WineDto(Long wineId, String name, Integer availableYear, WineTypeEnum type, String country, String producer, String variety, String designation, String ean, String pictureLink, String withFood, Integer note, String comments, String tag, Integer quantityTot, Integer quantityInWineCellar) {
        this.wineId = wineId;
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


    public WineDto() {
    }
}
