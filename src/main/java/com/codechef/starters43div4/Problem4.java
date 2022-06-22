package com.codechef.starters43div4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4 {
    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int N = fr.nextInt();
            int K = fr.nextInt();
            int [] before =  new int[N];
            int date;
            for(int i=0; i<N; i++){
                date =  (i/5)+1;
                before[i] = date;
            }
            int[] after  = new int[N-1];
            for(int i=0; i<=K-2; i++){
                after[i] = before[i];
            }
            for(int i=K , j = K-1; i<N; i++, j++){
                after[j] = before[i];
            }
//            for(int x: before)
//                System.out.print(x + " ");
//            System.out.println();
//            for(int x: after)
//                System.out.print(x + " ");
//            System.out.println("\n---------------------------------");
            int count = 0;
            for(int i=0; i<N-1; i++){
                if(before[i] != after[i]){
                    count++;
                }
            }

            System.out.println(count);
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
