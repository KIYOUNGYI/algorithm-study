package com.study.lms;

import java.util.Scanner;
public class Car{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] arr = new int[5];
      int cnt=0;
      for(int i=0;i<5;i++)
      {
        arr[i]  =scan.nextInt();
        if(n==arr[i])cnt+=1;
      }
      System.out.println(cnt);
      scan.close();
    }
}