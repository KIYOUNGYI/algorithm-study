package com.study.lms;

import java.util.Scanner;
public class 순열구하기{
    public static int n,r;
    public static boolean[] v;
    public static int[] arr;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      f(0);
      
      scan.close();
    }
    
    public static void print()
    {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<r;i++)
      {
        // System.out.print((char)(arr[i]+97));
        sb.append((char)(arr[i]+97));
      }
      System.out.println(sb.toString());
    }
    
    public static void f(int depth)
    {
      if(depth==r)
      {
        print();
        return;
      }
      
      for(int i=0;i<n;i++)
      {
        if(!v[i])
        {
          v[i]=true;
          arr[depth]=i;
          f(depth+1);
          v[i]=false;
          arr[depth]=0;
        }
      }
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      r = scan.nextInt();
      arr = new int[r];
      v = new boolean[n];
    }
}
