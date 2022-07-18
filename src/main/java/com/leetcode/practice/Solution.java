package com.leetcode.practice;


import com.codeforces.contest786.B;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int numQueries = queries.length;
        int[] ans = new int [numQueries];
        int N = nums[0].length();
        int index = 0;
        for(int[] q : queries)
        {

            int trimLen = q[1];
            int posSmall = q[0];
            List<Pair<BigInteger, Integer>> temp = new ArrayList<>();
           for(int i=0;i< nums.length; i++)
            {
                String num = nums[i];
                temp.add(new Pair<>(new BigInteger(num.substring(N-trimLen)), i));
           }
            System.out.println(temp);
            //traverse pair to get the ith smallest number
            int currAns = -1;
            temp.sort((x,y) -> x.getKey().compareTo(y.getKey()));
            temp.sort((x,y) -> {
                if(x.getKey() == y.getKey() )
                    return x.getValue() - y.getValue();
                return 0;
            });
            ans[index++] = temp.get(posSmall-1).getValue();

        }
        System.out.println(ans);
return ans;
    }

    public static void main(String[] args) {
       String []  nums = {"102","473","251","814"};
       Solution s = new Solution();
    }
}