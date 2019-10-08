package com.study.lms;

import java.util.Scanner;
public class NN단표{
    public static long n;
    public static long k;
    
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n = scan.nextLong(); k = scan.nextLong();
      bSearch(1,n*n);
      // check(8);
      scan.close();
    }
    
    public static void bSearch(long s,long e)
    {
      if(k==1){System.out.println(1);return;}
      while(s+1<e)
      {
        long m = (s+e)/2;
        // System.out.println("m:"+m);
        if(check(m))e = m;
        else  s = m;
      }
      System.out.println(s+1);
    }
    public static boolean check(long input)
    {
      long cnt=0;
      
      for(int i=1;i<=n;i++)
      {
        if(i*n<=input){cnt+=n;}
        else
        {
          long x = input/i;
          cnt+=x;
          if(x==0)break;
        }
        // System.out.println(i+"단에서 "+input+" 보다 작은 수 개수:"+cnt);
      }
      // System.out.println("input->"+input+" cnt->"+cnt);
      if(cnt>=k)return true;
      else return false;
    }
}
