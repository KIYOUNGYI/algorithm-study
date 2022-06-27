package com.study.programmers.twotwo.levelone;

public class 콜라츠_추측 {

  public static int solution(int x) {

    if (x == 1) {
      return 0;
    }

    long num = x;

    for (int i = 1; i <= 500; i++) {
      if (num % 2 == 0) {
        num = num / 2;
      } else {
        num = num * 3 + 1;
      }
      if (num == 1) {
        return i;
      }
    }

    if (num == 1) {
      return 500;
    } else {
      return -1;
    }
  }


  public static void main(String[] args) {

  }
}
