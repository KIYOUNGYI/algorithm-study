package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class 중복없는구간{
    public static int n;
    public static int[] a;
    public static int[] v = new int[100002];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      a = new int[n+1];
      for(int i=1;i<=n;i++)a[i]=scan.nextInt();
      // System.out.println(check(4));
      // System.out.println(check(5));
      if(check(n)){System.out.println(n);return;}
      bSearch(1,n);
      // scan.close();
    }
    
    public static void bSearch(int s,int e)
    {
      
      
      while(s+1<e)
      {
        int m = (s+e)/2;
        if(check(m))s=m;
        else e=m;
      }
      System.out.println(s);
    }
    public static boolean check(int m)
    {
      int cnt=0;
      ArrayList<Integer> arrList = new ArrayList();
      for(int i=1;i<=n;i++)
      {
        if(v[a[i]]==0)
        {
          v[a[i]]=i;
          arrList.add(a[i]);
          cnt+=1;
          // System.out.println(arrList.toS);
        }
        else
        {
         i = v[a[i]];
         for(int j=0;j<arrList.size();j++){v[arrList.get(j)]=0;}
         cnt=0;
          arrList.clear();
        }
        if(cnt==m)
        {
          for(int j=0;j<arrList.size();j++)
          {
           v[arrList.get(j)]=0;
          }
          arrList.clear();
          return true;
        }
      }
     for(int j=0;j<arrList.size();j++)
      {
         v[arrList.get(j)]=0;
      }
      arrList.clear();
      return false;
    }
}