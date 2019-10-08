package com.study.lms;
import java.util.Scanner;
import java.util.*;

public class DAM{
    
    public static int maxHeight=0;
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int n;
    public static int[][] map;
    public static int[][] score;
    public static boolean[][] v;
    public static int sero,garo,hour;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      dam();
      scan.close();
    }
    
    public static void dam()
    {
     
      bfs();
      // printScore();
      answer();
    }
    
    public static void printScore()
    {
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          System.out.print(score[i][j]+" ");
        }System.out.println();
      }
    }
    
    public static int findMaxHeight()
    {
      int cnt=0;
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          if(score[i][j]>cnt){cnt=score[i][j];} 
        }
      }
      return cnt;
    }
    
    public static void answer()
    {
      maxHeight = findMaxHeight();
      if(maxHeight<=hour){System.out.println(-1);return;}
      
      int cnt=0;
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          if(score[i][j]==hour){cnt+=1;}
        }
      }
      System.out.println(cnt);
    }
    
    
    
    public static void bfs()
    {
      Queue<Point> q = new LinkedList();
      q.add(new Point(sero,garo));
      v[sero][garo]=true;
      score[sero][garo]=0;
      
      while(!q.isEmpty())
      {
        Point pt = q.peek();
        q.remove();
        int cx = pt.x;
        int cy = pt.y;
        int cval = score[cx][cy];
        
        for(int i=0;i<4;i++)
        {
          int nx = cx+dx[i];
          int ny = cy+dy[i];
          
          if(nx>=1 && nx<=n && ny>=1 && ny<=n)
          {
            if(v[nx][ny]==false && map[nx][ny]==0)
            {
              v[nx][ny]=true;
              score[nx][ny]=cval+1;
              q.add(new Point(nx,ny));
            }
          }
        }
      }
    }
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      map = new int[n+1][n+1];score = new int[n+1][n+1];
      v = new boolean[n+1][n+1];
      int temp=0;
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          
          map[i][j] = scan.nextInt();
          if(map[i][j]>temp)temp=map[i][j];
          if(map[i][j]==1){v[i][j]=true;}
        }
      }
      
      garo = scan.nextInt();
      sero = scan.nextInt();
      hour = scan.nextInt();
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