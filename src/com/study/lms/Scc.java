package com.study.lms;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Scc
{
    public static int n;public static int m;
    public static ArrayList<Integer>[] graph;
    public static ArrayList<Integer>[] reversedGraph;
    public static int[] order;public static int[] time;
    public static boolean[] v1;public static boolean[] v2;
    public static int groupCnt=0;
    public static int orderCnt=0;
    public static int timeCnt=0;
    public static int[] group;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
      scc();
      System.out.println(groupCnt);
      scan.close();
    }
    
    public static void getTime(int node)
    {
      v1[node]=true;
      for(int i=0;i<graph[node].size();i++)
      {
        int node2 = graph[node].get(i);
        if(!v1[node2])
        {
          getTime(node2);
        }
      }
      orderCnt+=1;
      order[orderCnt]=node;
    }
    
    public static void scc()
    {
      //[1] 빠져나오는 시간기록 (dfs)
      for(int i=1;i<=n;i++)
      {
        if(!v1[i]){
          getTime(i);
        }
      }
      // System.out.println("------ order ------");
      // for(int i=1;i<=n;i++)
      //   System.out.println(i+" "+order[i]);
      //[2] 거꾸로 dfs 돌면서 그룹 세기(dfs 끝나는 시점이 카운트 늘리는 시점)
      
      for(int i=orderCnt;i>=1;i--)
      {
        int node = order[i];
        if(!v2[node])
        {
          getGroup(node);
          groupCnt+=1;
        }
      }
      
      // System.out.println("groupCnt:"+groupCnt);
      // System.out.println("------group----");
      // for(int i=1;i<=n;i++)
      //   System.out.println(i+" "+group[i]);
    }
    
    public static void getGroup(int x)
    {
      v2[x]=true;
      group[x]=groupCnt+1;
      
      for(int i=0;i<reversedGraph[x].size();i++)
      {
        int t = reversedGraph[x].get(i);
        if(!v2[t])
        {
          getGroup(t);
        }
      }
    }
        
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      init();
      for(int i=0;i<m;i++)
      {
        int a = scan.nextInt();int b = scan.nextInt();
        graph[a].add(b);reversedGraph[b].add(a);
      }
    }
    public static void init()
    {
      graph = new ArrayList[n+1];reversedGraph = new ArrayList[n+1];
      order = new int[n+1];time = new int[n+1];
      v1 = new boolean[n+1];v2 = new boolean[n+1];
      for(int i=0;i<=n;i++)
      {
        graph[i]=new ArrayList();
        reversedGraph[i]=new ArrayList();
      }
      group = new int[n+1];
    }
}