package com.study.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 소수경로 https://www.acmicpc.net/problem/1963로 숫자 뺑뺑이 돌리는 부분 구현이 쉽지는 않다. 1시간 넘게 소요된듯?
 */
public class P1963 {

  static final int limit = 10020;
  public static boolean[] isPrime = new boolean[limit];
  public static boolean[] visited = new boolean[limit];
  public static int[] score = new int[limit];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    initPrime();
    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      initScoreAndVisited();
      String x = scan.next();
      String y = scan.next();
//            System.out.println(x+" "+y);
      problem(x, y);
      if (score[Integer.parseInt(y)] == -1) {
        System.out.println("Impossible");
      } else {
        System.out.println(score[Integer.parseInt(y)]);
      }
    }

  }

  public static void problem(String input1, String input2) {
    if (input1 == input2) {
      return;
    }

    Queue<Integer> q = new LinkedList<>();
    int f = Integer.parseInt(input1);
    int e = Integer.parseInt(input2);
    q.add(f);
    visited[f] = true;
    score[f] = 0;

    while (!q.isEmpty()) {
      int pivot = q.poll();
      if (pivot == e) {
        return;
      }
      int a = pivot / 1000;//1
      int a1 = pivot % 1000;//234
      int b = (a1) / 100;//2
      int b1 = (a1) % 100;//34
      int c = (b1) / 10;//3
      int d = (b1) % 10;//4
      mark(q, pivot, a, b, c, d);
    }
  }

  private static void mark(Queue<Integer> q, int pivot, int a, int b, int c, int d) {
    for (int i = 1; i <= 9; i++) {
      if (i == a) {
        continue;
      } else {
        int t = i * 1000 + 100 * b + 10 * c + 1 * d;
        if (isPrime[t] && visited[t] == false) {
          q.add(t);
          visited[t] = true;
          score[t] = score[pivot] + 1;
        }
      }
    }
    for (int j = 0; j <= 9; j++) {
      if (j == b) {
        continue;
      }
      int t = a * 1000 + j * 100 + c * 10 + 1 * d;
      if (isPrime[t] && visited[t] == false) {
        q.add(t);
        visited[t] = true;
        score[t] = score[pivot] + 1;
      }
    }
    for (int j = 0; j <= 9; j++) {
      if (j == c) {
        continue;
      }
      int t = a * 1000 + b * 100 + j * 10 + 1 * d;
      if (isPrime[t] && visited[t] == false) {
        q.add(t);
        visited[t] = true;
        score[t] = score[pivot] + 1;
      }
    }
    for (int j = 0; j <= 9; j++) {
      if (j == d) {
        continue;
      }
      int t = a * 1000 + b * 100 + c * 10 + 1 * j;
      if (isPrime[t] && visited[t] == false) {
        q.add(t);
        visited[t] = true;
        score[t] = score[pivot] + 1;
      }
    }
  }

  public static void initPrime() {
    for (int i = 1; i < limit; i++) {
      isPrime[i] = true;
    }
    isPrime[1] = false;
    for (int i = 2; i < limit; i++) {
      for (int j = i + i; j < limit; j = j + i) {
        isPrime[j] = false;
      }
    }
  }

  public static void initScoreAndVisited() {
    for (int i = 0; i < limit; i++) {
      visited[i] = false;
      score[i] = -1;
    }
  }
}
