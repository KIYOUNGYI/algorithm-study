package com.study.bj.b2021.middleclass1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class P16928_뱀과_사다리_게임 {

  static boolean flag = false;
  static int n, m;
  static int[] score = new int[101];
  static Map<Integer, Integer> letter = new HashMap<>();
  static Map<Integer, Integer> snake = new HashMap<>();

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      letter.put(x, y);
    }

    for (int j = 0; j < m; j++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      snake.put(x, y);
    }

    bfs();
    System.out.println(score[100]);
  }

  private static void bfs() {

    Queue<Integer> q = new LinkedList<>();
    int s = 1;
    score[s] = 0;
    q.add(s);

    while (!q.isEmpty()) {
      if (flag) {
        return;
      }
      int poll = q.poll();
      int tempScore = score[poll];

      for (int t1 = poll + 1; t1 <= poll + 6; t1++) {

        if (t1 >= 0 && t1 <= 100 && score[t1] == 0) {

          score[t1] = tempScore + 1;

          if (t1 == 100) {
            flag = true;
            break;
          }

          if (letter.containsKey(t1)) {
            int next = letter.get(t1);
            if (score[next] == 0) {
              score[next] = score[t1];
              q.add(next);
            }
          } else if (snake.containsKey(t1)) {
            int next = snake.get(t1);
            if (score[next] == 0) {
              score[next] = score[t1];
              q.add(next);
            }
          } else {
            q.add(t1);//general case
          }

        }
      }


    }


  }
}
