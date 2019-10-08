package com.study.lms;

import java.util.Scanner;
public class pfactorization{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int x = 2;
      while(n!=1)
      {
        if(n%x==0){System.out.println(x);n = n/x;}
        else x+=1;
      }
      scan.close();
    }
}