package com.study.bj;

import java.util.Scanner;

/**
 * 시간초과
 */
public class P3085
{
  static int cnt2=0;
  static int cnt1=0;
  static int MAX=Integer.MIN_VALUE;
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};

  static int[] seroMove1 = {0,0};
  static int[] seroMove2 = {1,-1};

  static int[] garoMove1 = {1,-1};
  static int[] garoMove2 = {0,0};

  static int N;
  static char[][] arr;
  static char[][] backup;
  static boolean[][] visit;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new char[N][N];
    backup = new char[N][N];
    visit = new boolean[N][N];

    scan.nextLine();
    for(int i=0;i<N;i++)
    {
      String temp = scan.nextLine();
      for(int j=0;j<N;j++)
      {
        arr[i][j] = temp.charAt(j);
        backup[i][j]=arr[i][j];
      }
    }

    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
        swap_calculate_restore(i,j);
      }
    }
    System.out.println(MAX);
    scan.close();
  }



  public static int max(int x,int y)
  {
    if(x>=y)return x;
    else return y;
  }
  private static void restore()
  {
    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++) { arr[i][j]=backup[i][j]; }
    }
  }

  public static void swap_calculate_restore(int i,int j)
  {
    char temp1 = arr[i][j];
    for(int a=0;a<4;a++)
    {
      int tx = i+dx[a];
      int ty = j+dy[a];
      if(tx>=0 && tx<N && ty>=0 && ty<N)
      {
        char temp2 = arr[tx][ty];
        arr[tx][ty]=temp1;
        arr[i][j]  =temp2;
      }
//      printArr();
      // calculate();
      restore();
    }
  }
  public static void printArr()
  {
    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
  public static void initV()
  {
    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
        visit[i][j]=false;
      }
    }
  }

}
