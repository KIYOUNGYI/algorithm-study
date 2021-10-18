package com.study.programmers;

public class Level1_약수의_개수와_덧셈 {

  static int[] arr = new int[1001];

  public static int solution(int left, int right) {

    yaksu();
    int sum = 0;
    for (int i = left; i <= right; i++) {
      if (arr[i] % 2 == 0) {
        sum = sum + i;
      } else {
        sum = sum - i;
      }
    }
    return sum;
  }

  private static void yaksu() {

    for (int i = 1; i < 1001; i++) {

      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          arr[i] += 1;
        }
      }
    }
  }

  public static void main(String[] args) {
//    yaksu();
//    System.out.println(solution(13,17));
    System.out.println(solution(24,27));
  }
}
