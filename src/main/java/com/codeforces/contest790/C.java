package com.codeforces.contest790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n = fr.nextInt();
            int m = fr.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = fr.nextLine();
            }
            Arrays.sort(arr);
            int globalMin = Integer.MAX_VALUE;
            for(int i=0; i<n;i++){
                for(int j=i+1; j<n;j++){
                    String s1 = arr[i];
                    String s2 = arr[j];
                    int currMin=0;
                    for(int k=0; k<m; k++){
                        currMin+= Math.abs(s1.charAt(k) -s2.charAt(k));
                    }
                    globalMin = Math.min(currMin, globalMin);
                }

            }
//            for(int i=0;i<n-1; i++){
//                String s1 = arr[i];
//                String s2 = arr[i+1];
//                //cal diff
//                int currMin=0;
//                for(int j=0; j<m; j++){
//                    currMin+= Math.abs(s1.charAt(j) -s2.charAt(j));
//                }
//                globalMin = Math.min(currMin, globalMin);
//            }
            System.out.println(globalMin);

        }
    }





    static class FastReader {
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
