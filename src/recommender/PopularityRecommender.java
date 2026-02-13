package recommender;

import java.util.*;

public class PopularityRecommender {

    public static List<Integer> getPopularProducts(
            Map<Integer, Map<Integer, Integer>> matrix) {

        Map<Integer, Integer> popularity = new HashMap<>();

        for (Map<Integer, Integer> userRatings : matrix.values()) {
            for (int productId : userRatings.keySet()) {
                popularity.put(productId,
                        popularity.getOrDefault(productId, 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> sorted =
                new ArrayList<>(popularity.entrySet());

        sorted.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> topProducts = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            topProducts.add(sorted.get(i).getKey());
        }

        return topProducts;
    }
}
