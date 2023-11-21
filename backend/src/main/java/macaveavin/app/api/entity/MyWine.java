package macaveavin.app.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "myWine")
@Data
public class MyWine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long my_wine_id;

    @Column(name= "position")
    private String position; //update later for real position

    @Column(name= "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name= "wine_id")
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

    public MyWine(String position, Integer quantity, Wine wine) {
        this.position = position;
        this.quantity = quantity;
        this.wine = wine;
    }

    public MyWine() {
    }
}
