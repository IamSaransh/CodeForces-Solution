package com.codechef.MayDivision4;

import java.io.IOException;
import java.util.Scanner;

public class MiamiGP {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for(int tt=0; tt<TT;tt++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            double reqTime =  ((double)t2/(double)t1) * (double)100;
            System.out.println(reqTime);
            if(reqTime<= 107.0){
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }

    }
}
