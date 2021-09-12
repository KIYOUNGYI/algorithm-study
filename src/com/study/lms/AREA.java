//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.*;
//public class AREA{
//    public static ArrayList<Integer> answer = new ArrayList();
//    public static int score=0;
//    public static int[] dx = new int[]{0,1,0,-1};
//    public static int[] dy = new int[]{1,0,-1,0};
//    public static int sero,garo,distriction;
//    public static int[][] map;
//    public static boolean[][] visit;
//    public static void main(String[] args){
//
//       // Please Enter Your Code Here
//      Scanner scan = new Scanner(System.in);
//      input(scan);
//      area();
//      scan.close();
//    }
//
//    public static void bfs(int x,int y)
//    {
//      score=0;
//      Queue<Point> q = new LinkedList();
//      q.add(new Point(x,y));
//      visit[x][y]=true;
//
//      while(!q.isEmpty())
//      {
//        Point pt = q.peek();
//        score+=1;
//        q.remove();
//        int cx = pt.x;
//        int cy = pt.y;
//
//        for(int i=0;i<4;i++)
//        {
//          int nx = cx+dx[i];
//          int ny = cy+dy[i];
//
//          if(nx>=0 && ny>=0 && nx<sero && ny<garo)
//          {
//            if(visit[nx][ny]==false && map[nx][ny]==0)
//            {
//              visit[nx][ny]=true;
//              q.add(new Point(nx,ny));
//
//            }
//          }
//        }
//
//      }
//       answer.add(score);
//    }
//
//    public static void area()
//    {
//      int dCnt=0;
//      // printMap();
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          if(map[i][j]!=1 && visit[i][j]==false)
//          {
//            // visit[i][j]=true;
//            bfs(i,j);
//            dCnt++;
//          }
//        }
//      }
//
//      Collections.sort(answer);
//      System.out.println(dCnt);
//      for(int i=0;i<answer.size();i++)
//      {
//        System.out.print(answer.get(i)+" ");
//      }System.out.println();
//    }
//
//    public static void printMap()
//    {
//        for(int i=0;i<sero;i++)
//        {
//          for(int j=0;j<garo;j++)
//          {
//            System.out.print(map[i][j]+" ");
//          }System.out.println();
//        }
//    }
//
//    public static void input(Scanner scan)
//    {
//      sero = scan.nextInt();garo=scan.nextInt();distriction=scan.nextInt();
//      map = new int[sero][garo]; visit = new boolean[sero][garo];
//
//      for(int i=0;i<distriction;i++)
//      {
//        int a = scan.nextInt();int b = scan.nextInt();int c = scan.nextInt();int d = scan.nextInt();
//        for(int j=b;j<d;j++)
//        {
//          for(int k=a;k<c;k++)
//          {
//            map[j][k]=1;
//          }
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
//    this.x = x;this.y =y;
//  }
//}