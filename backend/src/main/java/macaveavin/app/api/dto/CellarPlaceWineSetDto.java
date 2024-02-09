package macaveavin.app.api.dto;

import macaveavin.app.api.entity.CellarPlace;
import macaveavin.app.api.entity.Wine;

public class CellarPlaceWineSetDto {
    private Long wineId;
    private Long cellarPlaceId;
    private Integer quantityBottle;

    public void setWineId(Long wineId) {
        this.wineId = wineId;
    }

    public void setCellarPlaceId(Long cellarPlaceId) {
        this.cellarPlaceId = cellarPlaceId;
    }

    public void setQuantityBottle(Integer quantityBottle) {
        this.quantityBottle = quantityBottle;
    }

    public Long getWineId() {
        return wineId;
    }

    public Long getCellarPlaceId() {
        return cellarPlaceId;
    }

    public Integer getQuantityBottle() {
        return quantityBottle;
    }

    public CellarPlaceWineSetDto(Long wineId, Long cellarPlaceId, Integer quantityBottle) {
        this.wineId = wineId;
        this.cellarPlaceId = cellarPlaceId;
        this.quantityBottle = quantityBottle;
    }
}
