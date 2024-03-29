package macaveavin.app.api.dto;

import lombok.Getter;
import macaveavin.app.api.entity.Wine;

import java.util.List;
import java.util.Set;

@Getter
public class CellarPlaceDto {

    private Long cellarPlaceId;
    private Integer positionX;
    private Integer positionY;
    private Integer positionZ;
    private String positionOpt;
    private Integer quantityBottleMax;
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

    public void setQuantityBottleMax(Integer quantityBottleMax) {
        this.quantityBottleMax = quantityBottleMax;
    }

    public void setCellarId(Long cellarId) {
        this.cellarId = cellarId;
    }

    public CellarPlaceDto(Long cellarPlaceId, Integer positionX, Integer positionY, Integer positionZ, String positionOpt, Integer quantityBottleMax, Long cellarId) {
        this.cellarPlaceId = cellarPlaceId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.positionOpt = positionOpt;
        this.quantityBottleMax = quantityBottleMax;
        this.cellarId = cellarId;
    }
}
