package com.study.lms;

import java.util.Scanner;
public class 소수판별2{
  
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      int n = scan.nextInt();int m = scan.nextInt();
      for(int i=n;i<=m;i++)
      {
        if(i==1)continue;
        else{
        if(isPrime(i)){System.out.print(i+" ");}
        }
      }
    }
    public static boolean isPrime(int x)
    {
      int cnt=0;
      for(int t=x;t>=1;t--)
      {
        if(x%t==0){cnt+=1;}
      }
      if(cnt>=3)return false;
      else return true;
    }
}