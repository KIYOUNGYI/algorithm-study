package com.study.bj;

import java.util.Arrays;
import java.util.Scanner;

public class P14501
{
  static int n;
  static int[] t;
  static int[] p;
  static boolean[] visit;
  static int[] mark;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    t = new int[n+1];
    p = new int[n+1];
    mark = new int[n+1];
    visit = new boolean[n+1];
    for(int i=1;i<=n;i++)
    {
      t[i]=scan.nextInt();
      p[i]=scan.nextInt();
    }
    System.out.println(Arrays.toString(t));
    System.out.println(Arrays.toString(p));
    recursive(1);
  }
  public static void recursive(int depth)
  {
    if(depth==n)
    {
      System.out.println(Arrays.toString(mark));
      System.out.println(Arrays.toString(visit));
      return;
    }

    for(int i=1;i<visit.length;i++)
    {
      if(!visit[i])
      {
        mark[depth]=i;
        visit[i]=true;
        int val = t[i];
        if(i+val>n)return;
        for(int j=i;j<i+val;j++)
        {
          visit[j]=true;
        }
//        System.out.println(Arrays.toString(visit));
        recursive(depth+1);
        for(int j=i;j<i+val;j++)
        {
          visit[j]=false;
        }
      }
    }
  }
}
