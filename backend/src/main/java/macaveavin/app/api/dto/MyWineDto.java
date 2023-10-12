package macaveavin.app.api.dto;

public class MyWineDto {

    private Long myWine_id;
    private String position; //update later for real position
    private Integer quantity;
    private Long wine;

    public MyWineDto(Long myWine_id, String position, Integer quantity, Long wine) {
        this.myWine_id = myWine_id;
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

    public Long getWine() {
        return wine;
    }

    public void setWine(Long wine) {
        this.wine = wine;
    }
}
