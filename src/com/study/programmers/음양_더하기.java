package com.study.programmers;

public class 음양_더하기 {

  public static int solution(int[] absolutes, boolean[] signs) {
    int sum = 0;
    for (int i = 0; i < signs.length; i++) {
      if (signs[i]) {
        sum += absolutes[i];
      } else {
        sum -= absolutes[i];
      }
    }

    return sum;
  }
}
