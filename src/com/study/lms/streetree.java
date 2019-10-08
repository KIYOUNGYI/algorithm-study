package com.study.lms;

import java.util.Scanner;
public class streetree{
  
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      
      int n =  scan.nextInt();
      int[] arr = new int[n];
      
      for(int i=0;i<n;i++)arr[i]=scan.nextInt();
      
      int dif = arr[1]-arr[0];
      
      while(true)
      {
        int cnt=0;
        for(int i=1;i<n;i++)
        {
          if((arr[i]-arr[0])%dif==0)cnt+=1;
          else{dif-=1;break;}
        }
        if(cnt==n-1){break;}
      }
      
      int ans = ( (arr[n-1]-arr[0])/dif + 1 ) - n;
      System.out.println(ans);
      
      scan.close();
    }
}