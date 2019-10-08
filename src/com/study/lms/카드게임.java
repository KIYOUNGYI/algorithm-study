package com.study.lms;

import java.util.Scanner;
public class 카드게임{
    
    public static int[][] a = new int[2][10];
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
        for(int j=0;j<2;j++)
        {
          for(int k=0;k<10;k++)
          {
            a[j][k]=scan.nextInt();
          }
        }
        int aWin=0;int bWin=0;
        for(int x=0;x<10;x++)
        {
          if(a[0][x]>a[1][x]){aWin+=1;}
          if(a[0][x]<a[1][x]){bWin+=1;}
        }
      if(aWin==bWin){System.out.println("D");}
      if(aWin>bWin){System.out.println("A");}
      if(aWin<bWin){System.out.println("B");}
      scan.close();
    }
}