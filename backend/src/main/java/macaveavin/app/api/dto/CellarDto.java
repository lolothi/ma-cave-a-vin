package macaveavin.app.api.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;

@Getter
public class CellarDto {

    private Long cellar_id;
    private String name;
    private Integer quantity_location_x;
    private Integer quantity_location_y;
    private Integer quantity_location_z;
    private Integer quantity_bottle_max;

    public void setCellar_id(Long cellar_id) {
        this.cellar_id = cellar_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity_location_x(Integer quantity_location_x) {
        this.quantity_location_x = quantity_location_x;
    }

    public void setQuantity_location_y(Integer quantity_location_y) {
        this.quantity_location_y = quantity_location_y;
    }

    public void setQuantity_location_z(Integer quantity_location_z) {
        this.quantity_location_z = quantity_location_z;
    }

    public void setQuantity_bottle_max(Integer quantity_bottle_max) {
        this.quantity_bottle_max = quantity_bottle_max;
    }

    public CellarDto(Long cellar_id, String name, Integer quantity_location_x, Integer quantity_location_y, Integer quantity_location_z, Integer quantity_bottle_max) {
        this.cellar_id = cellar_id;
        this.name = name;
        this.quantity_location_x = quantity_location_x;
        this.quantity_location_y = quantity_location_y;
        this.quantity_location_z = quantity_location_z;
        this.quantity_bottle_max = quantity_bottle_max;
    }

    public CellarDto() {
    }
}
