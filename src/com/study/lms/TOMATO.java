package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TOMATO{
    public static int[] dh = new int[]{1,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int[] dx = new int[]{0,1,0,-1};
    public static int height,sero,garo;
    public static int[][][] map,score;
    public static boolean[][][] v;
    public static ArrayList<Point> arrList = new ArrayList(); 
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      if(!checkZero()){System.out.println(0);return;}
      setArrList();
      // System.out.println(arrList.toString());
      bfs();
      // printS();
      
      answer();
      scan.close();      
    }
    
    public static void printS()
    {
      for(int i=0;i<height;i++)
      {
        for(int j=0;j<sero;j++)
        {
          for(int k=0;k<garo;k++)
          {System.out.print(score[i][j][k]+" ");}System.out.println();
        }
      }
    }
    
    public static void answer()
    {
      int max=-1;
      for(int i=0;i<height;i++)
      {
        for(int j=0;j<sero;j++)
        {
          for(int k=0;k<garo;k++)
          {
            if(score[i][j][k]>max)
            {
              max=score[i][j][k];
             
            } 
            if(score[i][j][k]==0){System.out.println(-1);return;}
          }
        }
      }
      System.out.println(max);
    }
    
    public static void input(Scanner scan)
    {
      garo = scan.nextInt();sero = scan.nextInt();height=scan.nextInt();
      map = new int[height][sero][garo]; score= new int[height][sero][garo]; v = new boolean[height][sero][garo]; 
      for(int i=0;i<height;i++)
      {
        for(int j=0;j<sero;j++)
        {
          for(int k=0;k<garo;k++)
          {
            map[i][j][k] = scan.nextInt();
          }
        }
      }
    }
    
    public static void setArrList()
    {
      for(int i=0;i<height;i++)
      {
        for(int j=0;j<sero;j++)
        {
          for(int k=0;k<garo;k++)
          {
            if(map[i][j][k]==1)arrList.add(new Point(i,j,k,0));
          }
        }
      }
     
    }
    
    public static void bfs()
    {
      Queue<Point> q = new LinkedList();
      for(int i=0;i<arrList.size();i++)
      {
        q.add(arrList.get(i));
        int h1 = arrList.get(i).h;
        int x1 = arrList.get(i).x;
        int y1 = arrList.get(i).y;
        v[h1][x1][y1]=true;
      }
      
      while(!q.isEmpty())
      {
        Point pt = q.peek();
        q.remove();
        
        int ch = pt.h;
        int cx = pt.x;
        int cy = pt.y;
        int cVal = pt.cVal;
        
        if(cVal==0){score[ch][cx][cy]=-1;}
        
        for(int i=0;i<4;i++)
        {
          int nx = cx+dx[i];
          int ny = cy+dy[i];
          if(nx>=0 && nx<sero && ny>=0 && ny<garo)
          {
            if(v[ch][nx][ny]==false && map[ch][nx][ny]==0)
            {
              map[ch][nx][ny]=1;v[ch][nx][ny]=true;
              score[ch][nx][ny]=cVal+1;
              q.add(new Point(ch,nx,ny,cVal+1));
            }
          }
          
        }
        
        for(int i=0;i<2;i++)
        {
          int nh = ch+dh[i];
          if(nh>=0 && nh<height)
          {
            if(v[nh][cx][cy]==false && map[nh][cx][cy]==0)
            {
              map[nh][cx][cy]=1;v[nh][cx][cy]=true;
              score[nh][cx][cy]=cVal+1;
              q.add(new Point(nh,cx,cy,cVal+1));
            }
          }
        }
        
      }
      
      
    }
    
    public static boolean checkZero()
    {
      for(int i=0;i<height;i++)
      {
        for(int j=0;j<sero;j++)
        {
          for(int k=0;k<garo;k++)
          {
            if(map[i][j][k]==0)return true;
          }
        }
      }
      return false;
    }
}

class Point
{
  
  int h;
  int x;
  int y;
  int cVal;
  public Point(int h,int x,int y,int cVal)
  {
    this.h = h;this.x=x;this.y=y;this.cVal = cVal;
  }
  @Override
  public String toString()
  {
    return "[ h:"+h+" x:"+x+" y:"+y+" cVal:"+cVal+"]";
  }
}
