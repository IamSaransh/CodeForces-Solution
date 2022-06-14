package com;

import java.util.*;

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int prev = 0;
        int upperbound;
        for(int []temp: brackets){
            if(temp[0] <= income){
                upperbound = temp[0];
                tax +=  ( (double)(upperbound - prev) * (double)temp[1] )/100;
            }
            else{
                upperbound = temp[0];
                tax +=  ( (double)(Math.min(upperbound, income) - prev) * (double)temp[1] )/100;
            }
        }
        System.out.println();
        return  tax;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] [] brackets = {{3,50},{7,10},{12,25}};
        s.calculateTax(brackets, 10);

    }
}