package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cellar")
@Data
public class Cellar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellar_id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_location_x")
    private Integer quantity_location_x;

    @Column(name = "quantity_location_y")
    private Integer quantity_location_y;

    @Column(name = "quantity_location_z")
    private Integer quantity_location_z;

    @Column(name = "quantity_bottle_max")
    private Integer quantity_bottle_max;

    public Cellar(String name, Integer quantity_location_x, Integer quantity_location_y, Integer quantity_location_z, Integer quantity_bottle_max) {
        this.name = name;
        this.quantity_location_x = quantity_location_x;
        this.quantity_location_y = quantity_location_y;
        this.quantity_location_z = quantity_location_z;
        this.quantity_bottle_max = quantity_bottle_max;
    }

    public Cellar() {
    }
}
