package macaveavin.app.api.dto;

import lombok.Getter;
import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;

public class CellarPlaceWineDto {
    private Long cellarPlaceWineId;
    private Wine wine;
    private CellarPlace cellarPlace;
    private Integer quantityBottle;

    public Long getCellarPlaceWineId() {
        return cellarPlaceWineId;
    }

    public void setCellarPlaceWineId(Long cellarPlaceWineId) {
        this.cellarPlaceWineId = cellarPlaceWineId;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public CellarPlace getCellarPlace() {
        return cellarPlace;
    }

    public void setCellarPlace(CellarPlace cellarPlace) {
        this.cellarPlace = cellarPlace;
    }

    public Integer getQuantityBottle() {
        return quantityBottle;
    }

    public void setQuantityBottle(Integer quantityBottle) {
        this.quantityBottle = quantityBottle;
    }

    public CellarPlaceWineDto(Long cellarPlaceWineId, Wine wine, CellarPlace cellarPlace, Integer quantityBottle) {
        this.cellarPlaceWineId = cellarPlaceWineId;
        this.wine = wine;
        this.cellarPlace = cellarPlace;
        this.quantityBottle = quantityBottle;
    }

    public CellarPlaceWineDto() {
    }
}
