package com.codeforces.practice.lessthan1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;






public class YoungPhysicist {






    public static void main(String[] args) {
        FastReader fs = new FastReader();
        long X = 0;
        long Y = 0;
        long Z = 0;
        int TT = fs.nextInt();
        for (int tt = 0; tt < TT; tt++) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            long z = fs.nextLong();
            X+=x;
            Y+=y;
            Z+=z;
        }
        System.out.println((X==0 && Y==0 && Z==0)? "YES": "NO");
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
