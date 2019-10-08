package com.study.lms;

import java.util.Scanner;
import java.util.*;

public class SAFETYZONE{
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};
    public static int maxRain;
    public static int n;
    public static int[][] arr,backup;
    public static boolean[][] v;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        input(scan);
        safetyzone();
        
        scan.close();
    }
    
    public static void dfs(int a,int b)
    {
      for(int i=0;i<4;i++)
      {
        int nx = a+dx[i];
        int ny = b+dy[i];
        if(nx>=0 && ny>=0 && nx<n && ny<n)
        {
          if(v[nx][ny]==false && arr[nx][ny]!=0)
          {
            v[nx][ny]=true;
            // System.out.println("nx:"+nx+" ny:"+ny);
            dfs(nx,ny);
          }
        }
      }
    }
    
    public static void safetyzone()
    {
      ArrayList<Integer> arrlist = new ArrayList();
      for(int rain=1;rain<=maxRain;rain++)
      {
        modifyMap(rain);
        
        int cnt=0;
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
            if(v[i][j]==false && arr[i][j]!=0)
            {
              cnt+=1;
              v[i][j]=true;
              dfs(i,j);
            }
          }
        }
        // System.out.println("rain:"+rain+" cnt:"+cnt);
        arrlist.add(cnt);
        init();
      }
      // System.out.println(arrlist.toString());
      Collections.sort(arrlist);
      System.out.println(arrlist.get(arrlist.size()-1));
    }
    
    public static void modifyMap(int rain)
    {
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          arr[i][j] = arr[i][j]-rain;
          if(arr[i][j]<0) arr[i][j]=0;
        }
      }
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      arr = new int[n][n];backup=new int[n][n];
      v = new boolean[n][n];
      int temp=0;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          arr[i][j]=scan.nextInt();
          backup[i][j]=arr[i][j];
          if(temp<arr[i][j])
          {
            temp = arr[i][j];
          }
        }
      }
      maxRain = temp;
      
      
    }
    
    //v,arr 초기화
    public static void init()
    {
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          v[i][j]=false;
          arr[i][j]=backup[i][j];
        }
      }
    }
    
}