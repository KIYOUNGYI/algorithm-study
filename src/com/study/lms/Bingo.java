package com.study.lms;

import java.util.Scanner;
public class Bingo{
    public static boolean[][] v = new boolean[5][5];
    public static int[][] arr = new int[5][5];
    public static int[] s = new int[26];
    public static void main(String[] args){
      
      Scanner scan = new Scanner(System.in); 
      
      input(scan);
      bingo();
      
      scan.close();
    }
    
    public static void bingo()
    {
      for(int i=1;i<=25;i++)
      {
        for(int j=0;j<5;j++)
        {
          for(int k=0;k<5;k++)
          {
            if(arr[j][k]==s[i])
            {
              v[j][k]=true;
              if(check()){System.out.println(i);return;}
            }
          }
        }
      }
    }
    
    public static boolean check()
    {
      int score=0;
      for(int i=0;i<5;i++)
      {
        int cnt=0;
        for(int j=0;j<5;j++)
        {
          if(v[i][j])cnt+=1;
        }
        if(cnt==5)score+=1;
      }
      for(int i=0;i<5;i++)
      {
        int cnt=0;
        for(int j=0;j<5;j++)
        {
          if(v[j][i])cnt+=1;
        }
        if(cnt==5)score+=1;
      }
      
      int cnt3=0;
      for(int i=0;i<5;i++)
      {
        if(v[i][i])cnt3+=1;
      }
      if(cnt3==5)score+=1;
      
      int cnt4=0;
      for(int i=4;i>=0;i--)
      {
        if(v[i][4-i])cnt4+=1;
      }
      if(cnt4==5)score+=1;
      
      if(score>=3)return true;
      else return false;
    }
    
    public static void input(Scanner scan)
    {
      for(int i=0;i<5;i++)
      {
        for(int j=0;j<5;j++)
        {
          arr[i][j] = scan.nextInt();
        }
      }
      
      for(int i=1;i<=25;i++)s[i]=scan.nextInt();
    }
}