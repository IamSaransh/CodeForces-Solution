package com.codechef.MayDivision4;

import java.io.IOException;
import java.util.Scanner;

public class SugarCane {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for (int tt = 0; tt < TT; tt++) {
            long glass = sc.nextLong(); //30 percent of money =n profit
            //1 glass 50 coins
            System.out.println(15 * glass);

        }
    }

}
