package com.study.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질 https://www.acmicpc.net/problem/1697 개삽질쓰 배열 별도로 하나 더 사용하진 않더라도 가지치기는 필요하더라,,, 안그러면 메모리 초과 에러 뜬다.
 */
public class P1697 {

  static int[] v = new int[200040];
  static int a, b;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    a = scan.nextInt();
    b = scan.nextInt();
    bfs();
    System.out.println(v[b]);
  }

  public static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.add(a);
    v[a] = 0;
    if (a == b) {
      return;
    }

    while (!q.isEmpty()) {
      int t = q.poll();
      int t1 = t + 1;
      int t2 = t - 1;
      int t3 = 2 * t;
      if (t1 >= 0 && t1 <= 100000 && v[t1] == 0) {
        q.add(t1);
        v[t1] = v[t] + 1;
      }
      if (t2 >= 0 && t2 <= 100000 && v[t2] == 0) {
        q.add(t2);
        v[t2] = v[t] + 1;
      }
      if (t3 >= 0 && t3 <= 100000 && v[t3] == 0) {
        q.add(t3);
        v[t3] = v[t] + 1;
      }
      if (t1 == b || t2 == b || t3 == b) {
        return;
      }
    }
  }


}
