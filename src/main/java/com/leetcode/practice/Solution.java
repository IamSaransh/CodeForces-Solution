package com.leetcode.practice;

import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Map<String, Integer> mapRow = new HashMap<>();
        Map<String, Integer> mapCol = new HashMap<>();

        //adding  rows to the map
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int rowVal : row) {
                sb.append(rowVal);
            }
            mapRow.merge(sb.toString(), 1, Integer::sum);
        }
        //ading cols to the map
        for (int i = 0; i < rows; i++)
        {
            StringBuilder sb = new StringBuilder();
            for ( int j = 0; j < cols; j++)
            {
                 sb.append(grid[j][i]);
            }
            mapCol.merge(sb.toString(), 1, Integer::sum);
        }
        int ans = 0;
        for(String rowMApString: mapRow.keySet()){
            if(mapCol.containsKey(rowMApString)){
                ans+= (mapRow.get(rowMApString)) * (mapCol.get(rowMApString));
            }
        }
return  ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1,2,3 };
    }
}