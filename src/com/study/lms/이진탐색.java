package com.study.lms;

import java.util.Scanner;
//s <- 찾고자 하는 값보다 작은 값
//e <- 찾고자 하는 값보다 큰 값
public class 이진탐색{
 public static int n,q;
 public static int[] arr;
 public static int[] qrr;
 public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   input(scan);
   for(int i=0;i<q;i++)
   {
     bSearch(qrr[i]);
   }
   scan.close();
 }
 public static void bSearch(int x)
 {
   int s = 0;
   int e = arr.length-1;
   if(arr[s]==x || arr[e]==x){System.out.println("YES");return;}
   if(arr[s]>x || arr[e]<x){System.out.println("NO");return;}
   
   while(s+1<e)
   {
     int m = (s+e)/2;
     // System.out.println("m:"+m);
     if(arr[m]==x){System.out.println("YES");return;}
     else if(arr[m]<x)
     {
       s=m;
     }
     else
     {
       e=m;
     }
   }
   System.out.println("NO");
 }
 
 public static void input(Scanner scan)
 {
   n = scan.nextInt();
   q= scan.nextInt();
   arr = new int[n];
   qrr = new int[q];
   for(int i=0;i<n;i++)arr[i]=scan.nextInt();
   for(int i=0;i<q;i++)qrr[i]=scan.nextInt();
 }
 

}
