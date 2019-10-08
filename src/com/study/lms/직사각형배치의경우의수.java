package com.study.lms;

import java.util.Scanner;
public class 직사각형배치의경우의수{
    
    public static final int MAX=101;
    public static int[] d = new int[MAX];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      d[1]=1;d[2]=2;d[3]=3;
      
      for(int i=4;i<MAX;i++)
      {
        d[i] = (d[i-1]+d[i-2])% 1000007;
      }
      System.out.println(d[n]);
      
      scan.close();
    }
}