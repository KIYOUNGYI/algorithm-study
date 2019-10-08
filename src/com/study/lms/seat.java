package com.study.lms;

import java.util.Scanner;
public class seat{
    
    public static int sero,garo,target;
    public static int[][] map;
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
      init();
      // print();
      seat();
      // print();
      answer();
      
      scan.close();
    }
    public static void answer()
    {
      if(sero*garo<target){System.out.println(0);return;}
      
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++)
        {
          if(map[i][j]==target)
          {
            System.out.println(i+" "+j);return;
          }
        }
      }
      
    }
    
    public static void seat()
    {
      int v=1;int x=1;int y=1;int idx=0;
      map[x][y]=v;
      
      while(true)
      {
        int orgx = x;int orgy = y;
        x = x+dx[idx];
        y = y+dy[idx];
        if(v==sero*garo)break;        
        if(map[x][y]==0)
        {
          // System.out.println(x+" "+y);
          map[x][y]=++v;
        }
        else
        {
          idx = (idx+1)%4;
          x = orgx;y = orgy;
        }
      }
    }
    
    public static void init()
    {
      for(int i=0;i<sero+2;i++)
      {
        map[i][0]=-1;map[i][garo+1]=-1;
      }
      for(int i=0;i<garo+2;i++)
      {
        map[0][i]=-1;map[sero+1][i]=-1;
      }
    }
    public static void input(Scanner scan)
    {
      sero = scan.nextInt();garo = scan.nextInt();
      target = scan.nextInt();
      map = new int[sero+2][garo+2];
    }
    public static void print()
    {
      for(int i=0;i<sero+2;i++)
      {
        for(int j=0;j<garo+2;j++)
        {
          System.out.print(map[i][j]+" ");
        }System.out.println();
      }
    }
  
}