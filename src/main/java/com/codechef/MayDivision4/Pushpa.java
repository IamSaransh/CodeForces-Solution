package com.codechef.MayDivision4;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;



    public class Pushpa {

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int TT = sc.nextInt();
            for (int tt = 0; tt < TT; tt++) {
                int n = sc.nextInt();
                PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

                for(int i=0; i<n;i++){
                    queue.add(sc.nextInt());
                }
                //nums added to rhe queue
                boolean isPossible = true;
                int count=1;
                int globalMax = queue.poll();
                int current = globalMax;
                while(isPossible && !queue.isEmpty()){
                    int candidate = queue.poll();
                    if(candidate + count + 1 <= current ){
                        current=candidate;
                        globalMax = Math.max(current, globalMax);
                        count++;
                    }
                    else{
                        isPossible = false;
                    }
                }
                System.out.println(globalMax);

            }
        }
    }


