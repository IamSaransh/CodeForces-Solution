package com.codechef.starters42div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4 {
    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++){
            int A = fs.nextInt();
            int B = fs.nextInt();
            if(A%3==0 || B%3 ==0)
                System.out.println(0);
            else if( (Math.abs(A-B) )% 3 == 0)
                System.out.println(1);
            else
                System.out.println(2);
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

