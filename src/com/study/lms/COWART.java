package com.study.lms;
import java.util.Scanner;
public class COWART{
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int n;
    public static int[][] a;
    public static boolean[][] visit;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      // System.out.println((int)'R');//82
      // System.out.println((int)'G');//71
      // System.out.println((int)'B');//66
      cowart();
      
      
      scan.close();
    }
    
    public static void cowart()
    {
      int cnt1=0;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(visit[i][j]==false)
          {
            visit[i][j]=true;
            dfs1(i,j,a[i][j]);
            cnt1+=1;
          }
        }
      }
      visit = new boolean[n][n];
      int cnt2=0;
     
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(visit[i][j]==false)
          {
            visit[i][j]=true;
            dfs2(i,j,a[i][j]);
            cnt2+=1;
          }
        }
      }
      System.out.println(cnt1+" "+cnt2);
    }
    
    
     public static void dfs2(int x,int y,int v)
    {
      for(int i=0;i<4;i++)
      {
        int cx = x+dx[i];
        int cy = y+dy[i];
        
        if(cx>=0 && cx<n && cy>=0 && cy<n)
        {
          if(visit[cx][cy]==false)
          {
            if(a[cx][cy]==71 && v==82)
            {
              visit[cx][cy]=true;
              dfs2(cx,cy,71);
            }
            else if(a[cx][cy]==82 && v==71)
            {
              visit[cx][cy]=true;
              dfs2(cx,cy,82);
            }
            else if(a[cx][cy]==v)
            {
              visit[cx][cy]=true;
              dfs2(cx,cy,v);
            }
          }
        }
        
      }
    }
    
    public static void dfs1(int x,int y,int v)
    {
      for(int i=0;i<4;i++)
      {
        int cx = x+dx[i];
        int cy = y+dy[i];
        
        if(cx>=0 && cx<n && cy>=0 && cy<n)
        {
          if(visit[cx][cy]==false)
          {
            if(a[cx][cy]==v)
            {
              visit[cx][cy]=true;
              dfs1(cx,cy,v);
            }
          }
        }
      }
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      a = new int[n][n];visit = new boolean[n][n];
      scan.nextLine();
      for(int i=0;i<n;i++)
      {
        String x = scan.nextLine();
        for(int j=0;j<x.length();j++)
        {
          a[i][j]=x.charAt(j);
        }
      }
    }
}