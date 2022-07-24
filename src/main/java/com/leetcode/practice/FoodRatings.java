 package com.leetcode.practice;


import java.util.*;

class FoodRatings {
    Map<String, PriorityQueue<Food>> map;
    Map<String, String> menu;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        menu = new HashMap<>();
        for(int i=0; i<foods.length; i++){
            if(!map.containsKey(cuisines[i]))
            {
                PriorityQueue<Food> queue = new PriorityQueue<Food>(new Comparator<Food>() {
                    public int compare(Food n1, Food n2) {
                        if(n1.foodRating == n2.foodRating)
//                            return String.CASE_INSENSITIVE_ORDER.compare(n1.foodName, n2.foodName);
                            return  n1.foodName.compareTo(n2.foodName);
                        else

                            return Integer.compare(n2.foodRating, n1.foodRating);
                    } });
                map.put(cuisines[i], queue);
            }
            Food curr = new Food(foods[i], ratings[i]);
            map.get(cuisines[i]).add(curr);
            menu.put(foods[i], cuisines[i]);

        }

    }

    public void changeRating(String food, int newRating) {
        String currCuisine = menu.get(food);
        Food currFood = new Food(food, 12);
        map.get(currCuisine).remove(currFood);
        currFood.foodRating = newRating;
        map.get(currCuisine).add(currFood);

    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().foodName;
    }


    static class Food {
        private String foodName;
        private int foodRating;

        public Food(String foodName, int foodRating) {
            this.foodName = foodName;
            this.foodRating = foodRating;
        }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Food food = (Food) o;
             return foodName.equals(food.foodName);
         }

         @Override
         public int hashCode() {
             return Objects.hash(foodName);
         }
    }

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */