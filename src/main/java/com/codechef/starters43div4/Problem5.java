package com.codechef.starters43div4;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Distinct Palindrome : DISPAL
public class Problem5 {
    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
         char[]  ENGLISH_ALPHABETS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++){
            int N = fs.nextInt();
            int X = fs.nextInt();
            int debug = 0;
            if(N==1 ){
                System.out.println("a");
                continue;
            }

            if(N%2==0) {
                if(X == 26 && N>52){
                    System.out.println(-1);continue;
                }
                if(X == 1 ){
                    for(int i=0; i<N; i++)
                        System.out.print("a");
                    System.out.print("\n");
                    continue;
                }
            }
            if(N%2!=0) {
                if(X == 26 && N>51){
                    System.out.println(-1);continue;
                }
            }



            //even
            if(N%2==0){
                if( X > (N/2)  ){
                    System.out.println(-1);
                    continue;
                }
                else{
                    int i = 0;
                    for( ; i< X; i++) {
                        System.out.print(ENGLISH_ALPHABETS[i]);
                    }
                    //print a common letter
                    int times = N- 2*X;
                    for(int k=0; k<times; k++)
                        System.out.print(ENGLISH_ALPHABETS[i]);
                    for(int j=i-1; j>=0;j--){
                        System.out.print(ENGLISH_ALPHABETS[j]);
                    }
                    System.out.println();
                    continue;
                }
            }
            //odd
            if(N%2!= 0){
                if( X >  (((N-1)/2) + 1) ){
                    System.out.println(-1);
                    continue;
                }
                else{
                    N = (N-1);
                    int i = 0;
                    for( ; i< X-1; i++) {
                        System.out.print(ENGLISH_ALPHABETS[i]);
                    }
                    if(X%2==0){
                        for(int k=0; k< N - 2*X+1; k++){
                            System.out.print(ENGLISH_ALPHABETS[i+1]);
                        }
                    }
                    if(X%2!=0){
                        for(int k=0; k< N - 2*X+1; k++){
                            System.out.print(ENGLISH_ALPHABETS[i+1]);
                        }
                    }
                    for(int j=i-1; j>=0;j--){
                        System.out.print(ENGLISH_ALPHABETS[j]);
                    }
                    System.out.println();
                    continue;
                }
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
