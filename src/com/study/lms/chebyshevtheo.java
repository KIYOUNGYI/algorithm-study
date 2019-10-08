package com.study.lms;

import java.util.Scanner;
public class chebyshevtheo{
    
    public static boolean[] arr = new boolean[300010];
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      
      // 일반수는 true, 소수는 false
      for(int i=2;i<=300001;i++)
        for(int j=i+i;j<=300001;j=j+i)
          arr[j] = true;
      arr[1]=true;
      
      // for(int i=2;i<=100;i++)
      // {
      //   System.out.println(i+" "+arr[i]);
      // }
      
      while(true)
      {
        int n = scan.nextInt();
        if(n==0)break;
        
        int cnt = 0;
        for(int i=n+1;i<=2*n;i++)
        {
          if(arr[i]==false)cnt+=1;
        }
        System.out.println(cnt);
      }
      
      
      scan.close();

    }
    
    
}