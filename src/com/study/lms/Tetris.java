package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

//가로,세로 입력 지도 입력
//가로축 기준 점수판 만들기
//가로축 별로 4개를 둘 수 있는지 검사 못 두면 0 
//둘 수 있으면 지도 갱신, 
//세로기준으로 세기 (가로 개수만큼 점수 있음 ㅇㅋ) 지도복구
//s[i] i값과 s[i] 출력 / 다 0이면    0 0 출력


public class Tetris{
    public static int garo,sero;
    public static int[][] arr;
    public static int[] s;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      input(scan);
      tetris();
      result();
      // System.out.println(Arrays.toString(s));
      scan.close();
    }
    
    public static void result()
    {
      int max=0;int maxIdx=0;
      for(int i=1;i<=garo;i++)
      {
        if(max<=s[i]){max=s[i];maxIdx=i;}
      }
      if(max==0){System.out.println(0+" "+0);return;}
      else{System.out.println(maxIdx+" "+max);return;}
    }
    
    public static void tetris()
    {
      for(int i=1;i<=garo;i++)
      {
        int cnt=0;
        for(int j=1;j<=sero;j++)
        {
          if(arr[j][i]==0)cnt+=1;
          if(arr[j][i]==1){break;}  
        }
        if(cnt<=3){s[i]=0;}
        else
        {
          arr[cnt][i]=1;arr[cnt-1][i]=1;arr[cnt-2][i]=1;arr[cnt-3][i]=1;
          
          int score=0;
          for(int x=1;x<=sero;x++)
          {
            int cnt2=0;
            for(int y=1;y<=garo;y++)
            {
              if(arr[x][y]==1)cnt2+=1;
            }
            if(cnt2==garo)score+=1;
          }
          s[i]=score;
          // print();
          // System.out.println("======");
          arr[cnt][i]=0;arr[cnt-1][i]=0;arr[cnt-2][i]=0;arr[cnt-3][i]=0;
        //   print();
        // System.out.println("======");
        }
        
      }
    }
    
    public static void print()
    {
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++)
        {
          System.out.print(arr[i][j]);
        }System.out.println();
      }
    }
    
    public static void input(Scanner scan)
    {
      garo = scan.nextInt();sero = scan.nextInt();
      arr = new int[sero+1][garo+10]; s = new int[garo+10];
      for(int i=1;i<=sero;i++)
      {
        for(int j=1;j<=garo;j++)
        {
          arr[i][j] = scan.nextInt();
        }
      }
    }
}
