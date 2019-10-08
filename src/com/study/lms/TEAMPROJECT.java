package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class TEAMPROJECT{
//	https://www.acmicpc.net/problem/9466
    public static int n;
    public static int[] a;
    public static int[] s;
    public static boolean[] v;
    public static ArrayList<Integer> arrList = new ArrayList();
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      input(scan);
      
      for(int i=1;i<=n;i++)
      {
        if(!v[a[i]])
        {
          dfs(a[i]);
          for(int j=0;j<arrList.size();j++)
          {
            v[arrList.get(j)]=true;
            if(s[arrList.get(j)]<=1)s[arrList.get(j)]=0;
          }
          arrList.clear();
        }
      }
      // System.out.println(Arrays.toString(s));
      result();
      scan.close();
    }
    public static void result()
    {
      int cnt=0;
      for(int i=1;i<=n;i++)
      {
        if(s[i]<2)cnt+=1;
      }
      System.out.println(cnt);
    }
    
    
    public static void dfs(int x)
    {
      if(v[x])return;
      if(s[x]>=2)return;
      s[x]+=1;
      if(!arrList.contains(x))arrList.add(x);
      dfs(a[x]);
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      s = new int[n+1];
      v = new boolean[n+1];
      a = new int[n+1];
      for(int i=1;i<=n;i++)a[i]=scan.nextInt();
    }
    
    
}