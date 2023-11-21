package macaveavin.app.api.dto;

public class MyWineDto {

    private Long my_wine_id;
    private String position; //update later for real position
    private Integer quantity;
    private Long wine;

    public MyWineDto(Long my_wine_id, String position, Integer quantity, Long wine) {
        this.my_wine_id = my_wine_id;
        this.position = position;
        this.quantity = quantity;
        this.wine = wine;
    }

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

    public Long getWine() {
        return wine;
    }

    public void setWine(Long wine) {
        this.wine = wine;
    }
}
