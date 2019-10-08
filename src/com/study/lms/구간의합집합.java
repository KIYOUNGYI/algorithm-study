package com.study.lms;


import java.util.Scanner;
public class 구간의합집합{
 
 public static int n;
 public static long[][] a;
 public static long target;
 public static long min;
 public static long max;
 public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   input(scan);
   findMinMax();
   if(min==max){System.out.println(min);return;}
   // System.out.println("min"+min);
   if(check(min)){System.out.println(min);return;}
   
   long s = min;
   long e = max;
   
   while(s+1<e)
   {
     long m =(s+e)/2;
     if(check(m))e=m;
     else s=m;
   }
   System.out.println(s+1);
 }
 
 public static boolean check(long x)
 {
   long cnt=0;
   for(int i=1;i<=n;i++)
   {
     if(x>a[i][2])cnt+=a[i][2]-a[i][1]+1;
     else if(x<=a[i][2] && x>=a[i][1])cnt+=x-a[i][1]+1;
   }
   
   if(cnt>=target)return true;
   else return false;
 }
 
 public static void findMinMax()
 {
   min=a[1][1];max=a[1][2];
   for(int i=1;i<=n;i++)
   {
     if(min>a[i][1])min=a[i][1];
     if(max<a[i][2])max=a[i][2];
   }
   // System.out.println("min:"+min);
 }
 
 public static void input(Scanner scan)
 {
   n = scan.nextInt();
   a = new long[n+1][3];
   for(int i=1;i<=n;i++)
   {
     for(int j=1;j<=2;j++)
     {
       a[i][j] = scan.nextLong();
     }
   }
   target = scan.nextLong();
   target = target+1;
 }
}