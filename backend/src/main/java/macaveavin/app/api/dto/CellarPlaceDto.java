package macaveavin.app.api.dto;

import lombok.Getter;
import macaveavin.app.api.entity.Wine;

@Getter
public class CellarPlaceDto {

    private Long cellar_place_id;
    private String position; //update later for real position
    private String position_opt; //update later for real position
    private Integer quantity;
    private Wine wine;

    public void setMy_wine_id(Long cellar_place_id) {
        this.cellar_place_id = cellar_place_id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPosition_opt(String position_opt) {
        this.position_opt = position_opt;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public CellarPlaceDto(Long cellar_place_id, String position, String position_opt, Integer quantity, Wine wine) {
        this.cellar_place_id = cellar_place_id;
        this.position = position;
        this.position_opt = position_opt;
        this.quantity = quantity;
        this.wine = wine;
    }
}
