package com.codechef.starters42div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5 {
    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++){
            int N = fs.nextInt();
            String S =  fs.nextLine();
            StringBuilder sb  = new StringBuilder();
            for(char x: S.toCharArray()) {
//                System.out.println(x);
                if (x == '0')
                    sb.append('<');
                else
                    sb.append('>');
            }
            int M = N-1;
            String modifiedString = sb.toString();
            int ans = 0;
            if(M>=2){
                if(modifiedString.charAt(0) == '>')
                    ans++;
                if( modifiedString.charAt(M-1) == '<')
                    ans++;
                int countPeak = modifiedString.split("<>").length-1;
                System.out.println(ans+countPeak);
            }
            else{
                System.out.println(1);
            }


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

