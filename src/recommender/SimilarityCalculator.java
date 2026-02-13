package recommender;

import java.util.*;

public class SimilarityCalculator {

    public static double cosineSimilarity(
            Map<Integer, Integer> userA,
            Map<Integer, Integer> userB) {

        Set<Integer> allProducts = new HashSet<>();
        allProducts.addAll(userA.keySet());
        allProducts.addAll(userB.keySet());

        double dotProduct = 0;
        double magnitudeA = 0;
        double magnitudeB = 0;

        for (int product : allProducts) {

            int ratingA = userA.getOrDefault(product, 0);
            int ratingB = userB.getOrDefault(product, 0);

            dotProduct += ratingA * ratingB;
            magnitudeA += ratingA * ratingA;
            magnitudeB += ratingB * ratingB;
        }

        if (magnitudeA == 0 || magnitudeB == 0)
            return 0;

        return dotProduct / (Math.sqrt(magnitudeA) * Math.sqrt(magnitudeB));
    }
}

