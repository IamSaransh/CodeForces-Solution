package com.leetcode.practice.biweekly81;
/*
6104. Count Asterisks
Difficulty:Easy
You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair. In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|' make a pair, and so forth.

Return the number of '*' in s, excluding the '*' between each pair of '|'.

Note that each '|' will belong to exactly one pair.


 */
class Problem1 {
    public int countAsterisks(String s) {
//        int i=0;
        int ans = 0;
        int pipe = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(pipe%2==0 && s.charAt(i)=='*')
                ans++;
            if(s.charAt(i)=='|')
                pipe++;
        }
        return ans;

    }


    public static void main(String[] args) {
        Problem1 p = new Problem1();
        System.out.println(p.countAsterisks(""));
    }
}
