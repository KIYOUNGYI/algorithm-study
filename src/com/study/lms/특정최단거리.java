package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class 특정최단거리{
    
    public static int first;public static int second;
    public static int n;public static int m;
    public static ArrayList<Integer>[] graph;public static ArrayList<Integer>[] cost;
    public static boolean[] v1;public static boolean[] v2;
    public static long[] score1;public static long[] score2;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      dijk1();
      dijk2();
      getResult();
      scan.close();
    }
    
    
    public static void getResult()
    {
      // X->first
      long xToOne = score1[1];
      // y->first
      long yToOne = score2[1];
      
      // x<->y
      long xToY = score1[second];
      
      // y-> n
      long yToN = score2[n];
      
      // x-> n
      long xToN = score1[n];
      
      long result = min(xToOne + xToY + yToN,yToOne + xToY + xToN);
      System.out.println(result);
    }
    
    public static long min(long x,long y)
    {
      if(x>y)return y;
      else return x;
    }
    
    public static void dijk1()
    {
      score1[first]=0;
      for(int i=1;i<=n;i++)
      {
        //minIdx 찾고
        
        int minIdx = -1; long minVal = Long.MAX_VALUE;
        for(int j=1;j<=n;j++)
        {
          if(v1[j]==false && minVal>score1[j])
          {
            minVal = score1[j];
            minIdx = j;
          }
        }
        v1[minIdx]=true;//방문 표시
        
        //뻗어나가기
        for(int k=0;k<graph[minIdx].size();k++)
        {
          int node = graph[minIdx].get(k);//인접 노드
          
          if(score1[node] > score1[minIdx]+cost[minIdx].get(k))
          {
            score1[node] = score1[minIdx]+cost[minIdx].get(k);
          }
        }
      }
      // System.out.println("==>"+Arrays.toString(score1));
    }
    
    public static void dijk2()
    {
      score2[second]=0;
      for(int i=1;i<=n;i++)
      {
        //minIdx 찾고
        
        int minIdx = -1; Long minVal = Long.MAX_VALUE;
        for(int j=1;j<=n;j++)
        {
          if(v2[j]==false && minVal>score2[j])
          {
            minVal = score2[j];
            minIdx = j;
          }
        }
        v2[minIdx]=true;//방문 표시
        
        //뻗어나가기
        for(int k=0;k<graph[minIdx].size();k++)
        {
          int node = graph[minIdx].get(k);//인접 노드
          
          if(score2[node] > score2[minIdx]+cost[minIdx].get(k))
          {
            score2[node] = score2[minIdx]+cost[minIdx].get(k);
          }
        }
      }
      // System.out.println("==>"+Arrays.toString(score2));
    }
    
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      cost = new ArrayList[n+1];
      graph = new ArrayList[n+1];
      score1 = new long[n+1];score2 = new long[n+1];
      v1 = new boolean[n+1];v2 = new boolean[n+1];
      
      for(int i=1;i<=n;i++)graph[i]=new ArrayList();for(int i=1;i<=n;i++)cost[i]=new ArrayList();
      for(int i=1;i<=n;i++)score1[i]=Long.MAX_VALUE;for(int i=1;i<=n;i++)score2[i]=Long.MAX_VALUE;
      
      
      for(int i=1;i<=m;i++)
      {
        int a = scan.nextInt();int b = scan.nextInt();int c = scan.nextInt();
        graph[a].add(b);graph[b].add(a);
        cost[a].add(c);cost[b].add(c);
      }
      first = scan.nextInt();second = scan.nextInt();
    }
}