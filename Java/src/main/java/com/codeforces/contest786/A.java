package com.codeforces.contest786;

import java.util.Scanner;

public class A {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for(int tt=0; tt<TT;tt++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!(y%x==0 )){
                System.out.println("0 0");
            }
            else{
                System.out.println("1 " +y/x );
            }
        }
    }
}
