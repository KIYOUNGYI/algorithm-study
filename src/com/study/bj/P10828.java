package com.study.bj;

import java.util.Scanner;

/**
 * 스택 https://www.acmicpc.net/problem/10828 스택 라이브러리 쓰지말고 직접 스택 만드는게 속 편할걸? 문제 꼼꼼하게 읽고 첫 풀이 27분
 */
public class P10828 {

  static int top = -1;
  static int[] arr = new int[10020];
  static int N;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < N; i++) {
      String x = scan.nextLine();
      String[] s = x.split(" ");
      if (s[0].equals("push")) {
        push(Integer.parseInt(s[1]));
      } else if (s[0].equals("pop")) {
        pop();
      } else if (s[0].equals("top")) {
        top();
      } else if (s[0].equals("size")) {
        size();
      } else if (s[0].equals("empty")) {
        empty();
      }
    }
  }

  public static void push(int x) {
    //stack overflow 예외처리는 필요없음
    top += 1;
    arr[top] = x;
  }

  public static void pop() {
    if (top == -1) {
      System.out.println(-1);
      return;
    } else {
      System.out.println(arr[top]);
      arr[top] = 0;
      top -= 1;
    }
  }

  public static void top() {
    if (top == -1) {
      System.out.println(-1);
    } else {
      System.out.println(arr[top]);
    }
  }

  public static void size() {
    System.out.println((top + 1));
  }

  public static void empty() {
    if (top == -1) {
      System.out.println(1);
      return;
    } else {
      System.out.println(0);
      return;
    }
  }

}
