package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class 숫자박스{
    
    //바이너리서치 구현
    public static int n,q;
    public static ArrayList<Integer> arr = new ArrayList();
    public static int[] qrr;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      for(int i=0;i<qrr.length;i++)
      {
        // bSearch(qrr[i]);
        bSearch2(0,n-1,qrr[i]);
      }
      scan.close();    
    }
    
    public static void bSearch2(int s,int e,int target)
    {
      if(s>e){System.out.println(0);return;}
      if(s==e)
      {
        if(arr.get(s)==target){System.out.println(1);return;}
        else{System.out.println(0);return;}
      }
      
      int m = (s+e)/2;
      
      if(arr.get(m)==target){System.out.println(1);return;}
      else if(arr.get(m)<target)
      {
        bSearch2(m+1,e,target);
      }
      else
      {
        bSearch2(s,m-1,target);
      }
      
      
    }
    
    // public static void bSearch(int target)
    // {
    //   int s = 0;
    //   int e = n-1;
    //   if(target<arr.get(s) || target>arr.get(e)){System.out.println(0);return;}
    //   if(arr.get(s)==target || arr.get(e)==target)
    //   {
    //     System.out.println(1);return;
    //   }
    //   while(s+1<e)
    //   {
    //     int m = (s+e)/2;
    //     if(arr.get(m)==target){System.out.println(1);return;}
    //     else if(arr.get(m)<target)
    //     {
    //       s = m;
    //     }
    //     else
    //     {
    //       e = m;
    //     }
    //   }
    //   System.out.println(0);
    // }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      for(int i=0;i<n;i++)
      {
        int x = scan.nextInt();
        arr.add(x);
      }
      Collections.sort(arr);
      q = scan.nextInt();
      qrr = new int[q];
      for(int i=0;i<q;i++)
      {
         qrr[i] = scan.nextInt();
      }
    }
    
}