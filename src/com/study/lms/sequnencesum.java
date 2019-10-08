package com.study.lms;

import java.util.Scanner;
public class sequnencesum{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      int n = scan.nextInt();
      
      int[][] arr = new int[n][n];
      for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
          arr[i][j] = scan.nextInt();
          
      int[] R = new int[n];
      int[] T = new int[n];
      
      for(int i=0;i<n;i++)
      {
        int sum=0;
        for(int j=0;j<n;j++)
        {
          sum+=arr[i][j];
        }
        R[i]=sum;
      }
      
      for(int i=0;i<n-1;i++)
      {
        T[i]=(R[i]-R[i+1])/(n-2);
      }
      T[n-1]=(R[n-1]-R[0])/(n-2);
      
      int[] result = new int[n];
      for(int i=0;i<n-1;i++)
      {
        result[i] = (T[i]+arr[i][i+1])/2;
      }
      result[n-1] = (T[n-1]+arr[n-1][0])/2;
      
      for(int i=0;i<n;i++)System.out.print(result[i]+" ");
      
      scan.close();
    }
}