import database.DataLoader;
import java.sql.Connection;
import java.util.*;
import models.*;
import recommender.*;

public class EcommerceApp {

    private List<Product> products;
    private Map<Integer, Map<Integer, Integer>> matrix;

    public EcommerceApp(Connection conn) {
        products = DataLoader.loadProducts(conn);
        List<Interaction> interactions = DataLoader.loadInteractions(conn);
        matrix = MatrixBuilder.buildUserItemMatrix(interactions);
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MiniBay =====");
            System.out.println("1. View All Products");
            System.out.println("2. Get Recommendations");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if (choice == 1) showProducts();
            else if (choice == 2) recommend(sc);
            else break;
        }
    }

    private void showProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p.productId + ". " + p.name + " - ₹" + p.price);
        }
    }

    private void recommend(Scanner sc) {
        System.out.print("\nEnter User ID: ");
        int userId = sc.nextInt();

        List<Integer> recs =
                HybridRecommender.getHybridRecommendations(userId, matrix, products);

        System.out.println("\nRecommended Products:");
        for (int productId : recs) {
            for (Product p : products) {
                if (p.productId == productId) {
                    System.out.println("👉 " + p.name);
                }
            }
        }
    }
}
