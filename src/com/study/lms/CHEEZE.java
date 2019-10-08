package com.study.lms;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class CHEEZE{
  public static int cnt=0;
  public static int t=0;
  public static boolean[][] visit;
  public static int[][] map;
  public static int sero,garo;
  public static int[] dx = new int[]{0,1,0,-1};
  public static int[] dy = new int[]{1,0,-1,0};
  public static void main(String[] args)
  {
    Scanner scan  = new Scanner(System.in);
    input(scan);
    cheeze();
    scan.close();
  }
  
  public static void cheeze()
  {
    for(int time=1;time<10000;time++){
      
      cnt=cheezeLeft();
      // System.out.println("cheezLeft:"+cnt);
     
      visit[0][0]=true;
      dfs(0,0);
      fixMap();
      
      int temp=0;
      if(cheezeLeft()==0){t=time;break;}
    }
    // System.out.println("time:"+t);
    // System.out.println("cnt:"+cnt);
    System.out.println(t);
    System.out.println(cnt);
  }
  
  public static void fixMap()
  {
      for(int i=0;i<sero;i++)
    {
      for(int j=0;j<garo;j++)
      {
        if(map[i][j]==0 && visit[i][j]==true){visit[i][j]=false;}
      }
    }
  }
  
  public static void printMap()
  {
    for(int i=0;i<sero;i++)
    {
      for(int j=0;j<garo;j++)
      {
        System.out.print(map[i][j]+" ");
      }System.out.println();
    }
  }
    
  public static void dfs(int a,int b)
  {
    for(int i=0;i<4;i++)
    {
      int nx = a+dx[i];
      int ny = b+dy[i];
      
      if(nx>=0 && ny>=0 && nx<sero && ny<garo)
      {
        if(map[nx][ny]==1)
        {
          map[nx][ny]=0;visit[nx][ny]=true;
        }
      }
    }
    
    for(int i=0;i<4;i++)
    {
      int nx = a+dx[i];
      int ny = b+dy[i];
      if(nx>=0 && ny>=0 && nx<sero && ny<garo)
      {
        if(map[nx][ny]==0 && visit[nx][ny]==false)
        {
          visit[nx][ny]=true;
          dfs(nx,ny);
        }
      }
    }
    
    
  }
  
  
  public static int cheezeLeft()
  {
    int cnt=0;
    for(int i=0;i<sero;i++)
    {
      for(int j=0;j<garo;j++)
      {
        if(map[i][j]==1){cnt+=1;}
      }
    }
    return cnt;
  }
  
  public static void input(Scanner scan)
  {
    sero = scan.nextInt();garo = scan.nextInt();
    map = new int[sero][garo]; visit = new boolean[sero][garo];
    for(int i=0;i<sero;i++)
    {
      for(int j=0;j<garo;j++)
      {
        map[i][j] = scan.nextInt();
      }
    }
  }
}

class Point
{
  int x;
  int y;
  public Point(int x,int y)
  {
    this.x = x;
    this.y = y;
  }
}
