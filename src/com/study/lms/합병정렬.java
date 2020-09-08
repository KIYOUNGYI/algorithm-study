package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 합병정렬{
    
    public static int n;
    public static int[] arr;
    public static int[] temp;
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner scan = new Scanner(System.in);
      
      n = scan.nextInt();
      arr = new int[n];
      temp = new int[n];
      
      for(int i=0;i<n;i++)arr[i]=scan.nextInt();
      
      mergeSort(0,n-1);
      
      // System.out.println(Arrays.toString(arr));
//      for(int i=0;i<n;i++)
//      {
//        System.out.print(arr[i]+" ");
//      }System.out.println();
      for(int i=0;i<n;i++)
      {
        System.out.println(arr[i]);
      }


      scan.close();
    }
    
    public static void mergeSort(int s,int e)
    {
      if(s>=e)return;
      
      int m = (s+e)/2;
      mergeSort(s,m);
      mergeSort(m+1,e);
      merging(s,m,m+1,e);
    }
    
    public static void merging(int s1,int e1,int s2,int e2)
    {
      int p=s1;int q=s2;
      int tempIdx = 0;
      while(p<=e1 && q<=e2)
      {
        if(arr[p]<arr[q])
        {
          temp[tempIdx++]=arr[p++];
        }
        else
        {
          temp[tempIdx++]=arr[q++];
        }
      }
      
      if(p>e1)
      {
        for(int i=q;i<=e2;i++)
        {
          temp[tempIdx++]=arr[i];
        }
      }
      if(q>e2)
      {
        for(int i=p;i<=e1;i++)
        {
          temp[tempIdx++]=arr[i];
        }
      }
        
      for(int i=s1;i<=e2;i++)
      {
        arr[i]=temp[i-s1];
      }  
    }
}