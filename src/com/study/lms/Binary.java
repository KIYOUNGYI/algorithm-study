package com.study.lms;

import java.util.Scanner;
public class Binary{
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      
      StringBuilder sb = new StringBuilder();
      while(n!=0)
      {
        int x = n%2;
        sb.append(x);
        n = n/2;
      }
      // System.out.println(sb.toString());
      String x = sb.toString();
      for(int i=x.length()-1;i>=0;i--)
      {
        System.out.print(x.charAt(i));
      }
      
      scan.close();
    }
}