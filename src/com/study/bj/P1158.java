package com.study.bj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 * [1] 큐로 풀었다.
 * [2] bfs 로도 가능한가?
 * [3] 배열을 계속 이어붙여서 풀면 가능하긴 할 거 같은데 공간이 모든 케이스를 커버 칠 수 있는진 의문이다. 이걸 굳이 깊게 고민하면서 risk를 감수하고 싶진 않다.
 * [4] 원형 연결리스트로?
 */
public class P1158 {

  static ArrayList<Integer> arrayList = new ArrayList<>();
  static int n, k;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    k = scan.nextInt();
    solution();
    print();
  }

  private static void solution() {
    Queue<Integer> q = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
          q.add(i);
      }
    int temp = 0;
    while (!q.isEmpty()) {
      temp += 1;
      if (temp == k) {
        int x = q.poll();
        arrayList.add(x);
        temp = 0;
      } else {
        int y = q.poll();
        q.add(y);
      }
    }
  }

  private static void print() {
    System.out.print("<");
    for (int i = 0; i < arrayList.size() - 1; i++) {
      System.out.print(arrayList.get(i) + ", ");
    }
    System.out.print(arrayList.get(arrayList.size() - 1));
    System.out.print(">");
  }
}
