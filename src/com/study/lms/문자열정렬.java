package com.study.lms;

import java.util.Scanner;
import java.util.Arrays;

public class 문자열정렬{
    public static int n;
    public static String[] arr;
    public static void main(String[] args){

      // System.out.println((int)'Z');//65~90
      // System.out.println((int)'a');//97

       // Please Enter Your Code Here
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      arr = new String[n];
      scan.nextLine();
      for(int i=0;i<n;i++){arr[i]=scan.nextLine();}
      for(int i=0;i<n;i++)
      {
        arr[i]=arr[i].toLowerCase();
      }
      for(int i=0;i<n;i++)
      {
        arr[i]=arr[i].toLowerCase();
      }
      
      // for(int i=0;i<n;i++)
      // {
      //   for(int j=0;j<arr[i].length();j++)
      //   {
      //     if((int)arr[i].charAt(j)<=90)
      //     {
      //       arr[i].charAt(j) = (int)arr[i].charAt(j)+32; 
      //     }
      //   }
      // }
      

      
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<=n-i-2;j++)
        {
          int result = compare(arr[j],arr[j+1]);
          if(result==1)
          {
            String temp = arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
          }
        }
      }
      
      for(int i=0;i<n;i++)
      {
        System.out.println(arr[i]);
      }
      
      scan.close();
    }
    
    public static int compare(String a,String b)
    {
      int aLen = a.length();
      int bLen = b.length();
      if(aLen==bLen)
      {
        for(int i=0;i<aLen;i++)
        {
          if((int)a.charAt(i)>(int)b.charAt(i))return 1;
          if((int)a.charAt(i)<(int)b.charAt(i))return 0;
        }
        return 0;
      }
      
      int small = 0;
      if(aLen>bLen)small=bLen;
      else small = aLen; 
      
      for(int i=0;i<small;i++)
      {
        if((int)a.charAt(i)>(int)b.charAt(i))return 1;
        if((int)a.charAt(i)<(int)b.charAt(i))return 0;
      }  
    
      if(aLen>bLen) return 1;
      else return 0;
      
    }
}
