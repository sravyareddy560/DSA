package leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/design-a-food-rating-system/description/

//Time Complexity: Initialization: O(n log n), changeRating: O(log n), highestRated: O(1) (amortized, practically)
//Space: O(n)
class FoodRatings {
    // Maps each food -> its current rating
    private final Map<String, Integer> foodRatingsMap = new HashMap<>();
    // Maps each food -> its cuisine
    private final Map<String, String> foodCuisineMap = new HashMap<>();
    // Maps each cuisine -> (rating -> set of foods with that rating)
    private final Map<String, TreeMap<Integer, TreeSet<String>>> cuisineRatingMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodRatingsMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            // Add food into its cuisine's rating map
            cuisineRatingMap
                    .computeIfAbsent(cuisines[i], k -> new TreeMap<>())
                    .computeIfAbsent(ratings[i], k -> new TreeSet<>())
                    .add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        int oldRating = foodRatingsMap.get(food);

        foodRatingsMap.put(food, newRating);

        // Remove from old rating group
        TreeMap<Integer, TreeSet<String>> ratingMap = cuisineRatingMap.get(cuisine);
        TreeSet<String> oldSet = ratingMap.get(oldRating);
        oldSet.remove(food);
        if (oldSet.isEmpty()) {
            ratingMap.remove(oldRating);
        }

        // Add to new rating group
        ratingMap.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> ratingMap = cuisineRatingMap.get(cuisine);
        // lastKey() -> highest rating, first() -> lexicographically smallest food
        return ratingMap.get(ratingMap.lastKey()).first();
    }


    public static void main(String[] args) {
        FoodRatings fr=new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});

        System.out.println("Expected output= kimchi, Actual output= "+fr.highestRated("korean"));
        System.out.println("Expected output= ramen, Actual output= "+fr.highestRated("japanese"));
        fr.changeRating("sushi", 16);
        System.out.println("Expected output= sushi, Actual output= "+fr.highestRated("japanese"));
        fr.changeRating("ramen", 16);
        System.out.println("Expected output= ramen, Actual output= "+fr.highestRated("japanese"));
    }

}
