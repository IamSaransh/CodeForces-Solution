package com;

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int prefixSum =0;
        long arraySum = 0;
        for(int num: nums) arraySum+=num; // getting sum of array
        int need = (int)arraySum - x;


        int maxLen = -1; // if -1 then we return -1 as ans as no such subarray
        for(int i=0; i< nums.length;i++){
            prefixSum+= nums[i];
            if(map.containsKey(prefixSum - need)){
                maxLen = Math.max(maxLen, i - map.get(need) +1);
            }
            map.put(prefixSum, i);
        }

        return maxLen==-1? -1 : nums.length - maxLen;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

    }
}