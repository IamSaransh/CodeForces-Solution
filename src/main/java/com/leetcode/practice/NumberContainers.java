package com.leetcode.practice;

import java.util.*;
public class NumberContainers {

    Map<Integer, PriorityQueue<Integer>> map;

    int[] arr;

    public NumberContainers() {
        map = new HashMap<>();
        arr = new int[100000];
    }

    public void change(int index, int number) {
        //@ADD
        if(arr[index] ==0) //pahele se hai and update kr rhe hai to map se byhi hatao
        {
            if(map.containsKey(number)) {
                map.get(number).add(index);
            }
            else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(index);
                map.put(number,pq );
            }

        }
        //@UPDATE
        else {
            if(map.containsKey(number)) {
                int currNum = arr[index]; // ye oahele se the yaha
                //for thisncurr num remove its entry from the mao
                map.get(currNum).remove(index);

                if (map.get(currNum).isEmpty()) //empty ho gyi remove jkrne ke bad
                    map.remove(currNum);
                //new value add kro
                map.get(number).add(index);
            }
            else{
                int currNum = arr[index]; // ye oahele se the yaha
                //for thisncurr num remove its entry from the mao
                map.get(currNum).remove(index);
                System.out.println(currNum);
                if (map.get(currNum).isEmpty()) //empty ho gyi remove jkrne ke bad
                    map.remove(currNum);
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(index);
                map.put(number,pq );
            }
        }
    }

    public int find(int number) {
        System.out.println(map);
        if(map.containsKey(number)){
            return map.get(number).peek();
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        NumberContainers s = new NumberContainers();
        //[[],[10],[2,10],[1,10],[3,10],[5,10],[10],[1,20],[10]]
        s.find(10);
        s.change(2,10);
        s.change(1,10);
        s.change(3,10);
        s.change(5,10);
        s.find(10);
        s.change(1,20);
        s.find(10);
    }


}