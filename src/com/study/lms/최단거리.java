package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
public class 최단거리{
    //입력 정점개수:n, 간선개수 m
    //g[n](인접리스트),v[n](방문여부),t[n](n까지 오는 최단 거리)
    //for(i 0~m) 인접리스트 입력
    //start,end 입력
    //for(i 0~n)t[i]=무한
    //dijk()
    //t[start]=0;
    //for(i 0~n)
    //  minIdx=-1,minVal=무한
    //  for(j 0~n)
    //    최소 인덱스 찾기 (방문 안한것 중)
    //  v[minIdx]=true (방문체크)
    //for(i=0;i<g[minIdx].size();i++)
    //  x = g[minIdx].get(i)
    //  t[x] > t[minIdx]+1(가중치)
    //      t[x]=t[minIdx]+1;
    // dijk 끝나면 t[end]출력
    public static int n;public static int m;public static int start;public static int end;
    public static ArrayList<Integer>[] g;public static boolean[] v;public static int[] t;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      dijk();
      scan.close();
    }
    public static void dijk()
    {
      t[start]=0;
      for(int i=0;i<n;i++)
      {
        int minIdx=-1;int minVal = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
          if(v[j]==false && t[j]<minVal)
          {
            minVal= t[j];
            minIdx = j;
          }
        }
        // System.out.println("minIdx:"+minIdx);
        v[minIdx]=true;
        for(int k=0;k<g[minIdx].size();k++)
        {
           int node = g[minIdx].get(k);
           if(t[node]>t[minIdx]+1)
           {
             t[node]=t[minIdx]+1;
           }
        }
      }
      System.out.println(t[end]);
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      g=new ArrayList[n];v=new boolean[n];t=new int[n];
      for(int i=0;i<n;i++)g[i]=new ArrayList();
      for(int i=0;i<n;i++)t[i]=Integer.MAX_VALUE;
      for(int i=0;i<m;i++)
      {
        int x = scan.nextInt();int y = scan.nextInt();
        g[x].add(y);g[y].add(x);
      }
      // for(int i=0;i<n;i++)
      // {
      //   System.out.println(g[i].toString());
      // }
      start = scan.nextInt();end = scan.nextInt();
      // System.out.println("start:"+start);
      // System.out.println("end:"+end);
    }
}