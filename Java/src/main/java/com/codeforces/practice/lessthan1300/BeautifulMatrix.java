package com.codeforces.practice.lessthan1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulMatrix {


    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int[][] arr = new int[5][5];
        fs.read2DArray(arr, 5,5);
        int X = 0;
        int Y = 0;
        for(int i=0; i< 5; i++){
            for(int j=0; j< 5;j++){
                if(arr[i][j] == 1){
                    X = i; Y=j;
                }
            }
        }
        System.out.println(Math.abs(2-X) + Math.abs(Y-2));
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
        void read2DArray(int[][] arr){
            int row = arr.length;
            int col = arr[0].length;
            for(int i=0; i< row; i++){
                for(int j=0; j< col;j++){
                    arr[i][j] = nextInt();
                }
            }
        }
        void read2DArray(int[][] arr, int row, int col){
            for(int i=0; i< row; i++){
                for(int j=0; j< col;j++){
                    arr[i][j] = nextInt();
                }
            }
        }
    }

}
