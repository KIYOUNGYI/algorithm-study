package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;

public class 직사각형의합{
  
  public static int n;
  public static int m;
  public static int q;
  public static long[][] a;
  public static long[][] s;
  public static int xLen;
  public static int yLen;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    input(scan);
    // printA();
    makeS();
    // printS();
    inputQ(scan);
  }
  
  public static void inputQ(Scanner scan)
  {
    ArrayList<Long> ans = new ArrayList();
    
    for(int i=0;i<q;i++)
    {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();
      int d = scan.nextInt();
      a = a+1;b=b+1;c=c+1;d=d+1;
      long x = s[c][d]-s[c][b-1]-s[a-1][d]+s[a-1][b-1];
      ans.add(x);
    }
    for(int i=0;i<ans.size();i++)
    {
      System.out.println(ans.get(i));
    }
  }
  
  public static void makeS()
  {
    for(int i=1;i<xLen-1;i++)
    {
      for(int j=1;j<yLen-1;j++)
      {
        s[i][j]=s[i-1][j]+s[i][j-1]+a[i][j]-s[i-1][j-1];
      }
    }
  }
  
  public static void input(Scanner scan)
  {
    n = scan.nextInt();m = scan.nextInt();q=scan.nextInt();
    xLen = n+2;yLen=m+2;
    a = new long[xLen][yLen];
    s = new long[xLen][yLen];
    for(int i=1;i<xLen-1;i++)
    {
      for(int j=1;j<yLen-1;j++)
      {
        a[i][j] = scan.nextLong();
      }
    }
  }
  
  
  public static void printA()
  {
    for(int i=0;i<xLen;i++)
    {
      for(int j=0;j<yLen;j++)
      {
        System.out.print(a[i][j]+" ");
      }System.out.println();
    }
  }
  public static void printS()
  {
    for(int i=0;i<xLen;i++)
    {
      for(int j=0;j<yLen;j++)
      {
        System.out.print(s[i][j]+" ");
      }System.out.println();
    }
  }
   
}