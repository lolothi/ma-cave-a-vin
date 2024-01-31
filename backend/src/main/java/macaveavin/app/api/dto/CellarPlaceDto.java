package macaveavin.app.api.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import macaveavin.app.api.entity.Cellar;
import macaveavin.app.api.entity.Wine;

@Getter
public class CellarPlaceDto {

    private Long cellar_place_id;
    private Integer position_x;
    private Integer position_y;
    private Integer position_z;
    private String position_opt;
    private Integer quantity_bottle_max;
    private Integer quantity_bottle_left;
    private Wine wine;
    private Cellar cellar;


    public void setCellar_place_id(Long cellar_place_id) {
        this.cellar_place_id = cellar_place_id;
    }

    public void setPosition_x(Integer position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(Integer position_y) {
        this.position_y = position_y;
    }

    public void setPosition_z(Integer position_z) {
        this.position_z = position_z;
    }

    public void setPosition_opt(String position_opt) {
        this.position_opt = position_opt;
    }

    public void setPosition_bottle_max(Integer quantity_bottle_max) {
        this.quantity_bottle_max = quantity_bottle_max;
    }

    public void setPosition_bottle_left(Integer quantity_bottle_left) {
        this.quantity_bottle_left = quantity_bottle_left;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public void setCellar(Cellar cellar) {
        this.cellar = cellar;
    }

    public CellarPlaceDto(Long cellar_place_id, Integer position_x, Integer position_y, Integer position_z, String position_opt, Integer quantity_bottle_max, Integer quantity_bottle_left, Wine wine, Cellar cellar) {
        this.cellar_place_id = cellar_place_id;
        this.position_x = position_x;
        this.position_y = position_y;
        this.position_z = position_z;
        this.position_opt = position_opt;
        this.quantity_bottle_max = quantity_bottle_max;
        this.quantity_bottle_left = quantity_bottle_left;
        this.wine = wine;
        this.cellar = cellar;
    }

}
