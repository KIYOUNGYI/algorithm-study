package com.study.lms;

import java.util.Scanner;
public class 대푯값{
    public static int[] s = new int[1001];
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      input(scan);
      scan.close();
    }
    
    public static void input(Scanner scan)
    {
      int sum=0;
      for(int i=0;i<10;i++)
      {
        int x = scan.nextInt();
        s[x]+=1;
        sum+=x;
      }
      
      int maxCnt=0;int max=0;
      for(int i=0;i<1001;i++)
      {
          if(s[i]>maxCnt){maxCnt=s[i];max=i;}
      }
      System.out.println(sum/10+"\n"+max);
    }
}