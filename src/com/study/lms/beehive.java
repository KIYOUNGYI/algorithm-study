package com.study.lms;

import java.util.Scanner;
public class beehive{
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);

      int[] arr = new int[3000011];
      
      int cnt=6;int idx=2;int val=2;int j=1;
      arr[1]=1;
      
      while(true)
      {
        if(idx==1000000)
          {
            break;
          }
          
        for(int i=0;i<cnt;i++)
        {
          arr[idx]=val;
          if(idx==1000000)
          {
            break;
          }
          idx+=1;
          
        }
        j+=1;
        cnt = 6*j;
        val = val+1;
        
      }
      int x = scan.nextInt();
      System.out.println(arr[x]);
      // for(int i=0;i<100;i++)
      // {
      //   System.out.println(i+" "+arr[i]);
      // }
      
      scan.close();
    }
}