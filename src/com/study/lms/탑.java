//package com.study.lms;
//
//import java.util.Scanner;
//import java.util.Stack;
//public class 탑{
//    // n을 입력받는다.
//    // a[n+1]만든다.
//    // a[] (1~n) 입력받는다.
//    // for(i n-1 ~ 1)
//    //  [1]스택이 비어있음 (idx,height)를 집어넣는다.
//    //  [2]그게 아니면
//    //     스택에 있는 것(peek)의 높이와 현재(arr[i]의 값을 비교)
//    //     arr[i]의 값이 높다면 pop 하고 pop한 원소의 인덱스가 현재것을 가리켜야 한다.
//    //     그게 아니면 push() 한다.
//    //  score 출력
//
//    public static int n;
//    public static int[] arr;
//    public static int[] score;
//    public static void main(String[] args){
//
//      Scanner scan = new Scanner(System.in);
//      n = scan.nextInt();
//      arr = new int[n+1];
//      score = new int[n+1];
//
//      for(int i=1;i<=n;i++){arr[i]=scan.nextInt();}
//
//      top();
//
//      printScore();
//
//      scan.close();
//    }
//
//    public static void top()
//    {
//      Stack<Point> s = new Stack();
//      int cursor = n;
//
//      while(cursor!=0)
//      {
//        if(s.isEmpty())
//        {
//          Point p = new Point(cursor,arr[cursor]);
//          s.push(p);
//          cursor-=1;
//        }
//        else
//        {
//          Point p = s.peek();
//          // System.out.println("p:"+p.toString());
//          if(p.height<=arr[cursor])
//          {
//            s.pop();
//            score[p.idx]=cursor;
//          }
//          else
//          {
//            Point pt = new Point(cursor,arr[cursor]);
//            s.push(pt);
//            cursor-=1;
//          }
//        }
//      }
//
//    }
//
//    public static void printScore()
//    {
//      for(int i=1;i<=n;i++)
//      {
//        System.out.print(score[i]+" ");
//      }System.out.println();
//    }
//}
//
//
//
//class Point
//{
//  int idx;
//  int height;
//
//  public Point(int idx,int height)
//  {
//    this.idx = idx;
//    this.height = height;
//  }
//  @Override
//  public String toString()
//  {
//    return "idx:"+idx+" height:"+height;
//  }
//}