package com.study.lms;

import java.util.Scanner;
public class 팩토리얼{
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      
      int result = f(n);
      System.out.println(result);
      scan.close();
    }
    
    public static int f(int n)
    {
      if(n==1)return 1;
      
      return n*f(n-1);
    }
}