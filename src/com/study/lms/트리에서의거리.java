package com.study.lms;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;


public class 트리에서의거리{
    public static int n;
    public static int root;
    public static boolean[][] a;
    public static int[] s;
    public static int[] h;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      // printA();
      bfs();
      calculateH();
      scan.close();
      
    }
    
    public static void calculateH()
    {
      for(int i=0;i<=n-1;i++)
      {
        if(i==root)continue;
        int temp = s[i];
        int cnt = 1;
        while(temp!=root)
        {
          cnt+=1;
          temp = s[temp];
        }
        h[i]=cnt;
      }
      // System.out.println("h->"+Arrays.toString(h));
      int max=0;
      for(int i=0;i<n;i++)
      {
        if(max<h[i])max=h[i];
      }
      System.out.println(max);
    }
    
    public static void bfs()
    {
      Queue<Integer> q = new LinkedList();
      q.add(root);
      s[root]=-1;
      
      while(!q.isEmpty())
      {
        int x = q.peek();
        // System.out.println("->"+x);
        
        q.remove();
        for(int i=0;i<=n-1;i++)
        {
          for(int j=0;j<=n-1;j++)
          {
            if(i==x && a[x][j]==true )
            {
              a[i][j]=false;a[j][i]=false;s[j]=x;q.add(j);
            }
          }
        }
      }
      
      // System.out.println("s:"+Arrays.toString(s));
      
    }
    
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      root = scan.nextInt();
      a = new boolean[n][n];
      s = new int[n];
      h = new int[n];
      for(int i=0;i<n-1;i++)
      {
        int x = scan.nextInt();int y = scan.nextInt();
        a[x][y]=true;a[y][x]=true;
      }
    }
    public static void printA()
    {
       for(int i=0;i<=n-1;i++)
      {
        for(int j=0;j<=n-1;j++)
        {
          if(a[i][j]==true)
          {
            System.out.print("O ");
          }
          else
          {
            System.out.print("X ");
          }
          // System.out.print(a[i][j]+" ");
        }System.out.println();
      }
    }
}