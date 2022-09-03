package com.codeforces.practice.lessthan1300;



import java.util.*;

public class B1536 {


    public static void main(String[] args) {
       Scanner fs = new Scanner(System.in);
        int TT = fs.nextInt();

        while (TT-- > 0) {
            int n =  fs.nextInt();
            String s = fs.next();
            String bruteForceString = "abcdefghijklmnopqrstuvwxyz";
            Map<String, Boolean> inputMap = new HashMap<>();
            Map<String, Boolean> bruteForceMap = new TreeMap<>(
                    (x,y) -> {
                        if(x.length()==y.length())
                            return x.compareTo(y);
                        else  return Integer.compare(x.length(), y.length());
                    }
            );
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<=n;j++)
                {
                    inputMap.put(s.substring(i,j), true);
                }
            }
            char[] brtArray  = bruteForceString.toCharArray();
            for(int i=0;i<26;i++){
                bruteForceMap.put(String.valueOf(bruteForceString.charAt(i)), true);
            }
            for(int i=0;i<26;i++) {
                for (int j = 0; j < 26; j++) {
                    String temp = String.valueOf( "" + brtArray[i] + brtArray[j]);
                    bruteForceMap.put(temp, true);
                }
            }
            String temp ="a";
                for(int j=0;j<26;j++)
                {
                    for(int k=0;k<26;k++)
                    {
                        String news = String.valueOf( temp + brtArray[j] + brtArray[k]);
                        bruteForceMap.put(news, true);
                    }
                }
//            }
            for(String possibleAns: bruteForceMap.keySet())
            {
                if(!inputMap.containsKey(possibleAns))
                {
                    System.out.println(possibleAns);
                    break;
                }
            }


        }


    }





}
