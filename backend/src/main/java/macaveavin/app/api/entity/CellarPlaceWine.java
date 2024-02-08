package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CellarPlaceWine")
@Data
public class CellarPlaceWine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellar_place_wine_id;

    @ManyToOne
    @JoinColumn(name = "cellar_place_id")
    private CellarPlace cellarPlace;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    @Column(name = "quantity_bottle")
    private Integer quantityBottle;

    public CellarPlaceWine(CellarPlace cellarPlace, Wine wine, Integer quantityBottle) {
        this.cellarPlace = cellarPlace;
        this.wine = wine;
        this.quantityBottle = quantityBottle;
    }

    public CellarPlaceWine() {

    }
}
