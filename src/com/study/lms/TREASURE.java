//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Queue;
//import java.util.LinkedList;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class TREASURE{
//
//    public static int[] dx = new int[]{0,1,0,-1};
//    public static int[] dy = new int[]{1,0,-1,0};
//    public static int sero,garo;
//    public static int[][] map,score,record;
//    public static boolean[][] visit;
//    public static void main(String[] args){
//      Scanner scan = new Scanner(System.in);
//      input(scan);
//      // printMap();
//      treasure();
//      // printRecord();
//      answer();
//      scan.close();
//    }
//
//    public static void printRecord()
//    {
//     for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          System.out.print(record[i][j]);
//        }System.out.println();
//      }
//    }
//
//    public static void bfs(int a,int b)
//    {
//      Queue<Point> q = new LinkedList();
//      q.add(new Point(a,b));
//      visit[a][b]=true;
//      score[a][b]=0;
//
//      while(!q.isEmpty())
//      {
//        Point pt = q.peek();
//        q.remove();
//        int cx = pt.x;
//        int cy = pt.y;
//        int cScore = score[cx][cy];
//        for(int i=0;i<4;i++)
//        {
//          int nx = cx+dx[i];
//          int ny = cy+dy[i];
//
//          if(nx>=0 && nx<sero && ny>=0 && ny<garo)
//          {
//            if(visit[nx][ny]==false && map[nx][ny]==1)
//            {
//              visit[nx][ny]=true;
//              score[nx][ny]=cScore+1;
//              q.add(new Point(nx,ny));
//            }
//          }
//        }
//
//      }
//    }
//
//    public static void treasure()
//    {
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          if(map[i][j]!=0)
//          {
//            bfs(i,j);
//
//            int x =findMaxAndRecord();
//            // System.out.println(i+" "+j+" "+x);
//            record[i][j]=x;
//            initScoreAndVisit();
//            //최대값 찾아서 record 에 기록
//            //score 초기화
//          }
//        }
//      }
//
//
//    }
//
//    public static void answer()
//    {
//      int max=0;
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          if(max<record[i][j])
//          {
//            max = record[i][j];
//          }
//        }
//      }
//      System.out.println(max);
//    }
//
//
//    public static void initScoreAndVisit()
//    {
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          score[i][j]=0;
//          visit[i][j]=false;
//        }
//      }
//    }
//
//    public static int findMaxAndRecord()
//    {
//      int max=0;
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          if(max<score[i][j])
//          {
//            max = score[i][j];
//          }
//        }
//      }
//      return max;
//    }
//
//    public static void input(Scanner scan)
//    {
//      sero = scan.nextInt();garo = scan.nextInt();
//      map = new int[sero][garo];score= new int[sero][garo];record= new int[sero][garo];
//      visit = new boolean[sero][garo];
//      scan.nextLine();
//      for(int i=0;i<sero;i++)
//      {
//        String x = scan.nextLine();
//
//        for(int j=0;j<x.length();j++)
//        {
//          if(x.charAt(j)=='L')
//          {
//            map[i][j]=1;
//          }
//          else
//          {
//            map[i][j]=0;
//          }
//        }
//      }
//    }
//
//  public static void printMap()
//  {
//    for(int i=0;i<sero;i++)
//    {
//      for(int j=0;j<garo;j++)
//      {
//        System.out.print(map[i][j]+" ");
//      }System.out.println();
//    }
//  }
//
//
//}
//
//class Point
//{
//  int x;
//  int y;
//  public Point(int x,int y)
//  {
//    this.x=x;this.y=y;
//  }
//}