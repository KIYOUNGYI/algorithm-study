package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 십자숫자카드{
    public static int tc;
    public static int n;
    public static int[][] a;
    public static boolean[][] v;
    public static long[] s;
    public static int len;
    public static int sum=0;
    public static long max=Long.MIN_VALUE;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        tc = scan.nextInt();
        for(int i=1;i<=tc;i++)
        {
          n = scan.nextInt();
          a = new int[n+1][5];
          v = new boolean[n+1][5];
          len = n*2-1;
          s = new long[len];
          inputCard(scan);
          if(n==1){System.out.println(i+" "+0);}
          else
          {
            pickCard(1,1);
            System.out.println(i+" "+max);
            max=Integer.MIN_VALUE;
            
          }
        }
    }
    
    public static long abs(long x)
    {
      if(x<0)return -x;
      else return x;
    }
    
    public static void calculate()
    {
      long sum=0;
      for(int i=1;i<len;i+=2)
      {
        if((abs(s[i])%2==0 && abs(s[i+1])%2==0))
        {
          sum+=0;
        }
        else if(abs(s[i])%2==1 && abs(s[i+1])%2==1)
        {
          sum+=0;
        }
        else
        {
          sum+=s[i]*s[i+1];
           
        }
      }
      // System.out.println("sum:"+sum);
      // if(sum==272){System.out.println("pick: "+Arrays.toString(s));}
      if(max<sum){max=sum;}
    }
    
    public static void print()
    {
      for(int i=1;i<s.length;i=i+2)
      {
        System.out.print(s[i]+"*"+s[i+1]+"   ");
      }System.out.println();
    }
        
    public static void pickCard(int card,int idx)
    {
      if(card==n+1)
      {
        // System.out.println("pick: "+Arrays.toString(s));
        // print();
        calculate();
        return;
      }
      
      for(int i=1;i<=4;i++)
      {
        if(card==1 || card==n)
        {
          if(v[card][i]==false)
          {
            v[card][i]=true;
            s[idx]=a[card][i];
            pickCard(card+1,idx+1);
            v[card][i]=false;
            // s[idx]=0;
          } 
        }
        else
        {
          if(v[card][i]==false)
          {
            v[card][i]=true;
            s[idx]=a[card][i];
            
            int tempIdx =0;
            if(i==1){tempIdx=4;}
            else if(i==2){tempIdx=3;}
            else if(i==3){tempIdx=2;}
            else if(i==4){tempIdx=1;}
            
            v[card][tempIdx]=true;
            s[idx+1]=a[card][tempIdx];
            
            pickCard(card+1,idx+2);
            
            v[card][i]=false;
            v[card][tempIdx]=false;
            // s[idx]=0;
            // s[idx+1]=0;
          }
          
          
          
        }
      }
      
    }
    
    public static void inputCard(Scanner scan)
    {
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=4;j++)
        {
          a[i][j] = scan.nextInt();
        }
      }
    }
}