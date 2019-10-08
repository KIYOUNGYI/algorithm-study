package com.study.lms;

import java.util.Scanner;
public class ICEBERG{
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int sero,garo;
    public static boolean[][] v;
    public static int[][] map,cntMap;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      input(scan);
      iceberg();
      
    
      scan.close();
    }
    
    public static void iceberg()
    {
      int ans=0;
      for(int time=1;time<=5000;time++)
      {
        modifyMap();
        if(checkMap()){ans=0;break;}
        int cnt=0;
        //dfs 수행 
        for(int i=0;i<sero;i++)
        {
          for(int j=0;j<garo;j++)
          {
            if(map[i][j]!=0 && v[i][j]==false)
            {
              v[i][j]=true;
              dfs(i,j);
              cnt+=1;
            }
          }
        }
        initV();
        if(cnt>=2){ans=time;break;}
        cnt=0;
      } 
      System.out.println(ans);
    }
    
    public static void dfs(int a,int b)
    {
      
      for(int i=0;i<4;i++)
      {
        int cx = a+dx[i];
        int cy = b+dy[i];
        
        if(cx>=0 && cy>=0 && cx<sero && cy<garo)
        {
          if(v[cx][cy]==false && map[cx][cy]!=0)
          {
            v[cx][cy]=true;
            dfs(cx,cy);
          }
        }
      }
      
      
    }
    
    public static void modifyMap()
    {
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          if(map[i][j]!=0)
          {
            int cnt=0;
            for(int k=0;k<4;k++)
            {
              int nx = i+dx[k];
              int ny = j+dy[k];
              if(nx>=0 && nx<sero && ny>=0 && ny<garo)
              {
                if(map[nx][ny]==0)
                {
                  cnt+=1;
                }
              }
            }
            cntMap[i][j]=cnt;
          }
        }
      }
      
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          map[i][j] = map[i][j]-cntMap[i][j];
          if(map[i][j]<0)map[i][j]=0;
          cntMap[i][j]=0;
        }
      }
      
    }
    
    public static void input(Scanner scan)
    {
      sero = scan.nextInt();garo = scan.nextInt();
      map = new int[sero][garo];
      cntMap = new int[sero][garo];
      v = new boolean[sero][garo];
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          map[i] [j] = scan.nextInt();
        }
      }
    }
    
    public static boolean checkMap()
    {
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          if(map[i][j]!=0)return false;
        }
      }
      return true;
    }
    
    
    public static void initV()
    {
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          v[i][j]=false;
        }
      }
    }
    
    
}