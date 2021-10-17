package com.study.programmers;

/**
 * 다른 사람 풀이
 * https://programmers.co.kr/learn/courses/30/lessons/43162/solution_groups?language=java
 */
public class Level3_네트워크 {

  static int[][] staticComputers;
  static boolean[] visit;
  static int len;

  public static int solution(int n, int[][] computers) {
    len = n;
    visit = new boolean[len];
    staticComputers = computers;

    int cnt = 0;

    for (int idx = 0; idx < len; idx++) {

      if (!visit[idx]) {
        cnt += 1;
        visit[idx] = true;
        dfs(idx, 1);
        //visit[idx] = false;
      }

    }

    return cnt;
  }

  private static void dfs(int idx, int sum) {

    //base case (다 방문했단 뜻)
    if (sum == len) {
      return;
    }

    for (int i = 0; i < len; i++) {

      if (i != idx) {
        if (!visit[i] && staticComputers[idx][i] == 1 && staticComputers[i][idx] == 1) {
          visit[i] = true;
          dfs(i, sum + 1);
        }
      }
    }
  }

  public static void main(String[] args) {

    int[][] arr1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int[][] arr2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

    System.out.println(solution(3, arr1));
    System.out.println(solution(3, arr2));
  }

}
