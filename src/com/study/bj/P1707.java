package com.study.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 이분 그래프
 * https://www.acmicpc.net/problem/1707
 */
public class P1707
{
  static int k;
  static int n,m;
  static ArrayList<Integer>[] graph;
  static int[] v;
  static boolean flag=true;
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    k = scan.nextInt();
    for(int z=0;z<k;z++)
    {
      n = scan.nextInt();m=scan.nextInt();
      graph = new ArrayList[n+1];v = new int[n+1];
      for(int i=0;i<=n;i++){graph[i]=new ArrayList();}
      int x=0,y=0;
      for(int i=0;i<m;i++){x = scan.nextInt();y=scan.nextInt();graph[x].add(y);graph[y].add(x);}

      v[x]=1;
      dfs(x);
      if(flag){System.out.println("Yes");}else{System.out.println("No");}
      flag=true;
    }
  }

  public static void dfs(int x)
  {
    int curColor = v[x];

    for(int i=0;i<graph[x].size();i++)
    {
      int t = graph[x].get(i);//인접노드
      if(v[t]==0)
      {
        if(curColor==1){v[t]=2;dfs(t);}
        else if(curColor==2){v[t]=1;dfs(t);}
      }
      else
      {
        if(curColor==v[t]){flag=false;return;}
      }
    }
  }
}
