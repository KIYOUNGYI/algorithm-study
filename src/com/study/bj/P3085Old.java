package com.study.bj;

import java.util.Scanner;

public class P3085Old
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
        backup[i][j]=arr[i][j]; }
    }

    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
        swap_calculate_restore(i,j);
      }
    }
//    System.out.println("answer:"+MAX);
    System.out.println(MAX);
    scan.close();
  }
  public static void calculate()
  {
//    System.out.println("----calcualte------");
    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
//        System.out.println("[i:"+i+" j:"+j+"]");

        visit[i][j]=true;
        cnt1=1;
        dfs1(i,j);
        initV();
        visit[i][j]=true;
        cnt2=1;
        dfs2(i,j);
        int t = max(cnt1,cnt2);
        if(t>MAX)MAX=t;
      }
    }
  }


  public static void dfs1(int i,int j)
  {
    char pivot = arr[i][j];

    for(int a=0;a<2;a++)
    {
      int tx = i + seroMove1[a];
      int ty = j + seroMove2[a];
      if(tx>=0 && tx<N && ty>=0 && ty<N)
      {
        if(!visit[tx][ty] && pivot==arr[tx][ty])
        {

          cnt1+=1;
//          System.out.println("tx:"+tx+" ty:"+ty+" cnt1:"+cnt1);
          visit[tx][ty]=true;
          dfs1(tx,ty);
        }
      }
    }
  }

  public static void dfs2(int i,int j)
  {
    char pivot = arr[i][j];

    for(int a=0;a<2;a++)
    {
      int tx = i + garoMove1[a];
      int ty = j + garoMove2[a];
      if(tx>=0 && tx<N && ty>=0 && ty<N)
      {
        if(!visit[tx][ty] && pivot==arr[tx][ty])
        {
          cnt2+=1;
//          System.out.println("tx:"+tx+" ty:"+ty+" cnt2:"+cnt2);
          visit[tx][ty]=true;
          dfs2(tx,ty);
        }
      }
    }
  }


  public static int max(int x,int y)
  {
    if(x>=y)return x;
    else return y;
  }
  private static void restore()
  {
//    System.out.println("----restore------");
    for(int i=0;i<N;i++)
    {
      for(int j=0;j<N;j++)
      {
        arr[i][j]=backup[i][j];
      }
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
//        System.out.println("기준 [x:"+i+" y:"+j+"] && 상대 tx:"+tx+" ty:"+ty+"]");


          char temp2 = arr[tx][ty];
          arr[tx][ty]=temp1;
          arr[i][j]  =temp2;
//        System.out.println("arr[i][j]:"+arr[i][j]+" arr[tx][ty]"+arr[tx][ty]);
      }
//      printArr();
      calculate();
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
