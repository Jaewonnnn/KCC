package kosa.model;

public class Basket {
    private int id;
    private String userId;
    private String product;

    public Basket() {}

    public Basket(int id, String userId, String product) {
        this.id = id;
        this.userId = userId;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Basket [id=" + id + ", userId=" + userId + ", product=" + product + "]";
    }
}
