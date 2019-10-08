package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 주사위게임{
  public static int n;
  public static int[][] a;
  public static int[] score;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    a = new int[n+1][7];
    score = new int[n+1];
    
    for(int i=1;i<=n;i++)
    {
      int x = scan.nextInt();
      int y = scan.nextInt();
      int z = scan.nextInt();
      a[i][x]+=1;
      a[i][y]+=1;
      a[i][z]+=1;
      
      int cnt=0;
      int nun=0;
      for(int j=1;j<=6;j++)
      {
        if(a[i][j]==3)
        {
          cnt=3;
          nun = j;
          break;
        }
        if(a[i][j]==2)
        {
          cnt=2;
          nun = j;
          break;
        }
        if(a[i][j]==1)
        {
          cnt=1;
          nun = j;
        }
      }     
      
      if(cnt==3)
      {
        score[i]=10000+1000*nun;
      }
      else if(cnt==2)
      {
        score[i]=1000+100*nun;
      }
      else if(cnt==1)
      {
        score[i]=100*nun;
      }
    }
    int max=0;
    for(int i=1;i<=n;i++)
    {
      if(max<=score[i])
      {
        max = score[i];
      }
    }
    System.out.println(max);
    
    scan.close();
  }
}