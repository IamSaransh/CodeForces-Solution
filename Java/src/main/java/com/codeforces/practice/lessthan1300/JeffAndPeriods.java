package com.codeforces.practice.lessthan1300;

import com.sun.xml.internal.ws.api.pipe.helper.AbstractPipeImpl;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class JeffAndPeriods {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int[] arr = fs.readArray(n);
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        TreeMap<Integer, Integer> ans = new TreeMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i]) )
            {
                map.put(arr[i], new Pair(-1, i));
            }
            else // map contains key
            {
                if(map.get(arr[i]).getKey()==-1) // abhi tak ek hi instance aya hai is value ka
                {
                    /*
                    1. map update kro, ans bhi update kro
                     */
                    map.put(arr[i], new Pair(map.get(arr[i]).getValue(), i));
                }
                else {
                    /*both values present hai is element ki, check if the ap stands
                        - if stands update the key and value of pair in map
                        else make this element ans false in ans map.
                    */
                    if (map.get(arr[i]).getValue() - map.get(arr[i]).getKey() == i - map.get(arr[i]).getValue()) {
                        map.put(arr[i], new Pair(map.get(arr[i]).getValue(), i));
                    }
                    else{
                        map.put(arr[i], new Pair(-2, -2));
                    }
                }
            }
        }
//        System.out.println(map.toString());

        for(int key: map.keySet()){
            if(map.get(key).getKey()==-1)
                ans.put(key,0);
            if(map.get(key).getKey()!=-2 && map.get(key).getKey()!=-1 )
                ans.put(key, map.get(key).getValue() - map.get(key).getKey());
        }
        out.println(ans.size());

        for(int key: ans.keySet())
            out.println(key + " " + ans.get(key));
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

