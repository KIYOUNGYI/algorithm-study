package com.study.lms;

import java.util.Scanner;
public class findPrime{
    
    public static int n;
    public static boolean[] isPrime = new boolean[1001];
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      
      n = scan.nextInt();
      
      for(int i=2;i<1001;i++){
        for(int j=i+i;j<1001;j=j+i){
          isPrime[j]=true;
        }
      }
      isPrime[1]=true;
      
      int cnt=0;
      for(int i=0;i<n;i++)
      {
        int x = scan.nextInt();
        if(!isPrime[x])
          cnt+=1;
      }
      System.out.println(cnt);      
      scan.close(); 
    }
    
    public static void printPrime()
    {
      for(int i=0;i<1001;i++)
      {
        System.out.println(isPrime[i]);
      }
    }
    
    
}