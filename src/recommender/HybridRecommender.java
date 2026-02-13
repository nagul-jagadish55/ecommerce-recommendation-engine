package recommender;

import java.util.*;
import models.Product;

public class HybridRecommender {

    public static List<Integer> getHybridRecommendations(
            int userId,
            Map<Integer, Map<Integer, Integer>> matrix,
            List<Product> products) {

        // if new user → popular products
        if (!matrix.containsKey(userId) || matrix.get(userId).size() == 0) {
            System.out.println("Using Popularity-Based Recommendations");
            return PopularityRecommender.getPopularProducts(matrix);
        }

        // if user has very few interactions → content-based
        if (matrix.get(userId).size() < 2) {
            System.out.println("Using Content-Based Recommendations");
            return ContentBasedRecommender.recommendByCategory(userId, matrix, products);
        }

        // otherwise → collaborative filtering
        System.out.println("Using Collaborative Filtering");
        return RecommendationEngine.recommendProducts(userId, matrix);
    }
}
