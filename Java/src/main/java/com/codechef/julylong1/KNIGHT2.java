package com.codechef.julylong1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class KNIGHT2 {


    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        while(T-->0)
        {
            //Input
            int x1,y1,x2,y2;
            x1 = fs.nextInt(); y1 = fs.nextInt(); x2 = fs.nextInt(); y2 = fs.nextInt();

            //mapping can have either  inc/dec x by 2 and y by one and vice-versa
            int[][] bfsMapping = {{2,1}, {2,-1},{-2,1}, {-2,-1}, {1,2}, {-1,2},{1,-2}, {-1,-2}};
//            int[][] bfsMapping = {{2,1}, {1,2}}; ~ for debugging logic

            Queue<Pair<Integer,Integer>> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[8][8];
            int[][] board = new int[8][8];
            populate2DArray(board, -1);

            //Initialize bfs by putting starting pos
            q.add(new Pair(x1-1,y1-1));
            visited[x1-1][y1-1] = true;
            board[x1-1][y1-1]=0;

            //BFS start
            int currIteration =1;
            while(!q.isEmpty())
            {
                int currSize = q.size();
                while(currSize-->0)
                {
                    Pair<Integer, Integer> x = q.poll();
                    for(int i=0;i< bfsMapping.length;i++){
                        int newX = bfsMapping[i][0]+x.getKey();
                        int newY = bfsMapping[i][1]+x.getValue();
                        Pair<Integer, Integer> newCoordinate = new Pair<>(newX,newY);
                        if(isValid(newCoordinate, visited)){
                            q.add(newCoordinate);
                            visited[newCoordinate.getKey()][newCoordinate.getValue()] = true;
                            board[newCoordinate.getKey()][newCoordinate.getValue()] = currIteration;
                        }
                    }
                }
                currSize = q.size();
                currIteration++;
            }
            if(board[x2-1][y2-1]!=-1 &&  board[x2-1][y2-1]%2==0){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }
        out.close();
    }

    private static boolean isValid(Pair<Integer, Integer> p, boolean[][] visited) {
        int x = p.getKey();
        int y = p.getValue();
        if(x>=0 && x<=7 && y>=0 && y<=7 && visited[x][y]==false)
            return true;
        return false;
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
    static void populate2DArray(int[][] a, int valueToBePopulated) throws Exception {
        int rows = a.length;
        if(rows==0) throw  new Exception("Dude u crazy?");
        int cols = a[0].length;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
                a[i][j] = valueToBePopulated;
        }
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
            return "Pair{" + key + ", " + value + "}";
        }

        public T getValue() {
            return this.value;
        }

        public S getKey() {
            return this.key;
        }
    }


}
