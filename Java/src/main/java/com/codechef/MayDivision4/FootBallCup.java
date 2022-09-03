package com.codechef.MayDivision4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FootBallCup {
        public static void main(String[] args) throws IOException {
           Scanner sc = new Scanner(System.in);
            int TT = sc.nextInt();
            for(int tt=0; tt<TT;tt++) {
               int t1 = sc.nextInt();
                int t2 = sc.nextInt();

                if(t1>0 || t2>0){
                    if(t1==t2)
                        System.out.println("YES");
                    else System.out.println("NO");
                }
                else
                    System.out.println("NO");
            }

        }
}
