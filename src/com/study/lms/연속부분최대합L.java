package com.study.lms;

import java.util.Scanner;

public class 연속부분최대합L{
  public static int n;
  public static long[] a;
  public static long[] s;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new long[n+1];s = new long[n+1];
    for(int i=1;i<=n;i++)a[i]=scan.nextLong();
    s[1]=a[1];
    for(int i=1;i<=n;i++){s[i]=max(s[i-1]+a[i],a[i]);}
    
    long max=Long.MIN_VALUE;
    for(int i=1;i<=n;i++)
    {
      if(s[i]>max){max=s[i];}
    }
    System.out.println(max);
  }  
  
  public static long max(long a,long b)
  {
    if(a>=b)return a;else return b;
  }
}