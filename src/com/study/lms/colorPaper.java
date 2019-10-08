package com.study.lms;

import java.util.Scanner;
public class colorPaper{
    public static int n;
    public static int[][] arr = new int[102][102];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      count();
    }
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      
      for(int t=1;t<=n;t++)
      {
        int sero = scan.nextInt();
        int garo = scan.nextInt();
        int height = scan.nextInt();
        int width = scan.nextInt();
        
        for(int i=sero;i<sero+height;i++)
        {
          for(int j=garo;j<garo+width;j++)
          {
            arr[i][j]=t;
          }
        }
        
      }
    }
    public static void count()
    {
      int[] s = new int[n+1];
      for(int i=0;i<102;i++)
      {
        for(int j=0;j<102;j++)
        {
          s[arr[i][j]]+=1;
          // System.out.print(arr[i][j]+" ");
        // }System.out.println();
        }
      }
      for(int i=1;i<=n;i++)
      {
        System.out.println(s[i]);
      }
    }
}