package com.study.lms;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class 깊이우선탐색너비우선탐색{
   
    public static int n;
    public static int m;
    public static ArrayList<Integer>[] a;
    public static boolean[] v;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
      v[0]=true;
      dfs(0);
      System.out.println();
      initV();
      bfs(0);
      scan.close();
    }
    
    
    public static void bfs(int x)
    {
      Queue<Integer> q = new LinkedList();
      q.add(x);
      v[x]=true;
      
      while(!q.isEmpty())
      {
        int t = q.peek();
        q.remove();
      
         System.out.print(t+" ");
        for(int i=0;i<a[t].size();i++)
        {
          int y = a[t].get(i);
          if(!v[y])
          {
            v[y]=true;
            q.add(y);
          }
        } 
      }
    }
    
    public static void initV()
    {
      for(int i=0;i<n;i++)v[i]=false;
    }
    
    public static void dfs(int x)
    {
      System.out.print(x+" ");
      for(int i=0;i<a[x].size();i++)
      {
        int t = a[x].get(i);
        if(!v[t])
        {
          v[t]=true;
          dfs(t);
        }
      } 
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      a = new ArrayList[n];v = new boolean[n];
      for(int i=0;i<n;i++)a[i]=new ArrayList();
      for(int i=0;i<m;i++)
      {
        int x = scan.nextInt();int y = scan.nextInt();
        a[x].add(y);a[y].add(x);
      }
      for(int i=0;i<n;i++){Collections.sort(a[i]);}
    }
  
}