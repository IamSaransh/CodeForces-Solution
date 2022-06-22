package com.codeforces.contest799;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int a= fr.nextInt();
            int b= fr.nextInt();
            int c= fr.nextInt();
            int d= fr.nextInt();
            int count = 0;
            if(b>a)
                count++;
            if(c>a)
                count++;
            if(d>a)
                count++;
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
