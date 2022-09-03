package com.codeforces.contest787;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    private static long helper(long[] arr, int n) {
        if(n==1) return 0;
        long ans = 0;
        boolean flag = true;
        int cnt =0;
        while(flag){
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] >= arr[i + 1] ) {
                    arr[i] = arr[i] / 2;
                    ans++;
                }
            }
            cnt++;
        for(long val: arr)
            System.out.print(val + " --");
            System.out.println("\n");
//                if(checkStrictlyIncreasing(arr))
                    flag = false;
                if(cnt==5)
                    flag=false;
        }
        return ans;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n = sc.nextInt();
            long [] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
           long ans =  helper(arr, n);
            System.out.println(ans);

        }
    }
}

