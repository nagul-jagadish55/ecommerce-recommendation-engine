package recommender;

import java.util.*;
import models.Interaction;

public class MatrixBuilder {

    public static Map<Integer, Map<Integer, Integer>> buildUserItemMatrix(List<Interaction> interactions) {

        Map<Integer, Map<Integer, Integer>> matrix = new HashMap<>();

        for (Interaction i : interactions) {

            matrix.putIfAbsent(i.userId, new HashMap<>());
            matrix.get(i.userId).put(i.productId, i.rating);
        }

        return matrix;
    }
}
