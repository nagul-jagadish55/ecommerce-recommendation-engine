package models;

public class Interaction {
    public int userId;
    public int productId;
    public int rating;

    public Interaction(int userId, int productId, int rating) {
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
    }
}
