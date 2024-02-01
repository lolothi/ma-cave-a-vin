package macaveavin.app.api.dto;

import lombok.Getter;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.Wine;

@Getter
public class CellarPlaceDto {

    private Long cellarPlaceId;
    private Integer positionX;
    private Integer positionY;
    private Integer positionZ;
    private String positionOpt;
    private Integer quantityBottleMax;
    private Integer quantityBottleLeft;
    private Long wineId;
    private Long cellarId;


    public void setCellarPlaceId(Long cellarPlaceId) {
        this.cellarPlaceId = cellarPlaceId;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public void setPositionZ(Integer positionZ) {
        this.positionZ = positionZ;
    }

    public void setPositionOpt(String positionOpt) {
        this.positionOpt = positionOpt;
    }

    public void setPosition_bottle_max(Integer quantity_bottle_max) {
        this.quantityBottleMax = quantity_bottle_max;
    }

    public void setPosition_bottle_left(Integer quantity_bottle_left) {
        this.quantityBottleLeft = quantity_bottle_left;
    }

    public void setWineId(Long wineId) {
        this.wineId = wineId;
    }

    public void setCellarId(Long cellarId) {
        this.cellarId = cellarId;
    }

    public CellarPlaceDto(Long cellarPlaceId, Integer positionX, Integer positionY, Integer positionZ, String positionOpt, Integer quantityBottleMax, Integer quantityBottleLeft, Long wineId, Long cellarId) {
        this.cellarPlaceId = cellarPlaceId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.positionOpt = positionOpt;
        this.quantityBottleMax = quantityBottleMax;
        this.quantityBottleLeft = quantityBottleLeft;
        this.wineId = wineId;
        this.cellarId = cellarId;
    }

}
