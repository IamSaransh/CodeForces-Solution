package com.leetcode.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class FindCallOrder {

    public void  myMethod()
    {
        System.out.println("company");
    }
    {
        System.out.println("sortune one");
    }
    public FindCallOrder(){
        System.out.println("is a");
    }
    static {
        System.out.println("walmart");
    }

    public static void main(String[] args) {
        FindCallOrder f = new FindCallOrder();
        f.myMethod();
    }
}
