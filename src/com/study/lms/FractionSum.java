package com.study.lms;

import java.util.Scanner;
public class FractionSum{
    public static void main(String[] args){
      Scanner scan = new Scanner(System.in);

      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();
      int d = scan.nextInt();
      
      int bunmo = b*d;
      int bunja1 = a*d;
      int bunja2 = c*b;
      
      int bunjaHap = bunja1+bunja2;
      int x = lcm(bunjaHap,bunmo);
      
      if(x==1){System.out.println(bunjaHap+" "+bunmo);return;}
      else
      {
        bunjaHap = bunjaHap/x;
        bunmo = bunmo/x;
        System.out.println(bunjaHap+" "+bunmo);
      }

      scan.close();
    }
    
    public static int lcm(int x,int y)
    {
      int big = 0;int small = 0;
      
      if(x>y){big = x;small=y;}
      else{big=y;small=x;}
      
      int r=1;
      while(r!=0)
      {
        r=big%small;
        if(r==0)break;
        big=small;
        small=r;
      }
      // System.out.println(small);
      return small;
    }
}