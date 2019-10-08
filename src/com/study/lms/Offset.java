package com.study.lms;

import java.util.Scanner;

//주변 10 초기화
//4방향 탐색 (원소가) 동서남북보다 작으면 별표 출력 / 아니면 숫자 출력

public class Offset{
 public static int[][] map = new int[7][7];
 public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   
   input(scan);
   init();
   offset();      
   scan.close();
 }
 
 public static void offset()
 {
   for(int i=1;i<=5;i++)
   {
     for(int j=1;j<=5;j++)
     {
       if(map[i-1][j]>map[i][j] && map[i+1][j]>map[i][j] 
       &&map[i][j+1]>map[i][j] && map[i][j-1]>map[i][j])
       {
         System.out.print("* ");
       }
       else
       {
         System.out.print(map[i][j]+" ");
       }
     }System.out.println();
   }
 }
 
 public static void init()
 {
   for(int i=0;i<7;i++){map[i][0]=10;map[0][i]=10;map[6][i]=10;map[i][6]=10;}
 }
 
 public static void input(Scanner scan)
 {
   for(int i=1;i<=5;i++)
   {
     for(int j=1;j<=5;j++)
     {
       map[i][j] = scan.nextInt();
     }
   }
 }
}