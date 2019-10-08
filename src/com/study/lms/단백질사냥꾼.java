package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class 단백질사냥꾼{
    public static int testCase;
    public static int n;
    public static int[][] a;
    public static int[][] s;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      testCase=scan.nextInt();
      for(int i=1;i<=testCase;i++)
      {
        input(scan);
        calculate();
        // System.out.println("!@#!@3");
        // printS();
        int result = findMax();
        System.out.println("#"+i+" "+result);
      }
      scan.close();
    }
    
    public static void calculate()
    {
      for(int i=2;i<=n-1;i++)
      {
        ArrayList<Integer> arrList = new ArrayList();
        for(int j=2;j<=n-1;j++)
        {
          // System.out.println("----");
          // System.out.println("기준:"+i+" "+j);
          // System.out.println("----");
          for(int x=1;x<=n;x++)
          {
            // System.out.println(i+" "+x);
            if(!arrList.contains(a[i][x]))
            {
              arrList.add(a[i][x]);
            }
          }
          for(int y=1;y<=n;y++)
          {
            // System.out.println(y+" "+j);
            if(!arrList.contains(a[y][j]))
            {
              arrList.add(a[y][j]);
            }
          }
          // System.out.println("arrList:"+arrList.toString());
          int sum=0;
          for(int k=0;k<arrList.size();k++)
          {
            sum+=arrList.get(k);
          }
          s[i][j]=sum;
          arrList.clear();
          
        }
      }
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();

      a = new int[n+1][n+1];
      s = new int[n+1][n+1];
      for(int j=1;j<=n;j++)
      {
        for(int k=1;k<=n;k++)
        {
          a[j][k]=scan.nextInt();
        }
      }
    }
    public static int findMax()
    {
      int max=-1;
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          if(max<s[i][j])
          {
            max=s[i][j];
          } 
        }
      }
      return max;
    }
    
    public static void printS()
    {
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          System.out.print(s[i][j]+" ");
        }System.out.println();
      }
    }   
}