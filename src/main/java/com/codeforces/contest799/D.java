package com.codeforces.contest799;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static boolean isPalindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        String rev=sb.toString();
        if(str.equals(rev)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader() ;
        int TT = fs.nextInt();
        for(int tt=0; tt<TT;tt++){
            Set<Integer> set = new HashSet<>();
            int ans = 0;
            String line = fs.nextLine();
            String time = line.split(" ")[0];
            int x = Integer.parseInt(line.split(" ")[1]);

            int hour = Integer.parseInt(time.split(":")[0]);
            int mins =     Integer.parseInt(time.split(":")[1]);
            int x_hours = x/60;
            int x_mins = x%60;

            set.add(hour*60 + mins);
            if( hour*60 + mins  == 0  ) set.add(240);
            int temp_hour = -1; int temp_mins = -1; int counter = 0;
//            while( ((temp_hour * 60) + temp_mins) != (hour * 60) + mins)  {
            while(!set.contains(temp_hour*60 + temp_mins)){

                if(counter == 0){
                    temp_hour = hour;
                    temp_mins = mins;
                }
                counter++;
;               // ADD HOUR AND MINS
                temp_hour += x_hours;
                temp_mins+= x_mins;
                int toIncHour = temp_mins / 60;
                temp_hour = (temp_hour % 24) + toIncHour ;
                 temp_mins = temp_mins %60;
                System.out.println("counter-->" + counter + "        " + String.valueOf(temp_hour)  + String.valueOf((temp_mins)) +
                        "             " + String.valueOf(hour)  + String.valueOf((mins)) );
                 if(isPalindrome(String.valueOf(temp_hour)  + String.valueOf((temp_mins))))
                     ans++;

            }
            System.out.println(ans);
        }
    }





    private static class FastReader {
        BufferedReader br;
        public StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
