package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class 파티{
    public static int n;public static int m;public static int k;
    public static ArrayList<Integer>[] graph;
    public static ArrayList<Integer>[] reversedGraph;
    public static ArrayList<Integer>[] cost1;
    public static ArrayList<Integer>[] cost2;
    public static boolean[] v1;public static boolean[] v2;
    public static long[] score1;public static long[] score2;
    public static long sum=0;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      dijk1();
      dijk2();
      result();
      scan.close();
    }
    
    public static void result()
    {
      for(int i=0;i<score1.length;i++)
      {
        sum+=score1[i];
      }
      for(int j=0;j<score2.length;j++)
      {
        sum+=score2[j];
      }
      System.out.println(sum);
    }
    
    public static void dijk2()
    {
      score2[k]=0;
      for(int i=1;i<=n;i++)
      {
        int minIdx =-1;long minVal = Long.MAX_VALUE;
        for(int j=1;j<=n;j++)
        {
          if(v2[j]==false && score2[j]<minVal)
          {
            minVal = score2[j];
            minIdx = j;
          }  
        }
        v2[minIdx]=true;
        
        for(int k=0;k<reversedGraph[minIdx].size();k++)
        {
          int x = reversedGraph[minIdx].get(k);//인접노드
          
          if(score2[x]>score2[minIdx]+cost2[minIdx].get(k))
          {
            score2[x]=score2[minIdx]+cost2[minIdx].get(k);
          }
        }
      }
      // System.out.println("->"+Arrays.toString(score2));
    }
    
    
    public static void dijk1()
    {
      score1[k]=0;
      for(int i=1;i<=n;i++)
      {
        int minIdx =-1;long minVal = Long.MAX_VALUE;
        for(int j=1;j<=n;j++)
        {
          if(v1[j]==false && score1[j]<minVal)
          {
            minVal = score1[j];
            minIdx = j;
          }  
        }
        v1[minIdx]=true;
        
        for(int k=0;k<graph[minIdx].size();k++)
        {
          int x = graph[minIdx].get(k);//인접노드
          
          if(score1[x]>score1[minIdx]+cost1[minIdx].get(k))
          {
            score1[x]=score1[minIdx]+cost1[minIdx].get(k);
          }
        }
      }
      // System.out.println("->"+Arrays.toString(score1));
    }
    
    public static void input(Scanner scan)
    {
      n=scan.nextInt();m=scan.nextInt();k=scan.nextInt();
      init();
      for(int i=0;i<m;i++)
      {
        int a = scan.nextInt();int b = scan.nextInt();int c = scan.nextInt();
        graph[a].add(b);
        cost1[a].add(c);
        reversedGraph[b].add(a);
        cost2[b].add(c);
      }
    }
    public static void init()
    {
      graph = new ArrayList[n+1];
      reversedGraph = new ArrayList[n+1];
      cost1 = new ArrayList[n+1];
      cost2 = new ArrayList[n+1];
      for(int i=0;i<=n;i++)
      {
        graph[i] = new ArrayList();
        reversedGraph[i] = new ArrayList();
        cost1[i] = new ArrayList();
        cost2[i] = new ArrayList();
      }
      v1=new boolean[n+1];v2 = new boolean[n+1];
      score1 = new long[n+1];score2 = new long[n+1];
      for(int i=1;i<=n;i++)score1[i]=Long.MAX_VALUE;
      for(int i=1;i<=n;i++)score2[i]=Long.MAX_VALUE;
    }
}