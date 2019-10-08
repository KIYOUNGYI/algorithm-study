package com.study.lms;

import java.util.Scanner;
public class mine{
    public static int[] dx = new int[]{0,1,0,-1,-1,-1,1,1};
    public static int[] dy = new int[]{1,0,-1,0,-1,1,-1,1};
    public static int sero,garo,mineX,mineY;
    public static int [][] arr;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      mine();
      scan.close();
    }
    
    public static void mine()
    {
      if(arr[mineX][mineY]==1){System.out.println("game over");return;}
      int cnt=0;
      for(int i=0;i<8;i++)
      {
        int cx = mineX+dx[i];
        int cy = mineY+dy[i];
        if(cx>=0 && cy>=0 && cx<sero && cy<garo)
        {
          if(arr[cx][cy]==1)cnt+=1;
        }
      }
      System.out.println(cnt);
    }
    
    public static void input(Scanner scan)
    {
      sero = scan.nextInt();garo =scan.nextInt();
      mineX = scan.nextInt();mineY = scan.nextInt();
      mineX = mineX-1;mineY = mineY-1;
      arr = new int[sero][garo];
      for(int i=0;i<sero;i++)
      {
        for(int j=0;j<garo;j++)
        {
          arr[i][j] = scan.nextInt();
        }
      }
    }
}
