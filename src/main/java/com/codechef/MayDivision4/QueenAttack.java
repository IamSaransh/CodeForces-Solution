package com.codechef.MayDivision4;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class QueenAttack {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int TT = sc.nextInt();
        for (int tt = 0; tt < TT; tt++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            //x= x-1; y=y-1;
            //top, -> (x-1,y) down(x+1,y), left (x,y-1), right(x,y+1)
            //top-right(x-1,y+1) //top-left(x-1,y-1)
            //bottom-right(x+1,y+1) //bottom-left(x+1,y-1)
            //Termination ? reach the end/out of matrix
            int count = 0;

            // Find all moves for x + 1, y + 1
            if ((n - x) > 0 && (n - y) > 0)
                count += Math.min((n - x),
                        (n - y));

            
            if ((y - 1) > 0 && (x - 1) > 0)
                count += Math.min((y - 1),
                        (x - 1));

           
            if ((x - 1) > 0 && (n - y) > 0)
                count += Math.min((x - 1),
                        (n - y));

            
            if ((n - x) > 0 && (y - 1) > 0)
                count += Math.min((n - x),
                        (y - 1));

            count += (n - 1) + (n - 1);
            System.out.println(count);

        }
    }
}
