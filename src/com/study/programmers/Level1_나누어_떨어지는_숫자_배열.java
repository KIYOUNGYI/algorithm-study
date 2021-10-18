package com.study.programmers;

public class Level1_나누어_떨어지는_숫자_배열 {

  public int[] divisible(int[] arr, int divisor) {
    // ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        count++;
      }
    }

    int[] ret = new int[count];

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] % divisor != 0) {
        ret[arr[i] / divisor] = arr[i + 1];
      }
    }

    return ret;

  }

}
