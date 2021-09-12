package com.study.bj.week004.temp;

import java.util.Scanner;

public class Tobin {
    public static int n,r;
    public static int[] arr;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();r=scan.nextInt();arr=new int[n];
      f(0,0);
      
    }
    public static void print()
    {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<n;i++)
      {
        sb.append(arr[i]);
      }
      System.out.println(sb.toString());
    }
    
    public static void f(int depth,int cnt)
    {
      if(cnt==r)
      {
        print();
        return;
      }
      
      if(depth==n){return;}
      
      arr[depth]=1;
      f(depth+1,cnt+1);
      arr[depth]=0;
      f(depth+1,cnt);
    }
}