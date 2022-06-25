package com.leetcode.practice.biweekly81;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Problem2 { //tle
    public long countPairs(int n, int[][] edges) {
        int[] ids = new int[n];
// initially, point all nodes to themselves
        for (int i= 0; i < ids.length; i++) ids [i] = i;
        for (int[] edge: edges) union(edge [0], edge[1], ids);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < ids.length; i++) set.add (find (i, ids));
        int numC = set.size();
        for(int x: ids)
            System.out.print(x + " ");
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int id: ids)
            map.merge(id, 1, Integer::sum);
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for(int i=0; i< list.size(); i++){
            for(int j=i+1; j< list.size(); j++){
                ans+= (long) list.get(i) * list.get(j);
            }
        }

        return ans;
    }

    private void union(int e1, int e2, int[] ids) {
        int pp1= find (e1, ids); //pp1 is parent1
        int pp2 =find (e2, ids);//pp2 is parent2
        ids[pp1] = pp2;
    }


    private int find(int edge, int[] ids) {
        if (ids[edge] != edge)
            ids[edge] = find(ids [edge] , ids);
        return ids [edge];
    }

}
