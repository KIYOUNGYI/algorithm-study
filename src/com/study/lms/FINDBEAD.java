package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class FINDBEAD{
    public static int n;
    public static int m;
    public static ArrayList<Integer>[] graph;
    public static ArrayList<Integer>[] reversedGraph;
    public static boolean[] v;
    public static int[] score1;
    public static int[] score2;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      for(int i=1;i<=n;i++)
      {
        // System.out.println("i:"+i+"일 때");
        dfs1(i);
        initV();
      }
     
      
      for(int j=1;j<=n;j++)
      {
        dfs2(j);
        initV();
      }
      // System.out.println(Arrays.toString(score1));
      // System.out.println(Arrays.toString(score2));
      
      int cnt=0;
      for(int i=1;i<=n;i++)
      {
        if ((n+1)/2<=score1[i])
        {
          cnt+=1;
        }
        if((n+1)/2 <=score2[i] )
        {
          cnt+=1;
        }
      }
      System.out.println(cnt);
            
      scan.close();
    }
    
    public static void dfs2(int x)
    {
        for(int i=0;i<reversedGraph[x].size();i++)
        {
          int t = reversedGraph[x].get(i);
          // System.out.println("t:"+t);
          if(!v[t])
          {
              score2[t]+=1;
              dfs2(t);
          }
        }
    }
    
    public static void dfs1(int x)
    {
        for(int i=0;i<graph[x].size();i++)
        {
          int t = graph[x].get(i);
          // System.out.println("t:"+t);
          if(!v[t])
          {
              v[t]=true;
              score1[t]+=1;
              dfs1(t);
          }
        }
    }
    
     public static void initV()
    {
      for(int i=0;i<=n;i++)v[i]=false;
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      graph = new ArrayList[n+1];reversedGraph=new ArrayList[n+1];
      v = new boolean[n+1];score1=new int[n+1];score2=new int[n+1];
      for(int i=0;i<=n;i++)graph[i]=new ArrayList();
      for(int i=0;i<=n;i++)reversedGraph[i]=new ArrayList();
      for(int i=0;i<m;i++)
      {
        int x = scan.nextInt();
        int y= scan.nextInt();
        graph[x].add(y);
        reversedGraph[y].add(x);
      }
    }
    
}
