package com.study.programmers.twotwo.levelone;

public class 하샤드수 {

  public static boolean solution(int x) {

    String s = String.valueOf(x);
    String[] split = s.split("");
    int[] a = new int[split.length];
    for (int i = 0; i < split.length; i++) {
      a[i] = Integer.parseInt(split[i]);
    }

    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return x % sum == 0;
  }

  public static void main(String[] args) {

    System.out.println(solution(10));
    System.out.println(solution(11));
    System.out.println(solution(12));
    System.out.println(solution(13));
  }
}
