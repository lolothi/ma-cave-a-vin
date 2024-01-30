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

    @Column(name = "position")
    private String position; //update later for real position

    @Column(name = "position_opt")
    private String position_opt; //update later for real position

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    public Long getCellar_place_id() {
        return cellar_place_id;
    }

    public void setCellar_place_id(Long cellar_place_id) {
        this.cellar_place_id = cellar_place_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition_opt() {
        return position_opt;
    }

    public void setPosition_opt(String position_opt) {
        this.position_opt = position_opt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public CellarPlace(String position, String position_opt, Integer quantity, Wine wine) {
        this.position = position;
        this.position_opt = position_opt;
        this.quantity = quantity;
        this.wine = wine;
    }

    public CellarPlace() {
    }
}
