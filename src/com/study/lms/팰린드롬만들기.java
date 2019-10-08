package com.study.lms;
import java.util.Scanner;

public class 팰린드롬만들기{
    public static String x;
    public static int[][] a;
    public static int len;
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      x = scan.nextLine();
      len = x.length();
      a = new int[len][len];
      
      for(int i=len-1;i>=0;i--)
      {
        for(int j=i;j<=len-1;j++)
        {
          if(i==j)a[i][j]=0;
          else
          {
            if(x.charAt(i)==x.charAt(j))
            {
              a[i][j]=a[i+1][j-1];
            }
            else
            {
              a[i][j]=min(a[i][j-1],a[i+1][j])+1;
            }
          }
        }
      }
      // printA();
      System.out.println(a[0][len-1]);
    }
    public static void printA()
    {
      for(int i=0;i<len;i++)
      {
        for(int j=0;j<len;j++)
        {
          System.out.print(a[i][j]+" ");
        }System.out.println();
      }
    }
    public static int min(int a,int b)
    {
      if(a<=b)return a;
      else return b;
    }
}
      // 점화식
      // if data(i)==data(j)
      //    T(i,j) = T(i+1,j-1)
      // if data(i)!=data(j)
      //    min(T(i,j-1),T(i+1,j)+1)+1;