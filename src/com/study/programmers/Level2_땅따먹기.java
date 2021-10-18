package com.study.programmers;

public class Level2_땅따먹기 {

  static int solution(int[][] land) {

    int[][] sum = new int[land.length][4];

    sum[0][0] = land[0][0];
    sum[0][1] = land[0][1];
    sum[0][2] = land[0][2];
    sum[0][3] = land[0][3];

    if (land.length == 1) {
      return max(sum[0][0], max(sum[0][1], max(sum[0][2], sum[0][3])));
    }

    for (int i = 1; i < land.length; i++) {

      sum[i][0] = max(sum[i - 1][1], max(sum[i - 1][2], sum[i - 1][3])) + land[i][0];
      sum[i][1] = max(sum[i - 1][0], max(sum[i - 1][2], sum[i - 1][3])) + land[i][1];
      sum[i][2] = max(sum[i - 1][0], max(sum[i - 1][1], sum[i - 1][3])) + land[i][2];
      sum[i][3] = max(sum[i - 1][0], max(sum[i - 1][1], sum[i - 1][2])) + land[i][3];

    }

    int t = land.length - 1;

    return max(sum[t][0], max(sum[t][1], max(sum[t][2], sum[t][3])));
  }

  static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static void main(String[] args) {
//
    int[][] a = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
    System.out.println(solution(a));

//    int[][] b = {{1, 2, 3, 5}};
//    System.out.println(solution(b));

  }
}
