//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Queue;
//import java.util.LinkedList;
//
//public class 미로찾기{
//    public static int[] dx = new int[]{0,1,0,-1};public static int[] dy = new int[]{1,0,-1,0};
//    public static int sero;public static int garo;
//    public static int[][] a;public static int[][] s;public static boolean[][] v;
//    public static void main(String[] args){
//
//      Scanner scan = new Scanner(System.in);
//      input(scan);
//      bfs();
//      System.out.println(s[0][garo-1]);
//    }
//
//    public static void bfs()
//    {
//      //if(a[sero-1][0]==1 || a[0][garo-1]==1){System.out.println(0);return;}
//      Queue<Point> q = new LinkedList();
//      q.add(new Point(sero-1,0));
//      v[sero-1][0]=true;
//      s[sero-1][0]=0;
//
//      while(!q.isEmpty())
//      {
//        Point cpt = q.peek();
//        q.remove();
//        int cx = cpt.x;
//        int cy = cpt.y;
//        for(int i=0;i<4;i++)
//        {
//          int tx = cx+dx[i];
//          int ty = cy+dy[i];
//          if(tx>=0 && ty>=0 && tx<sero && ty<garo)
//          {
//            if(a[tx][ty]==0 && v[tx][ty]==false)
//            {
//              v[tx][ty]=true;
//              s[tx][ty]=s[cx][cy]+1;
//              q.add(new Point(tx,ty));
//            }
//          }
//          if(tx==0 && ty== garo-1){return;}
//        }
//      }
//
//    }
//
//    public static void input(Scanner scan)
//    {
//      sero = scan.nextInt(); garo = scan.nextInt();
//      a = new int[sero][garo]; s = new int[sero][garo]; v = new boolean[sero][garo];
//      for(int i=0;i<sero;i++)
//      {
//        for(int j=0;j<garo;j++)
//        {
//          a[i][j]=scan.nextInt();
//        }
//      }
//    }
//}
////class Point
////{
////  int x;int y;
////  public Point(int x,int y)
////  {
////    this.x = x;
////    this.y = y;
////  }
////}