package macaveavin.app.api.dto;

import lombok.Getter;

@Getter
public class CellarDto {

    private Long cellarId;
    private String name;
    private Integer quantityLocationX;
    private Integer quantityLocationY;
    private Integer quantityLocationZ;
    private Integer quantityBottleMax;

    public void setCellarId(Long cellarId) {
        this.cellarId = cellarId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityLocationX(Integer quantityLocationX) {
        this.quantityLocationX = quantityLocationX;
    }

    public void setQuantityLocationY(Integer quantityLocationY) {
        this.quantityLocationY = quantityLocationY;
    }

    public void setQuantityLocationZ(Integer quantityLocationZ) {
        this.quantityLocationZ = quantityLocationZ;
    }

    public void setQuantityBottleMax(Integer quantityBottleMax) {
        this.quantityBottleMax = quantityBottleMax;
    }

    public CellarDto(Long cellarId, String name, Integer quantityLocationX, Integer quantityLocationY, Integer quantityLocationZ, Integer quantityBottleMax) {
        this.cellarId = cellarId;
        this.name = name;
        this.quantityLocationX = quantityLocationX;
        this.quantityLocationY = quantityLocationY;
        this.quantityLocationZ = quantityLocationZ;
        this.quantityBottleMax = quantityBottleMax;
    }

    public CellarDto() {
    }
}
