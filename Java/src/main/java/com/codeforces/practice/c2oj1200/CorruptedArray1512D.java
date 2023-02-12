package com.codeforces.practice.c2oj1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CorruptedArray1512D {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int TT = fs.nextInt();
        while (TT-- > 0) {
            int n = fs.nextInt();
            int b[] = fs.readArray(n+2);
            ruffleSort(b);
            //now the last element is the sum element;
            int sum = b[n+1];
            int indexThatShouldBeRemoved  = -1;
            int sumTillNPlus1 = 0;
            for(int i=0;i<n+1;i++) {
                sumTillNPlus1+=b[i];
            }
            for(int i=0;i<n+1;i++){
                if(sumTillNPlus1-b[i] == sum) {
                    indexThatShouldBeRemoved = i;
                    break;
                }
            }
            if(n==1)
            {
                if(b[0]==b[2]){
                    out.print(b[0]);
                }
                else if(b[1]==b[2])
                    out.println(b[1]);
                else out.println(-1);

                continue; // go to next testcaswe
            }
            if(indexThatShouldBeRemoved==-1){
                out.println(-1);
            }
            else{
                for(int i=0;i<n+1;i++){
                    if(i!=indexThatShouldBeRemoved){
                        out.print(b[i]);
                        out.print(" ");
                    }
                }
                out.print("\\");
            }


        }

        out.close();
        out.flush();
    }


    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    @SuppressWarnings("unused")
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    @SuppressWarnings("unused")
    boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unused")
    static long add(long a, long b) {
        return (a + b) % mod;
    }

    @SuppressWarnings("unused")
    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    @SuppressWarnings("unused")
    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    @SuppressWarnings("unused")
    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    @SuppressWarnings("unused")
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    @SuppressWarnings("unused")
    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        @SuppressWarnings("unused")
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        @SuppressWarnings("unused")
        int nextInt() {
            return Integer.parseInt(next());
        }

        @SuppressWarnings("unused")
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        @SuppressWarnings("unused")
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
