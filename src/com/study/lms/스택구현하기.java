//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Arrays;
//
//public class 스택구현하기
//{
//    public static void main(String[] args)
//    {
//      Scanner scan = new Scanner(System.in);
//      int n = scan.nextInt();//4
//      int t = scan.nextInt();//10
//      Stack s = new Stack(n);
//      // System.out.println("t->"+t);
//      for(int i=0;i<t;i++)
//      {
//        int x = scan.nextInt();
//        if(x==1)
//        {
//          int y = scan.nextInt();
//          int r = s.push(y);
//          if(r==-1){System.out.println("Overflow");}
//        }
//        else if(x==2)
//        {
//          int r = s.pop();
//          if(r==-1){System.out.println("Underflow");}
//        }
//        else if(x==3)
//        {
//          int r = s.top();
//          if(r==-1){System.out.println("NULL");}
//          else {System.out.println(r);}
//        }
//        // System.out.println("s->"+Arrays.toString(s.arr));
//      }
//
//      scan.close();
//    }
//}
//
//class Stack
//{
//  public int[] arr;
//  int len;
//  int ptr;
//  public Stack(int n)
//  {
//    len = n;
//    arr = new int[n];
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
//  public int top()
//  {
//    if(ptr<0)return -1;
//    return arr[ptr];
//  }
//}