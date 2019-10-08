package com.study.lms;

import java.util.Scanner;
public class 두문자열사이의거리{
    
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String x = scan.nextLine();String y = scan.nextLine();
      int r = minDistance(x,y);
      System.out.println(r);
      scan.close();
    }
    public static int minDistance(String x,String y)
    {
      int xLen = x.length(); int yLen = y.length();
      int[][] s = new int[xLen+1][yLen+1];
      
      for(int i=0;i<=xLen;i++){s[i][0]=i;}
      for(int j=0;j<=yLen;j++){s[0][j]=j;}
      
      for(int i=1;i<=xLen;i++)
      {
        for(int j=1;j<=yLen;j++)
        {
          if(x.charAt(i-1)==y.charAt(j-1))
          {
            s[i][j]=s[i-1][j-1];
          }
          else
          {
            s[i][j]=min(s[i-1][j],s[i][j-1])+1;
          }
        }
      }
      return s[xLen][yLen];
      
    }
    
    public static int min(int a,int b)
    {
      if(a>b)return b;else return a;
    }
}