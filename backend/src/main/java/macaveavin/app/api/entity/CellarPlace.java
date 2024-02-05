package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "cellarPlace")
@Data
public class CellarPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellar_place_id;

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

    @ManyToOne
    @JoinColumn(name = "cellar_id")
    private Cellar cellar;

    @ManyToMany
    @JoinTable(
            name = "cellar_place_wine",
            joinColumns = @JoinColumn(name = "cellar_place_id"),
            inverseJoinColumns = @JoinColumn(name = "wine_id")
    )
    private Set<Wine> wines;

    public CellarPlace(Integer positionX, Integer positionY, Integer positionZ, String positionOpt, Integer quantityBottleMax, Cellar cellar, Set<Wine> wines) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.positionOpt = positionOpt;
        this.quantityBottleMax = quantityBottleMax;
        this.cellar = cellar;
        this.wines = wines;
    }

    public CellarPlace() {
    }

}
