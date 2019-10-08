package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class division{
    public static int n,cnt=0;
    public static int[] arr;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();arr = new int[n];
        f(0,0);
        System.out.println(cnt);
        scan.close();
    }
    
    public static void print()
    {
      System.out.print(arr[0]);
      for(int i=1;i<n;i++)
      {
        if(arr[i]!=0){
          System.out.print("+");
          System.out.print(arr[i]);
        }
      }System.out.println();
    }
    
    public static void f(int depth,int sum)
    {
      if(sum==n)
      {
        cnt+=1;
        print();
        return;
      }
      
      if(depth==n){return;}
      
      for(int i=n-1;i>=1;i--)
      {
        if(depth>=1 && arr[depth-1]<i)
        {
          
        }
        else
        {
          if(sum+i<=n){
            arr[depth]=i;
            f(depth+1,sum+i);
            arr[depth]=0;
          }
        }
      }
    }
}