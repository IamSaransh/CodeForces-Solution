package com.codeforces.contest799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int TT = fs.nextInt();
        for (int tt = 0; tt < TT; tt++) {
            int n = fs.nextInt();
            int[] ans = new int[n];
            for(int i=0; i<n;i++){
                ans[i] = fs.nextInt() %10;
            }
//            for(int i=0; i<n;i++){
//                System.out.print(ans[i]);
//                System.out.print(" ");
//            }
            int f = 0;
            n = ans.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (((ans[i] + ans[j] + ans[k]) % 10) == 3) {
                            f = 1;
                        }
                    }
                }
            }
            if (f == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
