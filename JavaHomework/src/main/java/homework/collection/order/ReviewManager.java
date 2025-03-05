package homework.collection.order;

import homework.collection.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager {
    private Map<User, List<Review>> reviewsManager;


    public ReviewManager() {
        reviewsManager = new HashMap<User, List<Review>>();
    }

    public void addReview(User user, Review review) {
        reviewsManager.computeIfAbsent(user, k -> new ArrayList<>()).add(review);
    }

    public List<Review> getReviewByUser(User user) {
        return reviewsManager.getOrDefault(user, new ArrayList<>());
    }
    public  void printAllReview() {
        for (Map.Entry<User, List<Review>> entry : reviewsManager.entrySet()) {
            System.out.println(entry.getKey());
            for (Review review : entry.getValue()) {
                System.out.println(" - " + review);
            }
        }
    }
}
