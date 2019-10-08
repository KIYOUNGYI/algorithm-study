package com.study.lms;

import java.util.Scanner;

public class 자원채취 {
  public static int n;
  public static int m;
  public static long[][] a;
  public static long[][] s;
	public static void main(String[] args)
	{
	  Scanner scan = new Scanner(System.in);
	  input(scan);
    init();	 
    collectMineral();
	  scan.close();
	}
	public static long max(long a,long b)
	{
	  if(a>=b)return a;
	  else return b;
	}
	
	public static void collectMineral()
	{
    for(int i=1;i<n;i++)
    {
      for(int j=1;j<m;j++)
      {
        s[i][j]=max(s[i][j-1],s[i-1][j])+a[i][j];
      }
    }
    System.out.println(s[n-1][m-1]);
	}
	
	public static void init()
	{
	  s[0][0]=a[0][0];
	  for(int i=1;i<m;i++)
	  {
	    s[0][i]=s[0][i-1]+a[0][i];
	  }
	  
	  for(int j=1;j<n;j++)
	  {
	    s[j][0]=a[j][0]+s[j-1][0];
	  }
	}
	
	public static void input(Scanner scan)
	{
	  n = scan.nextInt();m = scan.nextInt();
	  a = new long[n][m];s = new long[n][m];
	  for(int i=0;i<n;i++)
	  {
	    for(int j=0;j<m;j++)
	    {
	      a[i][j] = scan.nextLong();
	    }
	  }
	}
}
