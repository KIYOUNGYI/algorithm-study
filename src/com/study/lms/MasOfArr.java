package com.study.lms;

import java.util.Scanner;
public class MasOfArr{
    public static int[][] arr = new int[10][10];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      inputAndFindMax(scan);
      scan.close();
    }
    public static void inputAndFindMax(Scanner scan)
    {
      int max=-1;int maxX=0;int maxY=0;
      for(int i=1;i<=9;i++)
      {
        for(int j=1;j<=9;j++)
        {
          arr[i][j] = scan.nextInt();
          if(arr[i][j]>max){max=arr[i][j];maxX=i;maxY=j;}
        }
      }
      System.out.println(max+"\n"+maxX+" "+maxY);
    }
}