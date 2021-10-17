package com.study.programmers;

import java.util.Arrays;

public class Level1_자연수_뒤집어_배열로_만들기 {

  public static int[] solution(long n) {

    String s = String.valueOf(n);

    int[] answer = new int[s.length()];

    int idx = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      answer[idx++] = s.charAt(i) - 48;
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println((int) '1' - 48);
    System.out.println(Arrays.toString(solution(12345)));
  }

}
