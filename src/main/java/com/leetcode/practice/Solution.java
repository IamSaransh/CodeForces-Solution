package com.leetcode.practice;

import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        final int LENGTH = pattern.length();
        List<String> ans = new ArrayList<>(); //ans initlization
        Map<Character, Integer> patternMap = new HashMap<>();
        for(int i=0;i<LENGTH;i++)
        {
            patternMap.merge(pattern.charAt(i), i, Integer::sum);
        }

        for(String word: words)
        {
            Map<Character, Integer> wordMap = new HashMap<>();
            for(int i=0; i<LENGTH;i++)
            {
                wordMap.merge(word.charAt(i), i, Integer::sum);
            }
            if(isGood(patternMap, wordMap, word, pattern, LENGTH))
                ans.add(word);
        }
        return ans;
    }

    private boolean isGood(Map<Character, Integer> patternMap, Map<Character, Integer> wordMap, String word, String pattern, int length) {
        if(patternMap.size()!=wordMap.size())
            return false;
        for(int i=0;i<length;i++)
        {
            if( (int)patternMap.get(pattern.charAt(i))!= (int) wordMap.get(word.charAt(i)))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String [] words = {"abc","deq","mee","aqq","dkd","ccc" };
        String pattern = "abb";

//        String [] words = { "ktittgzawn","dgphvfjniv","gceqobzmis",
//                "alrztxdlah","jijuevoioe","mawiizpkub","onwpmnujos",
//                "zszkptjgzj","zwfvzhrucv","isyaphcszn" };
//        String pattern = "zdqmjnczma";
        Solution s = new Solution();
        System.out.println(s.findAndReplacePattern(words, pattern));
    }
}