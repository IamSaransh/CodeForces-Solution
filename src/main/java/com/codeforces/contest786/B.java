package com.codeforces.contest786;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n;
            n=sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i]=sc.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n;i++ ){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i])+1);
                }
                else{
                    map.put(arr[i],1);
                }
            }
            int ans = -1;
            for(int val: map.keySet()){
                if(map.get(val)>=3){
                    ans = val;
                }
            }
            System.out.println(ans);

        }
    }
}
