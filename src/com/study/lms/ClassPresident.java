package com.study.lms;

import java.util.Scanner;
public class ClassPresident{
    //학생수 입력
    //학생별로 각 한년별로 무슨반이었는지 입력
    //빈도 테이블 만들기(i번은 누구랑 같은반이었다.)
    
    // 학생 (1~n)번
    //  (1~5)학년
    //    학생(1~n)번 (자기자신 제외)
    public static int n;
    public static int[][] arr;
    public static boolean[][] v;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      input(scan);
      president();
      
      scan.close();
    }
    public static void president()
    {
      
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=5;j++)
        {
          for(int k=1;k<=n;k++)
          {
            if(i==k)continue;
            if(arr[i][j]==arr[k][j])v[i][k]=true;
          }
        }
      }
      
      int[] s = new int[n+1];
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          if(v[i][j]==true)s[i]+=1;
        }
      }
      
      int max=0;int maxIdx=1;
      for(int i=1;i<=n;i++)
      {
        if(s[i]>max){maxIdx=i;max=s[i];}
      }
      System.out.println(maxIdx);
    }
    
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      arr = new int[n+1][6];
      v = new boolean[n+1][n+1];
      for(int i=1;i<=n;i++){for(int j=1;j<=5;j++)arr[i][j]=scan.nextInt();}
    }
}