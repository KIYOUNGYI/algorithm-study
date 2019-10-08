package com.study.lms;
import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner scan = new Scanner(System.in);
       
       int n = scan.nextInt();
       if(n==0){System.out.println(0);return;}
       if(n==1){System.out.println(1);return;}       
       int[] arr = new int[n+1];
       arr[0]=0;
       arr[1]=1;
       
       
       
       for(int i=2;i<=n;i++)
       {
         arr[i]=arr[i-1]+arr[i-2];
       }
       System.out.println(arr[n]);
       scan.close();
    }
}