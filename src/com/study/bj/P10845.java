package com.study.bj;

import java.util.Scanner;

/**
 * 큐 https://www.acmicpc.net/problem/10845 front,rear 에 대해서 고민을 해보자
 */
public class P10845 {

  static int N;
  static int f = 0, r = 0;
  static int[] queue = new int[10050];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < N; i++) {
      String x = scan.nextLine();
      String[] input = x.split(" ");
      if (input[0].equals("push")) {
        push(Integer.parseInt(input[1]));
      } else if (input[0].equals("pop")) {
        pop();
      } else if (input[0].equals("size")) {
        size();
      } else if (input[0].equals("empty")) {
        empty();
      } else if (input[0].equals("front")) {
        front();
      } else if (input[0].equals("back")) {
        back();
      }
    }
    scan.close();
  }

  public static void push(int x) {
    queue[r] = x;
    r += 1;
  }

  public static void pop() {
    if (r - f <= 0) {
      System.out.println(-1);
    } else {
      System.out.println(queue[f]);
      f += 1;
    }
  }

  public static void size() {
    System.out.println(r - f);
  }

  public static void empty() {
    if (r - f > 0) {
      System.out.println(0);
    } else {
      System.out.println(1);
    }
  }

  public static void front() {
    if (r - f <= 0) {
      System.out.println(-1);
    } else {
      System.out.println(queue[f]);
    }
  }

  public static void back() {
    if (r - f <= 0) {
      System.out.println(-1);
    } else {
      System.out.println(queue[r - 1]);
    }
  }

}
