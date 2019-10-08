package com.study.lms;

import java.util.Scanner;
public class 카드놀이{
    public static int n;
    public static int[] a;
    public static long[] d;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      a = new int[n+1];
      d = new long[n+1];
      for(int i=1;i<=n;i++)a[i]=scan.nextInt();
      
      d[1]=a[1];
      if(n==1){System.out.println(d[1]);return;}
      d[2]=a[1]+a[2];
      if(n==2){System.out.println(d[2]);return;}
      d[3]=max(a[1]+a[2],a[1]+a[3],a[2]+a[3]);
      if(n==3){System.out.println(d[3]);return;}
      
      for(int i=4;i<=n;i++)
      {
        d[i]=max(d[i-1],d[i-2]+a[i],d[i-3]+a[i-1]+a[i]);
      }
      System.out.println(d[n]);
      
      scan.close();
    }
    
    public static long max(long a,long b,long c)
    {
      if(a>=b && a>=c)return a;
      if(b>=a && b>=c)return b;
      if(c>=a && c>=b)return c;
      
      return -1;
    }
}