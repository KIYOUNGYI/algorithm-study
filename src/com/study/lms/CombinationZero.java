package com.study.lms;

import java.util.Scanner;
public class CombinationZero{
    
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in);
      
      // System.out.println(countTwo(40));
      int n = scan.nextInt();
      int r = scan.nextInt();
      
      int bunmoTwoSum=0;
      int bunmoFiveSum=0;
      for(int i=n;i>n-r;i--)
      {
        int x = countTwo(i);
        int y = countFive(i);
        bunmoTwoSum+=x;
        bunmoFiveSum+=y;
      }
      
      int bunjaTwoSum=0;int bunjaFiveSum=0;
      for(int i=r;i>=1;i--)
      {
        int x = countTwo(i);
        int y = countFive(i);
        bunjaTwoSum+=x;
        bunjaFiveSum+=y;
      }
      
      int t1 = bunmoFiveSum-bunjaFiveSum;
      int t2 = bunmoTwoSum - bunjaTwoSum;
      
      if(t1<t2) System.out.println(t1);
      else System.out.println(t2);
      
      
      scan.close();
    }
    
    public static int countTwo(int x)
    {
      int cnt=0;
      while(x%2==0)
      {
          cnt++;
          x=x/2;
      }
      return cnt;
    }
    public static int countFive(int x)
    {
      int cnt=0;
      while(x%5==0)
      {
          cnt++;
          x=x/5;
      }
      return cnt;
    }
}