package com.leetcode.practice;

import java.util.*;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        String curr = "";
        //leading value can't be zero
        for(int i=1;i<10;i++){
            curr+=i;
            helper(res, curr, n, k);
            curr=curr.substring(0, curr.length()-1);
        }
        int[] array = new int[res.size()];
        System.out.println(res);
        // res.toArray(array); // fill the array
        return array;

    }
    void helper(List<Integer> res, String curr,int n, int k){
        if(curr.length()==n) {
            res.add(Integer.valueOf(curr));
            return;
        }
        for(int i=0;i<10;i++)
        {
            int diff = curr.charAt(curr.length()-1)-'0' - i;

            System.out.println(diff + " " + curr + " " + i);
            if(Math.abs(diff)==k)
            {
                curr+=i;
                helper(res, curr, n, k);
                curr=curr.substring(0, curr.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numsSameConsecDiff(3,7);
    }
}