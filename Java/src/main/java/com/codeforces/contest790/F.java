package com.codeforces.contest790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {

    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n = fr.nextInt();
            int k = fr.nextInt();
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i]= fr.nextLong();
            }
            //i/P done
            Map<Long, Integer> map =  new HashMap<>();
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for(long val: a){
                min = Math.min(val, min);
                max = Math.max(max, val);
                if(map.containsKey(val)){
                    map.put(val, map.get(val)+1);
                }
                else{
                    map.put(val, 1);
                }
            }//O(n)
            long globalMax = Long.MIN_VALUE;
            long globalMin = Long.MAX_VALUE;
            boolean printed = false;
            while(min<max){
                if(!map.containsKey(min))
                    min++;
                if(!map.containsKey(max))
                    max--;
                if(!(map.get(min)>=k)){
                    min++;
                    continue;
                }
                if(!(map.get(max)>=k)){
                    max--;
                    continue;
                }

                if(ifPossible(min, max,k, map)){
                    System.out.println(min + " " + max);
                    printed = true;
                    break;
                }
                else{
                    max--;
                    min--;
                }

            }

            if(!printed)
                System.out.println(-1);



        }
    }

    private static boolean ifPossible(long min, long max, int k, Map<Long, Integer> map) {
        for(long i=min; i<=max; i++){
            if(map.containsKey(i)){
                if(map.get(i)<k){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
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
