package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class 이색칠하기{
    public static int n;
    public static int m;
    public static ArrayList<Integer>[] g;
    public static int[] v;
    public static boolean flag=true;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
      v[0]=1;
      dfs(0);
      if(!flag){System.out.println("NO");}
      else{System.out.println("YES");}
      scan.close();
    }
    
    public static void dfs(int x)
    {
      int curCor = v[x];
      for(int i=0;i<g[x].size();i++)
      {
        int cNode = g[x].get(i);
        
        if(v[cNode]==0)
        {
          if(curCor==1)
          {
            v[cNode]=2;
            dfs(cNode);
          }
          else if(curCor==2)
          {
            v[cNode]=1;
            dfs(cNode);
          }
        }
        else
        {
          if(v[cNode]==curCor)
          {
            flag = false;
            return;
          }
        }
        
      }
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();m = scan.nextInt();
      g = new ArrayList[n];v = new int[n];
      for(int i=0;i<n;i++)g[i]=new ArrayList();
      for(int i=0;i<m;i++)
      {
        int x = scan.nextInt();int y = scan.nextInt();
        g[x].add(y);g[y].add(x);
      }
      
    }
}