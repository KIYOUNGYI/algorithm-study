package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class baseballgame{
    
    public static int n;
    public static int[][] arr;
    public static boolean flag=false;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      n  = scan.nextInt();
      arr = new int[n][3];
      input(scan);
      if(flag==true){System.out.println(1);return;}
      baseballGame();
      
      // printArr();
      
      scan.close();
    }
    
    public static void baseballGame()
    {
      int score=0;
      for(int i=123;i<=987;i++)
      {
        if(noZero(i) && noDuplicated(i))
        {
          int cnt=0;
          for(int j=0;j<n;j++)
          {
            // System.out.println(i+" "+arr[j][0]+" "+arr[j][1]+" "+arr[j][2]);
            if(compare(i,arr[j][0],arr[j][1],arr[j][2]))
            {
              cnt+=1;
            }
            else
            {
              break;
            }
          }
          if(cnt==n)
          {
            // System.out.println(i);
            score+=1;
          }
        }
      }
      System.out.println(score);
    }
    
    public static boolean compare(int young,int min,int givenStrike,int givenBall)
    {
      int[] arr = new int[3];
      int[] brr = new int[3];
      
      arr[0]=young/100;arr[1]=(young%100)/10;arr[2]=young%10;
      brr[0]=min/100;brr[1]=(min%100)/10;brr[2]=min%10;
      
      // System.out.println(Arrays.toString(arr));
      // System.out.println(Arrays.toString(brr));
      
      int strike=0;
      for(int i=0;i<3;i++){if(arr[i]==brr[i])strike+=1;}
      
      int ball=0;
      for(int i=0;i<3;i++)
      {
        for(int j=0;j<3;j++)
        {
          if(i!=j && arr[i]==brr[j])ball+=1;
        }
      }
      
      // if(young==324)
      // {
      //   System.out.println("strike"+strike);
      //   System.out.println("ball"+ball);
        
      // }
      
      if(ball==givenBall && strike==givenStrike)
      {
        return true;
      }
      else return false;
      
    }
    
    //중복이 없음 참 반환, 중복이 있음 거짓 반환
    public static boolean noDuplicated(int input)
    {
      int baek = input/100;
      int sip = (input%100)/10;
      int ill = (input)%10;
      if(baek==sip || baek==ill || sip==ill)return false;
      else return true;
    }
    
    public static boolean noZero(int input)
    {
      int baek = input/100;
      int sip = (input%100)/10;
      int ill = input%10;
      
      if(baek==0 || sip==0 || ill ==0)return false;
      else return true;
    }
    
    public static void printArr()
    {
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<=2;j++)
        {
          System.out.print(arr[i][j]);
        }  
        System.out.println();
      }
    }
    
    public static void input(Scanner scan)
    {
      for(int i=0;i<n;i++)
      {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        
        arr[i][0]=a;
        arr[i][1]=b;
        arr[i][2]=c;
        if(b==3 && c== 0){flag=true;}
      }
    }
}