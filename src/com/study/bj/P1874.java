package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class P1874 {

  static boolean flag = false;
  static int N;
  static int[] arr;
  static ArrayList<String> answer = new ArrayList<>();

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    N = scan.nextInt();
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextInt();
    }
    solution();
    scan.close();
  }

  public static void solution() {
    Stack<Integer> s = new Stack<>();
    int idx = 1;
    int ptr = 0;
    while (ptr < N) {
      int std = arr[ptr];

      if (!s.isEmpty() && s.peek() > arr[ptr]) {
        flag = true;
        break;
      }

      if (s.isEmpty() || s.peek() == null || s.peek() != std) {
        s.push(idx++);
        answer.add("+");
      } else if (s.peek() != null && s.peek() == std) {
        s.pop();
        answer.add("-");
        ptr += 1;
      }
    }
    if (flag) {
      System.out.println("NO");
      return;
    }

    for (int i = 0; i < answer.size(); i++) {
      System.out.println(answer.get(i));
    }
  }
}
