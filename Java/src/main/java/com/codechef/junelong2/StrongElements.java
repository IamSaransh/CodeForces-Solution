package com.codechef.junelong2;

import com.Template2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class StrongElements {
    static void sieveOfEratosthenes(int n, boolean[] prime) {
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int TT = fs.nextInt();
        while(TT-->0)
        {
            int count =0;
            int n = fs.nextInt();
            int[] nums = fs.readArray(n);
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            fillHelper(prefix, nums, suffix, n);
            for(int i=0 ; i<n; i++){
                if(gcdOutlierChecker(i, prefix, suffix, n) > 1)
                    count++;
            }
            System.out.println(count);
        }


        out.close();
    }

    private static int gcdOutlierChecker(int i, int[] prefix, int[] suffix, int n) {
        if(i==0)
            return suffix[i+1];
        if(i==n-1)
            return prefix[i-1];
        return gcd(prefix[i-1], suffix[i+1]);
    }

    private static void fillHelper(int[] prefix, int[] nums, int[] suffix, int n) {
        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = gcd(prefix[i-1],nums[i] );
        }
        suffix[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = gcd(suffix[i+1],nums[i]);
        }
    }




    static final Random random=new Random();
    static final int mod=1_000_000_007;

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
//    static int gcd(int a, int b) {
//        while (b != 0) {
//            int t = a;
//            a = b;
//            b = t % b;
//        }
//        return a;
//    }
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
    boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    private static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
