package com.codeforces.contest799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class E {

    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int [] a = new int [n];
            for(int i =0; i<n; i++){
                a[i] = fs.nextInt();
            }
            int len = lenOfLongSubarr(a, n, k);
            if(len == Integer.MIN_VALUE)
                System.out.println(-1);
            else
            System.out.println(n-len);

        }
    }
    static int lenOfLongSubarr(int[] arr, int n, int k)
    {
        Map<Integer, Integer> mp =
                new HashMap<>();
        int sum_value = 0,
    myMaxLenValue = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            sum_value += arr[i];

            if (sum_value == k)
                myMaxLenValue = i + 1;


            if (!mp.containsKey(sum_value)) {
                mp.put(sum_value, i);
            }


            if (mp.containsKey(sum_value - k)) {

                if (myMaxLenValue < (i - mp.get(sum_value - k)))
                    myMaxLenValue = i - mp.get(sum_value - k);
            }
        }

        return myMaxLenValue;
    }


    private static class FastReader {
        BufferedReader br;
        public StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
