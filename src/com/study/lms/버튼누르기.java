package com.study.lms;

import java.util.Scanner;
public class 버튼누르기{
    public static int n;
    public static long[][] a;
    public static long[][] s;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      
      input(scan);
      init();
      if(n==1){}
      else{
        for(int i=1;i<=n-1;i++)
        {
          for(int j=0;j<=2;j++)
          {
            if(j==0)
            {
              long x = big(s[i-1][1],s[i-1][2]);
              s[i][0]=a[i][0]+x;
            }
            else if(j==1)
            {
              long x = big(s[i-1][0],s[i-1][2]);
              s[i][1]=a[i][1]+x;
            }
            else if(j==2)
            {
              long x = big(s[i-1][0],s[i-1][1]);
              s[i][2]=a[i][2]+x;
            }
          }
        }
      }
      // System.out.println(s[n-1][0]+" "+s[n-1][1]+" "+s[n-1][2]);
      long result = bigbig(s[n-1][0],s[n-1][1],s[n-1][2]);
      System.out.println(result);
      
      scan.close();
    }
    
    public static long bigbig(long a,long b,long c)
    {
      if(a>=b && a>=c)return a;
      if(b>=a && b>=c)return b;
      if(c>=a && c>=b)return c;
      
      return -1;
    }
    
    public static long big(long a,long b)
    {
      if(a>b)return a;
      else return b;
    }
    
    public static void init()
    {
      s[0][0]=a[0][0];s[0][1]=a[0][1];s[0][2]=a[0][2];
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      a = new long[n][3];
      s = new long[n][3];
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<=2;j++)
        {
          a[i][j]=scan.nextLong();
        }
      }
    }
}