package com.study.lms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CHOOSENNUMBER{
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
        if(s[a[i]]<2){
        dfs(a[i]);
        // System.out.println(i+"번째 원소 dfs "+arrList.toString());
        
        for(int j=0;j<arrList.size();j++)
        {
          if(s[arrList.get(j)]<=1)s[arrList.get(j)]=0;
        }
        arrList.clear();
        }
      }
      // System.out.println("s:"+Arrays.toString(s));
      result();
      scan.close();
    }
    
    public static void result()
    {
      ArrayList<Integer> ans = new ArrayList();
      int cnt=0;
      for(int i=1;i<=n;i++)
      {
        if(s[i]>=2){
          cnt+=1;
          ans.add(i);
        }
      }
      System.out.println(cnt);
      Collections.sort(ans);
      for(int i=0;i<ans.size();i++)
      {
        System.out.print(ans.get(i)+" ");
      }System.out.println();
    }
    
    public static void dfs(int x)
    {
      // if(v[x])return;
      if(s[x]==2)return;
      if(!arrList.contains(x)){arrList.add(x);}
      s[x]+=1;
      dfs(a[x]);
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      a = new int[n+1];
      s = new int[n+1];
      v = new boolean[n+1];
      for(int i=1;i<=n;i++)
      {
        a[i]=scan.nextInt();
      }
    }
}