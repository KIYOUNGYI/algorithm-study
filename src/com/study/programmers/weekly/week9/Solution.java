package com.study.programmers.weekly.week9;

public class Solution {

  static int ans = Integer.MAX_VALUE;
  static int[][] adjMatrix;
  static boolean[] visit;
  static int total;
  static int cntTemp = 0;

  public static int solution(int n, int[][] wires) {

    adjMatrix = new int[n + 1][n + 1];
    visit = new boolean[n + 1];
    total = n;

    for (int i = 0; i < wires.length; i++) {

      int a1 = wires[i][0];
      int a2 = wires[i][1];

      adjMatrix[a1][a2] = 1;
      adjMatrix[a2][a1] = 1;

    }

    for (int i = 0; i < wires.length; i++) {

      int a1 = wires[i][0];
      int a2 = wires[i][1];

      adjMatrix[a1][a2] = 0;
      adjMatrix[a2][a1] = 0;

      visit[1] = true;
      cntTemp = 1;
      dfs(1);

      int t1 = Math.abs((Math.abs(total - cntTemp) - Math.abs(cntTemp)));
      ans = Math.min(ans, t1);

      adjMatrix[a1][a2] = 1;
      adjMatrix[a2][a1] = 1;

      visit = new boolean[n + 1];

      cntTemp = 0;


    }

    return ans;
  }

  private static void dfs(int node) {

    for (int i = 1; i <= total; i++) {

      if (adjMatrix[node][i] != 0 && !visit[i]) {

        visit[i] = true;
        cntTemp += 1;
        dfs(i);
        visit[i] = false;

      }
    }


  }

  public static void main(String[] args) {

//    int n = 9;
//    int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//    System.out.println(solution(n, wires));

    int n1 = 4;
    int[][] wires1 = {{1, 2}, {2, 3}, {3, 4}};
    System.out.println(solution(n1, wires1));

//    int n2 = 7;
//    int[][] wires2 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
//    System.out.println(solution(n2,wires2));
  }

}
