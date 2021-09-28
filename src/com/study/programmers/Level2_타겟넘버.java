package com.study.programmers;

import java.util.Arrays;

/**
 * bit 마스크로 품
 * 프로그래머스에서 dfs, bfs 로 푼 식들 쓱 훓어보자 (시간 나면)
 */
public class Level2_타겟넘버 {

  static int[] bit;
  static int limit;
  static int cnt = 0;

  public static int solution(int[] numbers, int target) {

    int len = numbers.length;
    bit = new int[len];

    for (int i = 0; i <= len; i++) {

      limit = i;
      tobin(0, 0, target, numbers);

    }

    return cnt;
  }

  public static void tobin(int depth, int sum, int target, int[] numbers) {

    if (sum == limit) {
      System.out.println(Arrays.toString(bit));

      int tempSum = 0;

      for (int i = 0; i < bit.length; i++) {

        if (bit[i] == 1) {
          tempSum = tempSum + numbers[i];
        } else {
          tempSum = tempSum - numbers[i];
        }
      }
//      System.out.println("tempSum:"+tempSum);
      if(tempSum==target){
        cnt+=1;
      }

      return;
    }

    if (depth == bit.length) {
      return;
    }

    bit[depth] = 1;
    tobin(depth + 1, sum + 1, target, numbers);
    bit[depth] = 0;
    tobin(depth + 1, sum, target, numbers);
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 1, 1};
    int target = 3;
    System.out.println(solution(a, target));
  }
}
