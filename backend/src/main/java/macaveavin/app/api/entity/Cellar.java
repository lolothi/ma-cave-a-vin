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
    private Integer quantityLocationX;

    @Column(name = "quantity_location_y")
    private Integer quantityLocationY;

    @Column(name = "quantity_location_z")
    private Integer quantityLocationZ;

    @Column(name = "quantity_bottle_max")
    private Integer quantityBottleMax;

    public Cellar(String name, Integer quantityLocationX, Integer quantityLocationY, Integer quantityLocationZ, Integer quantityBottleMax) {
        this.name = name;
        this.quantityLocationX = quantityLocationX;
        this.quantityLocationY = quantityLocationY;
        this.quantityLocationZ = quantityLocationZ;
        this.quantityBottleMax = quantityBottleMax;
    }

    public Cellar() {
    }
}
