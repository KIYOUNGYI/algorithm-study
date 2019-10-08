package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기{
    public static ArrayList<Integer> ans = new ArrayList();
    public static int n;
    public static int[][] g;public static boolean[][] v;
    public static int[] dx = new int[]{0,1,0,-1};public static int[] dy = new int[]{1,0,-1,0};
    public static int cnt=0;
    public static void main(String[] args)
    {
      Scanner scan=new Scanner(System.in);
      input(scan);
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          // cnt=0;
          if(v[i][j]==false && g[i][j]==1)
          {
            cnt+=1;
            // System.out.println(i+" "+j);
            v[i][j]=true;
            dfs(i,j);
            ans.add(cnt);
            // System.out.println("cnt:"+cnt);
            // System.out.println("--------");
            cnt=0;
          }
        }
      }
      System.out.println(ans.size());
      Collections.sort(ans);
      for(int i=0;i<ans.size();i++)
      {
        System.out.println(ans.get(i));
      }
      scan.close();
    }
    public static void dfs(int x,int y)
    {
      for(int i=0;i<4;i++)
      {
        int cx = x+dx[i];int cy = y+dy[i];
        if(cx>=0 && cy>=0 && cx<n && cy<n)
        {
          if(v[cx][cy]==false && g[cx][cy]==1)
          {
            cnt+=1;
            // System.out.println(cx+" "+cy);
            v[cx][cy]=true;
            dfs(cx,cy);
            
          }
        }
      }
    }
    
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      g = new int[n][n];v = new boolean[n][n];
      scan.nextLine();
      for(int i=0;i<n;i++)
      {
        String x = scan.nextLine();
        for(int j=0;j<x.length();j++)
        {
          g[i][j] = x.charAt(j)-48;
        } 
      }
      
    }
}