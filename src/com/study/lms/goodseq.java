package com.study.lms;

import java.util.Scanner;
public class goodseq{
    public static int[] a;
    public static int n;
    public static boolean r=false;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      a = new int[n];
      getResult(0);
    }
    
    public static void print()
    {
      for(int i=0;i<n;i++)
      {
        System.out.print(a[i]);
      }System.out.println();
    }
    
    public static void getResult(int x)
    {
      if(r)return;
      
      if(x>=n)
      {
        // System.out.println("!@#");
        print();
        r=true;
        return;
      }
      
      for(int i=1;i<=3;i++)
      {
        boolean flag=false;
        a[x]=i;
        for(int j=1;j<=(x+1)/2;j++)
        {
          // 안되는 경우가 1개라도 있으면 ex> 123 123  12 12
          if(!check(x,j))
          {
            flag=true;break;
          }
        }
        if(!flag){getResult(x+1);}
      }
    }
    // 부분문자가 일치하지 않으면 참 반환
    public static boolean check(int x,int len)
    {
      for(int i=0;i<len;i++)
      {
        if(a[x-i]!=a[x-i-len]){return true;}
      }
      return false;
    }
}