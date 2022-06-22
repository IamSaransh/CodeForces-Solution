package com.codeforces.contest799;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C{
    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            String notUsed = fr.nextLine();
            char[][] chess= new char[8][8];
            for(int i=0; i< 8; i++){
                chess[i] = fr.nextLine().toCharArray();
            }
            int[] ans = new int [2];
            for(int row=1; row< 7 ; row++ ){
                for(int col=1; col< 7 ; col++){
                    if(chess[row-1][col-1] == '#' &&
                            chess[row-1][col+1] == '#' &&
                            chess[row+1][col+1] == '#' &&
                            chess[row+1][col-1] == '#'
                    ){
                        ans[0] = row+1;
                        ans [1] = col+1;
                        break;
                    }
                }
            }
            System.out.println(ans[0] + " " + ans[1]);


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
