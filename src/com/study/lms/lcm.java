//package com.study.lms;
//
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//
//      Scanner scan = new Scanner(System.in);
//
//      long a = scan.nextLong();
//      long b = scan.nextLong();
//      long small = 0l;
//      long big = 0l;
//
//      if(a<b) {small=a;big=b;}
//      else {small=b;big=a;}
//      // System.out.println(big+" "+small);
//      long r = 1;
//      while(r!=0)
//      {
//        r=big%small;
//        if(r==0)break;
//
//        big=small;
//        small=r;
//
//      }
//      // System.out.println(small);
//
//      System.out.println((a*b)/small );
//
//      scan.close();
//    }
//}