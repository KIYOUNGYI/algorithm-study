package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 두용액{
    
    public static int n;
    public static int[] arr;
    public static int[] temp;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      arr = new int[n];
      temp = new int[n+10];
      for(int i=0;i<n;i++)arr[i]=scan.nextInt();
      mergeSort(0,n-1);
      // System.out.println(Arrays.toString(arr));
      
      int std=arr[0]+arr[1];
      int idx=0;
      for(int i=0;i<n-1;i++)
      {
        int sum = arr[i]+arr[i+1];
        if(absolute(sum)<=absolute(std))
        {
          std=sum;
          idx=i;
        }
      }
      // System.out.println(idx);
      int x = arr[idx];
      int y = arr[idx+1];
      if(x<y)System.out.println(x+" "+y);
      else System.out.println(y+" "+x);
      scan.close();
    }
    
    public static void mergeSort(int s,int e)
    {
      if(s>=e)return;
      int mid = (s+e)/2;
      mergeSort(s,mid);
      mergeSort(mid+1,e);
      merging(s,mid,mid+1,e);
    }
    
    public static void merging(int s1,int e1,int s2,int e2)
    {
      // System.out.println("s1:"+s1+" e1:"+e1+" s2:"+s2+" e2:"+e2);
      int p=s1;int q=s2;int temp_idx=0;
      
      while(p<=e1 && q<=e2)
      {
        if(absolute(arr[p])<absolute(arr[q]))
        {temp[temp_idx++]=arr[p++];}
        else temp[temp_idx++]=arr[q++];
      }
      
      if(p>e1)
        for(int i=q;i<=e2;i++)temp[temp_idx++]=arr[q++];
      else
        for(int i=p;i<=e1;i++)temp[temp_idx++]=arr[p++];
      
      for(int i=s1;i<=e2;i++)arr[i]=temp[i-s1];      
    }
    
    public static int absolute(int x)
    {
      if(x<0) return -1*x;
      else return x;
    }
}