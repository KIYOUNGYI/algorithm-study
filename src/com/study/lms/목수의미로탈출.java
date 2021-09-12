//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Queue;
//import java.util.LinkedList;
//
//public class 목수의미로탈출
//{
//  public static int[] dx = new int[]{0,-1,0,1};
//  public static int[] dy = new int[]{1,0,-1,0};
//
//  // public static int[] dx =new int[]{0,1,0,-1};
//  // public static int[] dy = new int[]{1,0,-1,0};
//  public static int n;public static int m;
//  public static boolean[][] v1;public static boolean[][] v2;public static int[][] a;public static int[][] s1;public static int[][] s2;
//  public static void main(String[] args)
//  {
//    Scanner scan = new Scanner(System.in);
//    input(scan);
//    bfs();
//    printResult();
//    scan.close();
//  }
//
//  public static void printResult()
//  {
//
//    if(s1[0][m-1]==0 && s2[0][m-1]==0){System.out.println(0);return;}
//    if(s1[0][m-1]!=0 && s2[0][m-1]==0){System.out.println(s1[0][m-1]);return;}
//    if(s1[0][m-1]==0 && s2[0][m-1]!=0){System.out.println(s2[0][m-1]);return;}
//    if(s1[0][m-1]>=s2[0][m-1]){System.out.println(s2[0][m-1]);return;}
//    if(s1[0][m-1]<s2[0][m-1]){System.out.println(s1[0][m-1]);return;}
//
//    return;
//  }
//
//  public static void bfs()
//  {
//    //if(a[n-1][0]==1 || a[0][m-1]==1){System.out.println(0);return;}
//    Queue<Point> q = new LinkedList();
//    q.add(new Point(n-1,0,false));
//    v1[n-1][0]=true;
//    s1[n-1][0]=0;
//
//    while(!q.isEmpty())
//    {
//      Point p = q.peek();q.remove();
//      int cx = p.x;int cy = p.y;boolean ax = p.axUsed;
//      for(int i=0;i<4;i++)
//      {
//        int tx = cx+dx[i];int ty=cy+dy[i];
//        if(tx>=0 && ty>=0 && tx<n && ty<m)
//        {
//          if(ax==false && v1[tx][ty]==false && a[tx][ty]==0)
//          {
//            q.add(new Point(tx,ty,false));v1[tx][ty]=true;s1[tx][ty]=s1[cx][cy]+1;
//          }
//          if(ax==false && v1[tx][ty]==false && a[tx][ty]==1)
//          {
//            q.add(new Point(tx,ty,true));v2[tx][ty]=true;s2[tx][ty]=s1[cx][cy]+1;
//          }
//          if(ax==true && v2[tx][ty]==false && a[tx][ty]==0)
//          {
//            q.add(new Point(tx,ty,true));v2[tx][ty]=true;s2[tx][ty]=s2[cx][cy]+1;
//          }
//        }
//
//      }
//    }
//
//  }
//
//  public static void input(Scanner scan)
//  {
//    n = scan.nextInt();m = scan.nextInt();a = new int[n][m];s1=new int[n][m];s2=new int[n][m];v1=new boolean[n][m];v2=new boolean[n][m];
//    for(int i=0;i<n;i++){for(int j=0;j<m;j++)a[i][j]=scan.nextInt();}
//  }
//}
//
//class Point
//{
//  int x;int y;boolean axUsed;
//  public Point(int x,int y,boolean axUsed)
//  {this.x = x;this.y= y;this.axUsed = axUsed;}
//}
