package com.study.programmers.twotwo.levelone;

public class 정수제곱근_판별 {

  public static long solution(long n) {

    Double sqrt = Math.sqrt(n);
    long l = sqrt.longValue();
    if (l * l == n) {
      return (l + 1) * (l + 1);
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    long l = 50000000000000l;


  }
}
