package recommender;

import java.util.*;
import models.Product;

public class HybridRecommender {

    public static List<Integer> getHybridRecommendations(
            int userId,
            Map<Integer, Map<Integer, Integer>> matrix,
            List<Product> products) {

            //// If user not present in interaction matrix → completely new user
            if (!matrix.containsKey(userId)) {
                System.out.println("Using Popularity-Based Recommendations");
                return PopularityRecommender.getPopularProducts(matrix);
            }

            // If user has only one interaction → low activity user
            if (matrix.get(userId).size() <= 1) {
                System.out.println("Using Content-Based Recommendations");
                return ContentBasedRecommender.recommendByCategory(userId, matrix, products);
            }

            // otherwise → collaborative filtering
            System.out.println("Using Collaborative Filtering");
            return RecommendationEngine.recommendProducts(userId, matrix);
    }
}
