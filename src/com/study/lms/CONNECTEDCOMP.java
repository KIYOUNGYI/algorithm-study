package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;

public class CONNECTEDCOMP{
    public static int cnt=0;
    public static int v,e;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visit;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
     
      for(int i=1;i<=v;i++)
      {
        if(!visit[i]){
         visit[i]=true;
         dfs(i);
         cnt+=1;
        }
      }
     
      System.out.println(cnt);
      scan.close();
    }
    
    public static void dfs(int x)
    {
      for(int i=0;i<graph[x].size();i++)
      {
        int t = graph[x].get(i);
        if(!visit[t])
        {
          visit[t]=true;
          dfs(t);
        }
      }
    }
    
    public static void input(Scanner scan)
    {
      v = scan.nextInt();e=scan.nextInt();
      graph = new ArrayList[v+1];visit = new boolean[v+1];
      for(int i=0;i<=v;i++){graph[i]=new ArrayList();}
      
      for(int i=1;i<=e;i++)
      {
        int a = scan.nextInt();int b = scan.nextInt();
        graph[a].add(b);graph[b].add(a);
      }
    }
}