package recommender;

import java.util.*;
import models.Product;

public class ContentBasedRecommender {

    public static List<Integer> recommendByCategory(
            int userId,
            Map<Integer, Map<Integer, Integer>> matrix,
            List<Product> products) {

        Set<String> likedCategories = new HashSet<>();
        Map<Integer, Integer> userRatings = matrix.get(userId);

        // find categories user already interacted with
        for (int productId : userRatings.keySet()) {
            for (Product p : products) {
                if (p.productId == productId) {
                    likedCategories.add(p.category);
                }
            }
        }

        // recommend products from same categories
        List<Integer> recommendations = new ArrayList<>();

        for (Product p : products) {
            if (likedCategories.contains(p.category)
                    && !userRatings.containsKey(p.productId)) {
                recommendations.add(p.productId);
            }
        }

        return recommendations;
    }
}
