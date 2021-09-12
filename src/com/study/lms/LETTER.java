//package com.study.lms;
//import java.util.Scanner;
//import java.util.*;
//
//public class LETTER{
//    public static int max=0;
//
//    public static int sero,garo;
//    public static int[][] map;
//    public static boolean[][] visit;
//    public static int[] dx = new int[]{0,1,0,-1};
//    public static int[] dy = new int[]{1,0,-1,0};
//    public static void main(String[] args){
//
//      Scanner scan = new Scanner(System.in);
//      input(scan);
//      visit[0][0]=true;
//      dfs(0,0,1);
//      System.out.println(max);
//      scan.close();
//    }
//
//    public static void dfs(int x,int y,int cnt)
//    {
//      if(max<cnt){max=cnt;}
//
//
//      ArrayList<Integer> arrList = new ArrayList();
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          if(visit[i][j]==true)
//          {
//            arrList.add(map[i][j]);
//          }
//        }
//      }
//
//
//      for(int i=0;i<4;i++)
//      {
//        int nx = x+dx[i];
//        int ny = y+dy[i];
//
//        if(nx>=0 && nx<sero && ny>=0 && ny<garo)
//        {
//          if(visit[nx][ny]==false)
//          {
//            if(!arrList.contains(map[nx][ny]))
//            {
//              visit[nx][ny]=true;
//              dfs(nx,ny,cnt+1);
//              visit[nx][ny]=false;
//            }
//          }
//        }
//      }
//    }
//
//
//
//    public static void input(Scanner scan)
//    {
//      sero = scan.nextInt();garo = scan.nextInt();
//      map = new int[sero][garo];visit = new boolean[sero][garo];
//      scan.nextLine();
//      for(int i=0;i<sero;i++)
//      {
//        String x = scan.nextLine();
//        for(int j=0;j<x.length();j++)
//        {
//          map[i][j] = x.charAt(j);
//        }
//      }
//    }
//}
//
//class Point
//{
//  int x;int y;
//  public Point(int x,int y)
//  {
//    this.x = x;this.y=y;
//  }
//}