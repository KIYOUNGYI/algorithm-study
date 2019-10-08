package com.study.lms;

import java.util.Scanner;
public class PROSJEK{

    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] B  = new int[n]; int[] A = new int[n];
      
      for(int i=0;i<n;i++)B[i] = scan.nextInt();
      
      for(int i=0;i<n;i++)B[i] = (i+1)*B[i];
      
      A[0]=B[0];
      
      for(int i=1;i<n;i++) A[i] = B[i]-B[i-1];
      
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<n;i++)sb.append(A[i]+" ");
      System.out.println(sb.toString());
      scan.close();

    }
}