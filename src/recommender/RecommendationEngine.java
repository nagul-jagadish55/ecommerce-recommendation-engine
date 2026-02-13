package recommender;

import java.util.*;

public class RecommendationEngine {

    public static List<Integer> recommendProducts(
            int targetUser,
            Map<Integer, Map<Integer, Integer>> matrix) {

        Map<Integer, Double> scores = new HashMap<>();

        Map<Integer, Integer> targetRatings = matrix.get(targetUser);

        for (int otherUser : matrix.keySet()) {

            if (otherUser == targetUser) continue;

            double similarity = SimilarityCalculator.cosineSimilarity(
                    targetRatings, matrix.get(otherUser));

            for (int product : matrix.get(otherUser).keySet()) {

                // skip products already rated by target user
                if (targetRatings.containsKey(product)) continue;

                scores.put(product,
                        scores.getOrDefault(product, 0.0)
                                + similarity * matrix.get(otherUser).get(product));
            }
        }

        // sort products by score
        List<Map.Entry<Integer, Double>> sorted =
                new ArrayList<>(scores.entrySet());

        sorted.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // return top 3 products
        List<Integer> recommendations = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            recommendations.add(sorted.get(i).getKey());
        }

        return recommendations;
    }
}
