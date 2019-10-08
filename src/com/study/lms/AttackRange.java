package com.study.lms;

import java.util.Scanner;
public class AttackRange{
    public static int n,sero,garo,range;
    public static int[][] arr;
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
     
      input(scan);
      attackRange();
      scan.close();
    }
    
    public static void attackRange()
    {
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=n;j++)
        {
          if(i==sero && j==garo){System.out.print("x ");}
          else
          {
            int x = abs(i-sero) + abs(j-garo);
            if(x<=range)
            {
              System.out.print(x+" ");
            }
            else
            {
              System.out.print(0+" ");
            }
          }
        }System.out.println();
      }
    }
    
        
    public static void input(Scanner scan)
    {
      n = scan.nextInt();
      sero = scan.nextInt();
      garo = scan.nextInt();
      range = scan.nextInt(); 
      arr = new int[sero+10][garo+10];
    }
    
    public static int abs(int x){if(x>0)return x;else return -x;}
}