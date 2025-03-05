package homework.oop.order;

import homework.oop.product.Product;
import homework.oop.user.User;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
public class Review {

    @Setter
    private User user;
    @Setter
    private Product product;
    private int rating;

    @Setter
    private String comment;
    @Setter
    private LocalDateTime createAt;

    public Review(User user, Product product, int rating, String comment) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.createAt = LocalDateTime.now();
    }


    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public void showReview() {
        if (this.comment == null) {
            throw new IllegalArgumentException("No has comment");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = createAt.format(formatter);

        System.out.println("User name: " + user.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Rating: " + this.rating);
        System.out.println("Comment: " + comment);
        System.out.println("Create at: " + formattedDate);
    }


}
