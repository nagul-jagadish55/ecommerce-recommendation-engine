import database.DataLoader;
import java.sql.Connection;
import java.util.*;
import models.*;
import recommender.HybridRecommender;
import recommender.MatrixBuilder;
import recommender.SimilarityCalculator;

public class Main {
    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();

        List<Product> products = DataLoader.loadProducts(conn);
        List<Interaction> interactions = DataLoader.loadInteractions(conn);

        Map<Integer, Map<Integer, Integer>> matrix =
                MatrixBuilder.buildUserItemMatrix(interactions);

        System.out.println("User-Item Matrix:");
        System.out.println(matrix);
        System.out.println("\nUser Similarities:");
        for (int userA : matrix.keySet()) {
            for (int userB : matrix.keySet()) {

               if (userA != userB) {

                  double sim = SimilarityCalculator.cosineSimilarity(
                        matrix.get(userA),
                        matrix.get(userB)
                  );

                  System.out.println("User " + userA + " vs User " + userB + " = " + sim);
                }
            }
        }
        System.out.println("\nFinal Hybrid Recommendations for User 1:");

        List<Integer> finalRecs = HybridRecommender.getHybridRecommendations(1, matrix, products);

        for (int productId : finalRecs) {
            for (Product p : products) { 
                if (p.productId == productId) {
                    System.out.println("Recommended: " + p.name);
                }
            }
        }
    }
}
