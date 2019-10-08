package com.study.lms;

import java.util.Scanner;
public class 숫자만들기{
    public static int[] d;
    public static int n;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      if(n<=3)
      {
        if(n==1){System.out.println(1);return;}
        if(n==2){System.out.println(2);return;}
        if(n==3){System.out.println(4);return;}
      }
      d = new int[n+1];
      d[1]=1;d[2]=2;d[3]=4;
      
      for(int i=4;i<=n;i++)
      {
        d[i] = (d[i-1]+d[i-2]+d[i-3])%1000007;
      }
      System.out.println(d[n]);
      scan.close();
    }
}