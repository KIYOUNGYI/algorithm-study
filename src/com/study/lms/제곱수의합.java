package com.study.lms;

import java.util.Scanner;

public class 제곱수의합
{
   public static int n;
   public static int MAX = 100020;
   public static int[] d = new int[MAX];
  public static boolean[] s = new boolean[MAX];
   public static void main(String[] args)
   {
    // System.out.println(317*317);
     Scanner scan = new Scanner(System.in);
     for(int i=1;i<=316;i++)s[i*i]=true;
     
     for(int i=1;i<MAX;i++)
     {
       d[i] = Integer.MAX_VALUE;
       if(s[i]==true)
       {
         d[i]=1;
       }
       else
       {
         for(int j=1;j*j<=i;j++)
         {
           d[i] = min(d[i],d[i-j*j]+d[j*j]);
         }
       }
     }
     n = scan.nextInt();
     System.out.println(d[n]);     
     scan.close();
   }
   public static int min(int a,int b)
   {
     if(a<b)return a;
     else return b;
   }
}