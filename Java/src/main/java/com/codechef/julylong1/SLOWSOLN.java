package com.codechef.julylong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SLOWSOLN {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        while(T-->0)
        {
            int maxT = fs.nextInt();
            int maxN = fs.nextInt();
            int sumN  = fs.nextInt();

            int maxTestCases = (int) Math.min(Math.ceil((double)sumN/ maxN), maxT);
            //calculate the values of N for each test case;
            int lastTestCase_N = sumN % maxN;
            long iterations  = 0;
            if(maxTestCases * maxN <= sumN){
                for(int i=0;i<maxTestCases;i++){
                    iterations += Math.pow(maxN, 2);
                }
            }
            else{
//                while(sumN!=0){
//                    if(sumN-maxN>0){
//                        iterations+= Math.pow(maxN,2);
//                        sumN-=maxN;
//                    }
//                    else{
//                        iterations+=Math.pow(sumN, 2);
//                        //set sum as zero to terminate the loop or (essentially taking the
//                        //module remainder of (sum,N%maxN for the last test case)
//                        sumN=0;
//                    }
//                }
                if(lastTestCase_N==0){
                    iterations  = (long) ((long) maxTestCases * Math.pow(maxN,2));
                }
                else{
                    iterations = (long) ((long) (maxTestCases - 1) * Math.pow(maxN,2) + (long) Math.pow(lastTestCase_N,2));
                }
            }
            System.out.println(iterations);

        }

        out.close();
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
