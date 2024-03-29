package com.codechef.julylong2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class CONCATSORT {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int TT = fs.nextInt();
        while (TT-- > 0) {
//            int n = fs.nextInt();
//            int[] arr = fs.readArray(n);
//            int i;
//            int j= 1;
//            boolean isPossible = true;
//            boolean ArraySorted = false;
//            for(i=0; i<n-1; i++)
//            {
//                if(arr[i+1] < arr[i] )
//                {
//                    //first break from seequesnce where a[j] < a[i] & j>i
//                    j = i+1;
//                    break;
//                }
//                if(i==n-2){
//                    System.out.println("YES");
//                    ArraySorted = true;
//                }
//            }
//            if(ArraySorted)
//                continue;
//            int secondSubArrayLastIndex = arr[j];
//            for(; i<n-1;i++){
//                if(arr[i+1] >= arr[i])
//                    continue;
//                else if(arr[i+1] >= secondSubArrayLastIndex){
//                    secondSubArrayLastIndex = arr[i+1];
//                }
//                else{
//                    isPossible = false;
//                    break;
//                }
//            }
//            if(isPossible)
//                System.out.println("YES");
//            else
//                System.out.println("NO");
            int n = fs.nextInt();
            int[] arr = fs.readArray(n);
            List<Integer> sorted = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

            List<Integer> secondList = new ArrayList<>();

            int i = 0; int j=0;
            for(;i<n;i++)
            {
                while(j<n && arr[j]!= sorted.get(i)){
                    secondList.add(arr[j]);
                    j++;
                }
                if(j==n)
                    break;
                if(arr[j]== sorted.get(i))
                    j++;
            }

            if(isListSOrted( secondList, secondList.size()))
                out.println("YES");
            else
                out.println("NO");
//            System.out.println(secondList);




        }

        out.close();
        out.flush();
    }


    static final Random random = new Random();
    static boolean isListSOrted(List<Integer> list , int n){
        for(int i=0;i<n-1; i++){
            if(list.get(i)> list.get(i+1))
                return false;
        }
        return  true;
    }

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

    static boolean isSorted(int[] arr) {
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
