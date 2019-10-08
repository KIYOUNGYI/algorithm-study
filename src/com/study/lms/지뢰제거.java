package com.study.lms;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class 지뢰제거{
    public static int sero;
    public static int garo;
    public static boolean[][] v;
    public static int[][] a;
    public static int[] dx1=new int[]{0,1,0,-1};
    public static int[] dy1=new int[]{1,0,-1,0};
    public static int[] dx2=new int[]{-1,-1,1,1};
    public static int[] dy2=new int[]{1,-1,1,-1};
    public static int[] dx3=new int[]{0,0,-2,-2,-2,2,2,2};
    public static int[] dy3=new int[]{2,-2,-2,0,2,-2,0,2};
    public static int[] score;
    public static int ans=0;public static int ansIdx=0;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int i=1;i<=t;i++)
      {
        input(scan);
        
        for(int w=1;w<=sero;w++)
        {
          for(int x=1;x<=garo;x++)
          {
            if(v[w][x]==false)
            {
              bfs(w,x);
            }
            int temp = countV();
            score[temp]+=1;
            initV();
          }
        }
        
        for(int w=1;w<=sero;w++)
        {
          for(int x=1;x<=garo;x++)
          {
            for(int y=1;y<=sero;y++)
            {
              for(int z=1;z<=garo;z++)
              {
                // if(w==x && w==y && w==z){continue;}
                if(v[w][x]==false)
                {
                  bfs(w,x);
                }
                if(v[y][z]==false)
                {
                  bfs(y,z);
                }
            
                int temp = countV();
                score[temp]+=1;
                initV();
              }
            }
          }
        }
        // System.out.println(Arrays.toString(score));
        int ans1 = 0; int ans2=0;
        for(int a=score.length-1;a>=0;a--)
        {
          if(score[a]!=0)
          {
            ans1=a;
            ans2=score[a];
            break;
          }
        }
        System.out.println(i+" "+ans1+" "+ans2/2);
      }
      scan.close();
    }
    
    public static void printV()
    {
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++)
        {
          if(v[i][j]==false)
          {
            System.out.print("f ");
          }
          else
          {
            System.out.print("t ");    
          }
        }System.out.println();
      }
    }
    
    public static void initV()
    {
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++){v[i][j]=false;}
      }
    }
    public static int countV()
    {
      int cnt=0;
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++)
        {
          if(v[i][j]==true)cnt+=1;
        }
      }
      // System.out.println(cnt);
      return cnt;
      
    }
    

    
    public static void bfs(int x,int y)
    {
      Queue<Point> q = new LinkedList();
      v[x][y]=true;
      q.add(new Point(x,y));
      while(!q.isEmpty())
      {
        Point pt = q.peek();
        q.remove();
        int px = pt.x;int py = pt.y;
        int value = a[px][py];
         
        if(a[px][py]==1)
        {
          for(int i=0;i<4;i++)
          {
            int cx = px+dx1[i];
            int cy = py+dy1[i];
            if(cx>=0 && cy>=0 && cx<=sero && cy<=garo)
            {
              if(v[cx][cy]==false)
              {
                v[cx][cy]=true;
                q.add(new Point(cx,cy));
              }
            }
          }
        }
        else if(a[px][py]==2)
        {
           for(int i=0;i<4;i++)
          {
            int cx = px+dx2[i];
            int cy = py+dy2[i];
            if(cx>=0 && cy>=0 && cx<=sero && cy<=garo)
            {
              if(v[cx][cy]==false)
              {
                v[cx][cy]=true;
                q.add(new Point(cx,cy));
              }
            }
          }
        }
        else if(a[px][py]==3)
        {
           for(int i=0;i<8;i++)
           {
            int cx = px+dx3[i];
            int cy = py+dy3[i];
            
            if(cx>=0 && cy>=0 && cx<=sero && cy<=garo)
            {
              if(v[cx][cy]==false)
              {
                v[cx][cy]=true;
                q.add(new Point(cx,cy));
              }
            }
          }
        }
        
      }
      
    }
    public static void input(Scanner scan)
    {
       sero = scan.nextInt();garo = scan.nextInt();
        a = new int[sero+1][garo+1];
        v = new boolean[sero+1][garo+1];
        score = new int[(sero*garo)+1];
        for(int j=1;j<=sero;j++)
        {
          for(int k=1;k<=garo;k++)
          {
            a[j][k] = scan.nextInt();
          }
        }
    }
}
class Point
{
  int x;
  int y;
  public Point(int x,int y){this.x = x;this.y=y;}
}