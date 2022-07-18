package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
       int[] arr = {9,8,7,6,5,4,3,2,1,1,1,};
       quickSort(arr, 0, arr.length-1);
       printArray(arr);
    }

    static final void printArray(int[] arr){
        for(int x: arr)
            System.out.print(x + " ");
    }

    private static void quickSort(int[] arr, int s, int e) {
        //@Base Case
        if(s>=e)
            return;

        int p = partition(arr, s, e);
        quickSort(arr, s, p-1 );
        quickSort(arr, p+1, e );
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int count = 0;
        for(int i = s+1; i<arr.length; i++)
        {
            if(arr[i] < pivot)
                count++;
        }
        // place the pivot element atr its right place
        int pivotIndex = s + count;
        swap(arr, s, pivotIndex);

        int i = s; int j = e;
        while(i<pivotIndex && j> pivotIndex)
        {
            while(arr[i]< pivot)
                i++;
            while(arr[j]>pivot)
                j++;
            //ab jaha ruke hai vaha pivot change krna hai!
            if(i<pivotIndex && j> pivotIndex)
                swap(arr, i++, j--);
        }
        return pivotIndex;
    }

    @SuppressWarnings("unused")
    static final Random random = new Random();
    @SuppressWarnings("unused")
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
    static boolean isSorted(int[] arr) {
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

    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    static void shuffleArray(long[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }
    @SuppressWarnings("unused")
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    @SuppressWarnings("unused")
    class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>> {
        S first;
        T second;

        Pair(S f, T s) {
            first = f;
            second = s;
        }

        @Override
        public int compareTo(Pair<S, T> o) {
            int t = first.compareTo(o.first);
            if (t == 0) return second.compareTo(o.second);
            return t;
        }

        @Override
        public int hashCode() {
            return (31 + first.hashCode()) * 31 + second.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            if (o == this) return true;
            Pair p = (Pair) o;
            return first.equals(p.first) && second.equals(p.second);
        }

        @Override
        public String toString() {
            return "Pair{" + first + ", " + second + "}";
        }
    }

}
