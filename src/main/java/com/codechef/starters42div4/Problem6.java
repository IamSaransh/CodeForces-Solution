package com.codechef.starters42div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6 {
    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++){
            int N = fs.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i]=fs.nextInt();
            }
            //--now that I have my array ready!
            boolean isPossible = true;
            int maxSoFar = arr[0] , minSoFar = arr[0];
            for(int i=1; i<N; i++){

                if(arr[i] >=maxSoFar || arr[i] <= minSoFar){
                    maxSoFar = Math.max(maxSoFar,arr[i] );
                    minSoFar = Math.min(minSoFar,arr[i] );
                }
                else{
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) System.out.println("YES");
            else System.out.println("NO");

        }
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

