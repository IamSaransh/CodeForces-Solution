package com.leetcode.practice;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;


class Solution {
    public static final int MAX_VALUE = 2147483647;
    public void heeh(Integer... k){
        Arrays.stream(k).sequential().min().get();
    }
    public int minCost(int[] nums, int k) {
        heeh(2,3,3,3,3,3);
        int SIZE = nums.length;
        Function<Integer, String> func= x-> String.valueOf((x*10));
        func.andThen(x->x+"jskdks");

        HashMap<Integer, Integer> frequesncy = new HashMap<>();
        for (Integer num : nums) {
            frequesncy.put(i, frequesncy.getOrDefault(i, 0) + 1);
        }


        int[] dp = new int[SIZE];
        for (int len = 1; len <= SIZE; len++) {
            int BABAYAGA = k;

            for (Map.Entry<Integer, Integer> entry : frequesncy.entrySet()) {
                if (entry.getValue() > 1) {
                    BABAYAGA += entry.getValue();
                }
            }
            for (int i = 0; i + len <= SIZE; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i] = 0;


                } else {
                    dp[i] = MAX_VALUE
                    for (int D = i; D < j; D++) {
                        dp[i] = Math.min(dp[i], dp[i] + dp[D + 1] + BABAYAGA);
                    }
                }
            }
        }
        return dp[0];
    }

}