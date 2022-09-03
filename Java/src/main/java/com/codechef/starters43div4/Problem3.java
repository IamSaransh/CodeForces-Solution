package com.codechef.starters43div4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int N = fr.nextInt();
            char [] DNA = fr.nextLine().toCharArray();
            char [] encoded  =  new char[N/2];
            for(int i=0 , j=0; i<N; i+=2, j++){
                String seq  = String.valueOf(DNA[i]) + DNA[i + 1];
//                System.out.println(seq);
                if(seq.equals("00") )
                    encoded[j] = 'A';
                if(seq.equals("01") )
                    encoded[j] = 'T';
                if(seq.equals("10") )
                    encoded[j] = 'C';
                if(seq.equals("11") )
                    encoded[j] = 'G';
            }
            for(char c: encoded)
                System.out.print(c);
            System.out.println();

            /*
            00 is replaced with A
                01 is replaced with T
                10 is replaced with C
                11 is replaced with G
             */
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
