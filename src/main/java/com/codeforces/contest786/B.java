package com.codeforces.contest786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        int TT = Integer.parseInt(bfn.readLine());
        for(int tt=0; tt<TT;tt++){
            String s = bfn.readLine();
            char l1 = s.charAt(0);
            char l2 = s.charAt(1);

            //there will be 25 words per one cycle since one common pair will be ignored
            int ans = 0;
            ans = 25* (l1-'a');
            ans += l2-'a' +1;
            if(l2>l1)
                ans--;
            System.out.println(ans);


        }
    }
}
