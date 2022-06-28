package com.leetcode.practice;


import java.math.BigInteger;

class Solution {
    static int mod = 1000000007;
    public static long pow(long a,long b)
    {
        long ans = 1;
        while(b> 0)
        {
            if((b & 1)==1){
                ans = (ans*a) % mod;
            }
            a = (a*a) % mod;
            b = b>>1;
        }
        return ans;
    }

     int countHousePlacements(int N)
    {
        // Base case here
        if (N == 1)
            return 4;

        long cB=1, cS=1, pcB, pcS;

        for (int i=2; i<=N; i++)
        {
            pcB = cB;
            pcS = cS;

            cS = (pcB%mod + pcS%mod)%mod;
            cB = pcS;
        }

        long r = ((cS %mod)+ (cB%mod) ) %mod;
        BigInteger b = new BigInteger(String.valueOf(r)).mod(new BigInteger(String.valueOf(mod)));
        b = b.multiply(b).mod(new BigInteger(String.valueOf(mod)));
        return b.intValue()%mod;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countHousePlacements(10000));

    }


}