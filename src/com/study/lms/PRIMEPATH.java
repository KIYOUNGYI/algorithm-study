package com.study.lms;


import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class PRIMEPATH{

    public static boolean[] isPrime = new boolean[10000];
    public static ArrayList<Integer> primeList = new ArrayList();
    public static int testCase;
    public static boolean[] v = new boolean[10000];
    public static int cnt=0;
    public static int min=999999;
    public static int[] arr = new int[4]; 
    public static int[] brr = new int[4];
    public static ArrayList<Integer> temp = new ArrayList();
    public static void main(String[] args){
        
        makePrimeArray();
        Scanner scan = new Scanner(System.in);


        testCase = scan.nextInt();
        // testCase = 100;
        for(int i=0;i<testCase;i++)
        {
            int a = scan.nextInt(); int b = scan.nextInt();
            // int a = 1033;int b=8179;
            bfs(a,b);
            System.out.println(cnt);
            cnt=0;
        }


        scan.close();
    }

  
    
    
    public static void bfs(int x,int y)
    {
      
      int depth=0;
      Point p = new Point(x,depth);
      Queue<Point> q =  new LinkedList<Point>();
      q.add(p);
      v[x]=true;
      int curDepth =0;
      while(!q.isEmpty())
      {
        Point cNode = q.peek();
        int currentX = cNode.x;
        curDepth = cNode.depth;
        q.remove();
        
        if(currentX==y)
        {
          cnt=curDepth;
          initV();
          break;
        }
        
        
        for(int i=0;i<primeList.size();i++)
        {
          if(!v[primeList.get(i)] && check(currentX,primeList.get(i)))
          {
            int dep=curDepth+1;
            Point cp = new Point(primeList.get(i),dep);
            v[primeList.get(i)]=true;
            q.add(cp);
            temp.add(i);
          }
        }

      }
    } 
    public static void initV()
    {
        for(int i=0;i<10000;i++){v[i]=false;}
    }
   

    public static boolean check(int x,int y)
    {
//    	System.out.println(x+" "+y);
        int mok=-1;
        int idx=0;
        int r=0;
        while(mok!=0)
        {
            mok = x/10;
            r = x%10;
            arr[idx++]=r;
            x=mok;
        }
        mok=-1;
        idx=0;
        while(mok!=0)
        {
            mok = y/10;
            r = y%10;
            brr[idx++]=r;
            y=mok;
        }

        int cnt=0;
        for(int i=0;i<4;i++)
        {
            if(arr[i]==brr[i])cnt+=1;
        }
        if(cnt==3)return true;
        else return false;
    }

    public static void makePrimeArray()
    {
        for(int i=0;i<10000;i++)isPrime[i]=true;

        for(int i=2;i<=9999;i++)
        {
            for(int j=i+i;j<=9999;j=j+i){isPrime[j]=false;}
        }

        int cnt=0;
        for(int i=1000;i<=9999;i++) 
        {
        	if(isPrime[i]) 
        	{
        		primeList.add(i);
        	}
        }
//        System.out.println("cnt:"+primeList.size());
//        System.out.println(primeList.toString());
    }
}

class Point
{
  int x;
  int depth;
  public Point(int x,int depth)
  {
    this.x = x;
    this.depth = depth;
  }
}