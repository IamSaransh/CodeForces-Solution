package com.codechef.julylong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class LARSQR31 {


    public static void main(String[] args) {
        final boolean __DEBUG  =false;
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int[][] garden = new int[n][n];
        for(int row=0;row<n;row++){
            int start = fs.nextInt();
            int end = fs.nextInt();
            for(int col=start; col<=end;col++){
                garden[row][col] = 1;
            }
        }


        if(__DEBUG)
        {
            for(int row=0;row<n;row++){
                for(int col=0; col<n;col++){
                    System.out.print(garden[row][col] + " ");
                }
                System.out.print("\n");
            }
        }
        //Garden is ready now apply the solution to leetcode 221. Maximal Square
        System.out.println(helper(garden));



        out.close();
        out.flush();
    }



    public static int helper(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int masques = 0;
        if(rows==1 || cols == 1)
            return 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == 0) {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (masques < sqlen) {
                        masques = sqlen;
                    }
                }
            }
        }
        return masques;
    }
    public static int maximalSquare(int[][]  matrix) {
        int m = matrix.length, n = matrix[0].length, sz = 0;
        if(m==1 || n== 1)
            return 1;
//        vector<vector<int>> dp(m, vector<int>(n, 0));
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0 || matrix[i][j] == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                sz = Math.max(dp[i][j], sz);
            }
        }
        return sz * sz;
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
    private static class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>> {
        S key;
        T value;

        Pair(S f, T s) {
            key = f;
            value = s;
        }

        @Override
        public int compareTo(Pair<S, T> o) {
            int t = key.compareTo(o.key);
            if (t == 0) return value.compareTo(o.value);
            return t;
        }

        @Override
        public int hashCode() {
            return (31 + key.hashCode()) * 31 + value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            if (o == this) return true;
            Pair p = (Pair) o;
            return key.equals(p.key) && value.equals(p.value);
        }

        @Override
        public String toString() {
            return "Pair{" + key + " : " + value + "}";
        }

        public T getValue() {
            return this.value;
        }

        public S getKey() {
            return this.key;
        }

    }

}
