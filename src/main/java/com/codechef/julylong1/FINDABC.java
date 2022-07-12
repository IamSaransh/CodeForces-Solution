package com.codechef.julylong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class FINDABC {


    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int TT = fs.nextInt();
        for(int tt= 0; tt<TT;tt++){
            int  NN = fs.nextInt();

            int[] nums = new int[ (NN+1)];
            for(int i=0;i<=NN;i++){
                nums[i] = fs.nextInt();
            }

            int[] answerArray  = {0,0,0};
            for(int i = helperForPowerOfN((int) NN); i>0; i/=2){
                int difference =  nums[i] - nums[0];

                if(difference<0)
                {
                    difference*=-1;
                    int countInIf =  (difference/i);
                    if(countInIf==1)
                    {
                        countInIf=2;
                        if((answerArray [0] ^ i) <= NN){
                            answerArray [0]^=i;
                            countInIf--;
                        }
                        if( countInIf>0 && (answerArray [1] ^ i) <=NN)
                        {
                            answerArray [1]^=i;
                            countInIf--;
                        }
                        if( countInIf>0 && (answerArray [2] ^ i) <=NN)

                        {
                            answerArray [2]^=i;
                            for(int j=0;j<5;j++){
                                int dummy =j;
                            }
                        }
                    }
                    else if(countInIf==3)
                    {
                        answerArray [0]^=i; answerArray [1]^=i; answerArray [2]^=i;
                        for(int j=0;j<5;j++){
                            int dummy =j;
                        }
                    }
                }
                else
                {
                    int countInElse = (int) (difference/i);
                    if(countInElse==1)
                    {
                        if((answerArray [0]^i)<=NN)
                            answerArray [0]^=i;
                        else if((answerArray [1]^i)<=NN)
                            answerArray [1]^=i;
                        else
                            answerArray [2]^=i;
                    }
                }
                Arrays.sort(answerArray ); // sorting the array and then printing the values ABC
            }
            out.println(answerArray [0] + " " + answerArray [1] + " " + answerArray [2]);
        }

        out.close();
        out.flush();
    }

    static int helperForPowerOfN(int n){
            int resultValue= 0;
            for(int ii=n; ii>=1;ii--){
                if((ii & (ii-1)) ==0) {
                    resultValue = ii; break;
                }
            }
        return resultValue;
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
