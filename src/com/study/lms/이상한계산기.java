package com.study.lms;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class 이상한계산기{
    public static final int MAX=100000;
    public static int n;
    public static boolean[] v = new boolean[MAX];
    public static int[] a = new int[MAX];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      bfs();
      System.out.println(a[n]);
      scan.close();
    }
    public static void bfs()
    {
      Queue<Integer> q = new LinkedList();
      v[1]=true;
      a[1]=0;
      q.add(1);
      while(!q.isEmpty())
      {
        int x = q.peek();
        q.remove();
        int score = a[x];
        
        if(x*2<MAX)
        {
          if(v[x*2]==false)
          {
            v[x*2]=true;
            a[x*2]=score+1;
            q.add(x*2);
          }
        }
        if(x/3>=1)
        {
          if(v[x/3]==false)
          {
            v[x/3]=true;
            a[x/3]=score+1;
            q.add(x/3);
          }
        }
        
        if(a[n]!=0){return;}
      }
    }
}
