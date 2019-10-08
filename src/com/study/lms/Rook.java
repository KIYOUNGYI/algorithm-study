package com.study.lms;

import java.util.Scanner;
public class Rook{
    public static int[][] arr=new int[8][8];
    public static int kingX,kingY;
    public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
      //지도입력
      //킹찾기
      //킹4방향 2 만나면 0   (3만나면 break)   
      inputMap(scan);
      rook();
      
      scan.close();
    }
    
    public static void rook()
    {
      int orgX = kingX;int orgY = kingY;
      
      for(int i=kingX-1;i>=0;i--)
      {
        if(arr[i][kingY]==3)break;
        if(arr[i][kingY]==2){System.out.println(1);return;}
      }
      for(int i=kingX+1;i<8;i++)
      {
        if(arr[i][kingY]==3)break;
        if(arr[i][kingY]==2){System.out.println(1);return;}
      }
      for(int i=kingY-1;i>=0;i--)
      {
        if(arr[kingX][i]==3)break;
        if(arr[kingX][i]==2){System.out.println(1);return;}
      }
      for(int i=kingY+1;i<8;i++)
      {
        if(arr[kingX][i]==3)break;
        if(arr[kingX][i]==2){System.out.println(1);return;}
      }
      System.out.println(0);
      
    }
    
    public static void inputMap(Scanner scan)
    {
      for(int i=0;i<8;i++)
      {
        for(int j=0;j<8;j++)
        {
          arr[i][j] = scan.nextInt();
          if(arr[i][j]==1){kingX=i;kingY=j;}
        }
      }
    }
}