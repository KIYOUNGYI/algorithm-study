package com.study.programmers;

public class Level2_멀쩡한_사각형 {


  public static long solution(int a, int b) {
    long w = a;
    long h = b;
    return (w * h) - (w + h - gcd(w, h));
  }

  public static long gcd(long a, long b) {

    long x = Math.max(a, b);
    long y = Math.min(a, b);

    long r = -1;

    while (x % y != 0) {
      r = x % y;
      x = y;
      y = r;
    }

    return y;
  }


  public static void main(String[] args) {
    System.out.println(gcd(9, 12));
  }
}
