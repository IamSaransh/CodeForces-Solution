package com.codechef.starters43div4;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
//gcd
public class Problem6 {

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    static int fx(int a, int b){
        return lcm(a,b) + gcd(a,b);
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int TT = fr.nextInt();
        for(int tt=0; tt<TT;tt++){
            int n = fr.nextInt();
            HashSet<Integer> set = new HashSet<>();
            int i = n-1; int j = 1;
            int minfx = Integer.MAX_VALUE;
            int ans = 0;
            while(j<n && i>=1){

//                minfx  = Math.min( fx(i,j) , minfx );
                if(fx(i,j) == n  ){
                    ans++;
                    System.out.println(i + " " + j);
                }
                i--; j++;
            }
            System.out.println(ans);
//            System.out.println("--------------------------");
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
