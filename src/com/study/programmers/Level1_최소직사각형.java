package com.study.programmers;

import java.util.Arrays;

public class Level1_최소직사각형 {

  public static int solution(int[][] sizes) {

    int len = sizes.length;
    int[] big = new int[len];
    int[] small = new int[len];

    for (int i = 0; i < sizes.length; i++) {

      if (sizes[i][0] < sizes[i][1]) {
        big[i] = sizes[i][1];
        small[i] = sizes[i][0];
      } else {
        big[i] = sizes[i][0];
        small[i] = sizes[i][1];
      }
    }

    Arrays.sort(big);
    System.out.println(Arrays.toString(big));
    Arrays.sort(small);
    System.out.println(Arrays.toString(small));

    return small[len - 1]*big[len - 1];
  }

  public static void main(String[] args) {

    int[][] a1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    int[][] a2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    int[][] a3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

    System.out.println(solution(a1));
    System.out.println(solution(a2));
    System.out.println(solution(a3));
  }
}
