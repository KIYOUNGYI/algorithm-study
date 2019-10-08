package com.study.lms;

import java.util.Scanner;
public class 알고리즘랩스출근{
    public static int testCase;
    public static int sero;
    public static int garo;
    public static int[][] a;
    public static boolean[][] v;
    public static boolean[] s = new boolean[201];
    public static int maxScore=-1;
    public static int way=0;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      testCase = scan.nextInt();
      
      for(int i=1;i<=testCase;i++)
      {
        input(scan);
        doit();
        System.out.println("#"+i+" "+way+" "+maxScore);
        maxScore=-1;
        way=0;
        initS();
      }
      scan.close();
    }
    
    public static void initS()
    {
      for(int i=0;i<=200;i++)s[i]=false;
    }
    
    public static void doit()
    {
      s[a[0][0]]=true;
      v[0][0]=true;
      move(0,0);
    }
    
    public static int sum()
    {
      int x = 0;
      for(int i=1;i<=200;i++)
      {
        if(s[i]==true)
        {
          x+=i;
        }
      }
      // System.out.println(x);
      return x;
    }
    
    public static void move(int x,int y)
    {
      if(x==sero-1 && y==garo-1)
      {
        way+=1;
        int t = sum();
        if(t>maxScore){maxScore=t;}
        return;
      }
      
      if(x+1<sero && v[x+1][y]==false && s[a[x+1][y]]==false)
      {
        s[a[x+1][y]]=true;
        v[x+1][y]=true;
        move(x+1,y);
        s[a[x+1][y]]=false;
        v[x+1][y]=false;
      }
      if(y+1<garo && v[x][y+1]==false && s[a[x][y+1]]==false)
      {
        s[a[x][y+1]]=true;
        v[x][y+1]=true;
        move(x,y+1);
        s[a[x][y+1]]=false;
        v[x][y+1]=false;
      }
    }
    
    public static void input(Scanner scan)
    {
      sero = scan.nextInt();garo = scan.nextInt();
      a = new int[sero][garo]; v = new boolean[sero][garo];
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          a[i][j]=scan.nextInt();
        }
      }
    }
}