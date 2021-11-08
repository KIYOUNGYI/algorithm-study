package com.study.programmers.weekly.week12;

public class Solution {

  static int max = 0;
  static int score = 0;
  static boolean[] visit;
  static int len;

  public static int solution(int k, int[][] dungeons) {

    len = dungeons.length;
    visit = new boolean[len];

    f(k, 0, dungeons);

    return max;
  }

  private static void f(int k, int depth, int[][] dungeons) {

    if (score > max) {
      max = score;
    }

    // if (depth == len) {
    //   return;
    // }

    for (int i = 0; i < len; i++) {

      if (!visit[i] && dungeons[i][0] <= k) {

        score += 1;
        visit[i] = true;
        f(k - dungeons[i][1], depth + 1, dungeons);
        visit[i] = false;
        score -= 1;
      }
    }

  }


  private static void f2(int k, int cnt, int[][] dungeons) {

    for (int i = 0; i < len; i++) {
      if (!visit[i] && dungeons[i][0] <= k) {

        visit[i] = true;
        f(k - dungeons[i][1], cnt + 1, dungeons);
        visit[i] = false;

      }
    }

    max = Math.max(max, cnt);

  }


  public static void main(String[] args) {

    int k = 80;
    int[][] dungeouns = {{90, 40}, {90, 10}};
    System.out.println(solution(k, dungeouns));

  }
}
