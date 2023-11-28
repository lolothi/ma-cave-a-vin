package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "myWine")
@Data
public class MyWine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long my_wine_id;

    @Column(name = "position")
    private String position; //update later for real position

    @Column(name = "position_opt")
    private String position_opt; //update later for real position

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine wine;

    public Long getMy_wine_id() {
        return my_wine_id;
    }

    public void setMy_wine_id(Long my_wine_id) {
        this.my_wine_id = my_wine_id;
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

    public MyWine(String position, String position_opt, Integer quantity, Wine wine) {
        this.position = position;
        this.position_opt = position_opt;
        this.quantity = quantity;
        this.wine = wine;
    }

    public MyWine() {
    }
}
