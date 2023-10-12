package macaveavin.app.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "myWine")
public class MyWine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myWine_id;

    @Column(name= "position")
    private String position; //update later for real position

    @Column(name= "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name= "wine_id")
    private Wine wine;

    public MyWine(String position, Integer quantity, Wine wine) {
        this.position = position;
        this.quantity = quantity;
        this.wine = wine;
    }

    public Long getMyWine_id() {
        return myWine_id;
    }

    public void setMyWine_id(Long myWine_id) {
        this.myWine_id = myWine_id;
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
}
