package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class NQUEEN
{
  public static int n,cnt=0;
  public static int[] a;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n];
    f(0);
    System.out.println(cnt);
    scan.close();
  }
  public static void f(int depth)
  {
    if(!check(depth-1))return;
    if(depth==n){cnt+=1;return;}
    for(int i=1;i<=n;i++)
    {
      a[depth]=i;
      f(depth+1);
    }
  }
  public static boolean check(int depth)
  {
    for(int i=0;i<depth;i++)
    {
      if(a[depth]==a[i])return false;
      if(depth-i==abs(a[depth]-a[i]))return false;
    }
    return true;
  }
  
  public static int abs(int x)
  {
    if(x>0)return x;
    else return -x;
  }
}