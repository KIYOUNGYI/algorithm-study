package com.study.lms;

import java.util.Scanner;
public class inequal{
    public static boolean flag=false;
    public static int n;
    public static int[] arr;
    public static String[] giho;
    public static boolean[] v = new boolean[10];
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      f(0);
      initV();
      flag=false;
      f2(0);
      scan.close();
    }
    public static void initV()
    {
      v = new boolean[10];
    }
    public static void print()
    {
      for(int i=0;i<=n;i++){System.out.print(arr[i]);}System.out.println();
    }
    
    public static void inequal()
    {
      for(int i=0;i<n;i++)
      {
        String g = giho[i];
        if(g.equals("<"))
        {
          if(arr[i]>arr[i+1])return;
        }
        else
        {
          if(arr[i]<arr[i+1])return;
        }
      }
      print();
      flag=true;
      return;
    }
    
    public static void f(int depth)
    {
      if(flag)return;
      
      if(depth==n+1)
      {
        inequal();
        return;
      }
      
      for(int i=9;i>=0;i--)
      {
        if(!v[i]){
          v[i]=true;
          arr[depth]=i;
          f(depth+1);
          v[i]=false;
        }
      }
    }
    
    
    
    public static void f2(int depth)
    {
      if(flag)return;
      
      if(depth==n+1)
      {
        inequal();
        return;
      }
      
      for(int i=0;i<=9;i++)
      {
        if(!v[i]){
          v[i]=true;
          arr[depth]=i;
          f2(depth+1);
          v[i]=false;
        }
      }
    }
    
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      arr = new int[n+1];
      giho = new String[n];
      for(int i=0;i<n;i++)
      {
        giho[i] = scan.next();
      }
    }
}