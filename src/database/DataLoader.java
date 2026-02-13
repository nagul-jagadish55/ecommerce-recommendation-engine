package database;

import java.sql.*;
import java.util.*;
import models.Product;
import models.Interaction;

public class DataLoader {

    public static List<Product> loadProducts(Connection conn) {
        List<Product> products = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("brand")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public static List<Interaction> loadInteractions(Connection conn) {
        List<Interaction> interactions = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_interactions");

            while (rs.next()) {
                interactions.add(new Interaction(
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("rating")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return interactions;
    }
}
