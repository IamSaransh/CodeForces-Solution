package com.leetcode.practice;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class FoodRatings {
    Map<String, TreeMap<String, Integer>> map;
    Map<String, String> foodCuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap< String, TreeMap<String, Integer>>();
        foodCuisineMap = new HashMap<>();
        for(String cuisine: cuisines){
            if(!map.containsKey(cuisine))
            {
//                TreeMap<String, Integer> mapCusine = new TreeMap<>(Collections.reverseOrder());
                TreeMap<String, Integer> mapCusine = new TreeMap<>();

                map.put(cuisine, mapCusine);
            }

        }
        //
        int n = foods.length;
        for(int i=0;i<n;i++)
        {
            map.get(cuisines[i]).put(foods[i],ratings[i] );
            //aslso add value to foodCusineMap
            foodCuisineMap.put(foods[i],cuisines[i] );

        }
        System.out.println("INITIAL");
        System.out.println(map);
        System.out.println(foodCuisineMap);
    }

    public void changeRating(String food, int newRating) {
        String currCusine = foodCuisineMap.get(food);
        map.get(currCusine).put(food, newRating);   ///food is unique value so will overwrite bgy default
        System.out.println("CHANGED");
        System.out.println(map);

    }

    public String highestRated(String cuisine) {
        int maxRating = -1;
        String ans = "";
        Map<String, Integer> temp = map.get(cuisine);
        for(Map.Entry<String, Integer> entry: temp.entrySet()){
            if(entry.getValue()>maxRating){
                ans = entry.getKey();
            }
        }
        return ans;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */