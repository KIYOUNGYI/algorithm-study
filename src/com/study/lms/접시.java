//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Arrays;
//import java.util.ArrayList;
//public class 접시
//{
//    public static void main(String[] args)
//    {
//      Scanner scan = new Scanner(System.in);
//      ArrayList<String> ans = new ArrayList();
//      String x = scan.nextLine();
//      int len = x.length();
//      Stack s = new Stack(100);
//      int[] a = new int[len];
//      for(int i=0;i<len;i++)a[i]=x.charAt(i)-97;
//      // System.out.println(Arrays.toString(a));
//
//      int cursor=0;int v=0;
//      while(cursor<len)
//      {
//        if(s.peek()==-1 || s.peek()!=a[cursor])
//        {
//          int r = s.push(v);v+=1;ans.add("push");
//          if(r==-1){System.out.println("impossible");return;}
//        }
//        else if(s.peek()==a[cursor])
//        {
//          int r = s.pop();cursor+=1;ans.add("pop");
//          if(r==-1){System.out.println("impossible");return;}
//        }
//      }
//      for(int i=0;i<ans.size();i++)
//      {
//        System.out.println(ans.get(i));
//      }
//
//
//      scan.close();
//    }
//}
//
//class Stack
//{
//  int ptr;
//  int len;
//  int[] arr;
//  public Stack(int n)
//  {
//    arr = new int[n];
//    len = n;
//    ptr = -1;
//  }
//
//  public int push(int x)
//  {
//    if(ptr==len-1)return -1;
//    ptr+=1;
//    arr[ptr]=x;
//    return 0;
//  }
//  public int pop()
//  {
//    if(ptr<0)return -1;
//    ptr-=1;
//    return 0;
//  }
//  public int peek()
//  {
//    if(ptr<0)return -1;
//    return arr[ptr];
//  }
//}