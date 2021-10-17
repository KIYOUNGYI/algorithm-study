package com.study.programmers;

public class Level2_최대값과_최소값 {

  public static String solution(String s) {

    String[] s1 = s.split(" ");
    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;

    for (int i = 0; i < s1.length; i++) {
      long t = Long.parseLong(s1[i]);
      if (min > t) {
        min = t;
      }
      if (max < t) {
        max = t;
      }
    }

    String answer = Long.toString(min) + " " + Long.toString(max);
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("1 2 3 4"));
    System.out.println(solution("-1 -2 -3 -4"));
    System.out.println(solution("-1 -1"));
  }

}
