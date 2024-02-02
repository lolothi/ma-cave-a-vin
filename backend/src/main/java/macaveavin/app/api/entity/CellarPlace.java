package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cellarPlace")
@Data
public class CellarPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellarPlaceId;

    @Column(name = "position_x")
    private Integer positionX;

    @Column(name = "position_y")
    private Integer positionY;

    @Column(name = "position_z")
    private Integer positionZ;

    @Column(name = "position_opt")
    private String positionOpt; //update later for real position

    @Column(name = "quantity_bottle_max")
    private Integer quantityBottleMax;

    @Column(name = "quantity_bottle_left")
    private Integer quantityBottleLeft;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    @ManyToOne
    @JoinColumn(name = "cellar_id")
    private Cellar cellar;

    public CellarPlace(Integer positionX, Integer positionY, Integer positionZ, String positionOpt, Integer quantityBottleMax, Integer quantityBottleLeft, Wine wine, Cellar cellar) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.positionOpt = positionOpt;
        this.quantityBottleMax = quantityBottleMax;
        this.quantityBottleLeft = quantityBottleLeft;
        this.wine = wine;
        this.cellar = cellar;
    }

    public CellarPlace() {
    }
}
