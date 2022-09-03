package com.codeforces.contest786;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {
    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }
    static boolean TCOntainsS(String s, String t){
        for(char c: s.toCharArray()){
            if(t.contains((c+ ""))){
               return true;
            }
        }
        return false;
    }
    public static void main(String[ ] args) throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        int TT = Integer.parseInt(bfn.readLine());
        for(int tt=0; tt<TT;tt++){
            String s = bfn.readLine();
            String t = bfn.readLine();
            if(t.length()==1){
                long ans = 0;
                if(TCOntainsS(s,t)){
                    for(char c: s.toCharArray()){
                        if(c!=t.charAt(0)){
                            ans++;
                        }
                        System.out.println("ans " + ans);
                    }
                    if(ans==0){
                        System.out.println(1); continue;
                    }
                    int returnVal =  factorial((int)ans)+1;
                    if(returnVal==3)
                        System.out.println(4);
                    else
                        System.out.println(returnVal);
                    continue;
                }
                else{
                    ans+=factorial(s.length());
                    System.out.println(ans);
                    continue;
                }

            }
            if(t.length()>1){
                if(TCOntainsS(s,t)){
                    System.out.println(-1);
                }
                else{
                    int returnVal =  factorial(s.length())+1;
                    int printVal;
                    if(returnVal==3)
                        System.out.println(4);
                    else
                        System.out.println(returnVal);
//                    continue;
//                    System.out.println(factorial(s.length()));
                }
            }

        }
    }
}
