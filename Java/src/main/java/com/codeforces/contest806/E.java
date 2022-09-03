package com.codeforces.contest806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int TT = fs.nextInt();
        while(TT-->0)
        {
            int n = fs.nextInt();
            int[][] m1 = new int[n][n];
            int[][] m2 = new int[n][n];
            int[][] m3 = new int[n][n];
            int[][] m4 = new int[n][n];
            for(int i=0;i<n;i++){
                char[] c = fs.next().toCharArray();
                for(int j=0;j<n;j++){
                    m1[i][j] = c[j] - '0';
                    m2[i][j] = c[j] - '0';
                    m3[i][j] = c[j] - '0';
                    m4[i][j] = c[j] - '0';
                }
            }
            for(int i=1;i<=1;i++){
                rotate90Clockwise(m2, n);
            }
            for(int i=1;i<=2;i++){
                rotate90Clockwise(m3, n);
            }
            for(int i=1;i<=3;i++){
                rotate90Clockwise(m4, n);
            }
            int ans = 0;
            for(int i = 0; i<n;i++){
                for(int j=0;j<n;j++){
                    if(m1[i][j] == m2[i][j] && m2[i][j] == m3[i][j] && m3[i][j] == m4[i][j])
                        continue;
                    else{
                        int count1 =0, count0=0;
                        if (m1[i][j] == 1) {
                            count1++;
                        } else {
                            count0++;
                        }
                        if (m2[i][j] == 1) {
                            count1++;
                        } else {
                            count0++;
                        }
                        if (m3[i][j] == 1) {
                            count1++;
                        } else {
                            count0++;
                        }
                        if (m4[i][j] == 1) {
                            count1++;
                        } else {
                            count0++;
                        }
                        ans+= Math.min(count0, count1);
                    }
                }
            }
            System.out.println( ans/4);
        }




        out.close();
    }


    static void rotate90Clockwise(int a[][], int N)
    {

        // Traverse each cycle
        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }


    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
