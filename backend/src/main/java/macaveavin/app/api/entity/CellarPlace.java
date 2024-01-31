package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cellarPlace")
@Data
public class CellarPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellar_place_id;

    @Column(name = "position_x")
    private Integer position_x;

    @Column(name = "position_y")
    private Integer position_y;

    @Column(name = "position_z")
    private Integer position_z;

    @Column(name = "position_opt")
    private String position_opt; //update later for real position

    @Column(name = "quantity_bottle_max")
    private Integer quantity_bottle_max;

    @Column(name = "quantity_bottle_left")
    private Integer quantity_bottle_left;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    @ManyToOne
    @JoinColumn(name = "cellar_id")
    private Cellar cellar;

    public CellarPlace(Integer position_x, Integer position_y, Integer position_z, String position_opt, Integer quantity_bottle_max, Integer quantity_bottle_left, Wine wine, Cellar cellar) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.position_z = position_z;
        this.position_opt = position_opt;
        this.quantity_bottle_max = quantity_bottle_max;
        this.quantity_bottle_left = quantity_bottle_left;
        this.wine = wine;
        this.cellar = cellar;
    }

    public CellarPlace() {
    }
}
