package com.study.lms;

import java.util.Scanner;

//a b r (유클리드) r이 0 되면 종료 / b가 gcd

public class GCDLCM{
 public static void main(String[] args){

   Scanner scan = new Scanner(System.in);
   int a = scan.nextInt();
   int b = scan.nextInt();
   int big=0,small=0;
   if(a>b){big=a;small=b;}
   else{big=b;small=a;}
   
   int r = 1;
   while(true)
   {
     r = big%small;
     if(r==0)break;
     big = small;small=r;
   }
   // System.out.println(small);
   int gcd = small;
   int lcm = a/gcd * b/gcd * gcd;
   System.out.println(gcd+"\n"+lcm);
 }
}