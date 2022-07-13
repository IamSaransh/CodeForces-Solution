package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        int index= 0;
        //helper function call to fill ans with all subsets
        helper(nums, index, ans,currAns );
        //return the result
        return ans;
    }

    static  void helper(int[] nums,  int index,
                              List<List<Integer>> ans, List<Integer> currAns){
        //@Base case
        if(index >= nums.length)
        {
            ans.add(currAns);
            return;
        }
        System.out.println(currAns);
        //else make include and non include call for that element at that index;
        //non inc
        helper(nums, index+1, ans, currAns);
        //inc call
        currAns.add(nums[index]); //add element and make recursive call
        helper(nums, index+1, ans, currAns );
        //backtrack
        int lastIndex = currAns.size() - 1;
        currAns.remove(lastIndex);
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = {1,2,3};
//        List<List<Integer>> ans = solution.subsets(nums);
//        System.out.println(ans);
//        ;




    }
}