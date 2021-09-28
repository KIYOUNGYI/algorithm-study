//package com.study.lms;
//
//import java.util.Scanner;
//public class 원형큐구현하기
//{
//    public static void main(String[] args)
//    {
//      Scanner scan = new Scanner(System.in);
//      int n = scan.nextInt(); int m = scan.nextInt();
//      Queue q = new Queue(n);
//      for(int i=1;i<=m;i++)
//      {
//        int x = scan.nextInt();
//        if(x==1)
//        {
//          int y = scan.nextInt();
//          int r = q.push(y);
//          if(r==-1){System.out.println("Overflow");}
//        }
//        else if(x==2)
//        {
//          int r= q.pop();
//          if(r==-1){System.out.println("Underflow");}
//        }
//        else if(x==3)
//        {
//          int r = q.peek();
//          if(r==-1){System.out.println("NULL");}
//          else{System.out.println(r);}
//        }
//      }
//
//      scan.close();
//    }
//}
//
//class Queue
//{
//  int len;
//  int cnt;
//  int[] a;
//  int f;int r;
//
//  public Queue(int n)
//  {
//    len = n;
//    a = new int[n];
//    f=0;r=0;cnt=0;
//  }
//  public int push(int x)
//  {
//    if(cnt>=len){return -1;}
//    a[r]=x;
//    r=(r+1)%len;
//    cnt+=1;
//    return 0;
//  }
//  public int pop()
//  {
//    if(cnt<=0){return -1;}
//    a[f]=0;
//    f=(f+1)%len;
//    cnt-=1;
//    return 0;
//  }
//  public int peek()
//  {
//    if(cnt<=0)return -1;
//
//    return a[f];
//  }
//}