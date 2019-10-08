package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 퀵정렬{
    
    public static int n;
    public static int[] arr;
    public static int[] left;
    public static int[] right;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      
      n = scan.nextInt();
      arr   = new int[n];
      left  = new int[n];
      right = new int[n];
      
      for(int i=0;i<n;i++)arr[i]=scan.nextInt();
      quickSort(0,n-1);
      printArr();
      scan.close();
    }
    
    public static void printArr()
    {
      for(int i=0;i<n;i++)
      {
        System.out.print(arr[i]+" ");
      }System.out.println();
    }
    
    public static void quickSort(int s,int e)
    {
      if(s>=e)return;
      
      int pivot = arr[s];
      
      int lCnt = getLeft(s+1,e,pivot);
      int rCnt = getRight(s+1,e,pivot);
      // System.out.println("lCnt:"+lCnt+" rCnt:"+rCnt);
      for(int i=s;i<s+lCnt;i++)
      {
        arr[i]=left[i-s];
      }
      arr[s+lCnt]=pivot;
      
      for(int i=s+lCnt+1;i<=e;i++)
      {
        arr[i]=right[i-(s+lCnt+1)];
      }
      quickSort(s,s+lCnt-1);
      quickSort(s+lCnt+1,e);
    }
    
    public static int getLeft(int s,int e,int pivot)
    {
      int idx=0;
      for(int i=s;i<=e;i++)
      {
        if(arr[i]<=pivot)
        {
          left[idx++]=arr[i];
        }
      }
      // System.out.println(Arrays.toString(left));
      // System.out.println("idx:"+idx);
      return idx;
    }
    
    public static int getRight(int s,int e,int pivot)
    {
      int idx=0;
      for(int i=s;i<=e;i++)
      {
        if(arr[i]>pivot)
        {
          right[idx++]=arr[i];
        }
      }
      // System.out.println(Arrays.toString(right));
      return idx;
    }
    
    
}