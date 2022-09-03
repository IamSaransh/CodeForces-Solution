package com.codeforces.contest790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {

    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n = fr.nextInt();
            int m = fr.nextInt();
            int globalMax =  Integer.MIN_VALUE;
            int[][] b = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++) {
                    b[i][j] = fr.nextInt();
                }
            }
            //chessboard Up -> logic here
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++) {
                    int currMAx = b[i][j]; //bishop @i,j
                    //all diagonal sum from here
                    int row = i-1; int col = j-1;
                    while(row>=0 && col>=0){//topleft
                        currMAx+=b[row][col];
                        row--; col--;
                    }
                    row = i+1;  col = j+1;
                    while(row<n && col<m){//bottom right
                        currMAx+=b[row][col];
                        row++; col++;
                    }
                    row= i-1;  col = j+1;
                    while(row>=0 && col<m){//top-right
                        currMAx+=b[row][col];
                        row--; col++;
                    }
                    row = i+1; col = j-1;
                    while(row<n && col>=0){//bottom-left
                        currMAx+=b[row][col];
                        row++; col--;
                    }
//                    System.out.println(i + " " + j + " " + currMAx);
                    globalMax = Math.max(globalMax, currMAx);
                }
            }
            System.out.println(globalMax);
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
