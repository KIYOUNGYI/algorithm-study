package com.study.lms;
import java.util.Scanner;


public class 구슬게임{
  public static final int MAX = 1000020;
  public static boolean[] d = new boolean[MAX];
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    d[0]=true;
    for(int i=1;i<MAX;i++)
      if(i%4==0)d[i]=true;
    
    if(d[n]==true){System.out.println("NO");}
    else{System.out.println("YES");}
  }   
}