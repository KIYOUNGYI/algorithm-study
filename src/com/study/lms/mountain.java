package com.study.lms;

import java.util.Scanner;
public class mountain{
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      f(n);
      
      scan.close();
    }
    
    
    public static void f(int depth)
    {
      if(depth==1){System.out.print(1);return;}
      f(depth-1);
      System.out.print(depth);
      f(depth-1);
    }
}