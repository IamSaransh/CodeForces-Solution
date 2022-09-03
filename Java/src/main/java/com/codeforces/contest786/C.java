package com.codeforces.contest786;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
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
            boolean flag = true;
          //logic
             for(int i=0; i<n-2;i++){
                 if(arr[i]%2 != arr [i+2]%2){
                     flag = false; break;
                 }
             }
             if(flag){
                for(int i=1; i<n-3;i++){
                    if(arr[i+1]%2 != arr [i+3]%2){
                        flag = false; break;
                    }
                }
            }
             //end
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
