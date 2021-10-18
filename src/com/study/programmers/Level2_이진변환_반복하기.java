package com.study.programmers;

import java.util.Arrays;

public class Level2_이진변환_반복하기 {

  public static int[] solution(String s) {

    int loopCnt = 0;
    int zeroSum = 0;

    while (!s.equals("1")) {

      int zeroCnt = 0;

      for (int i = 0; i < s.length(); i++) {

        if (s.charAt(i) == '0') {
          zeroCnt += 1;
        }
      }

      int oneCnt = (s.length() - zeroCnt);
      s = toBinStr(oneCnt);

      loopCnt += 1;
      zeroSum = zeroSum + zeroCnt;

    }

    int[] answer = {loopCnt, zeroSum};
    return answer;
  }

  private static String toBinStr(int a) {

    StringBuilder sb = new StringBuilder();

    while (a != 0) {
      sb.append(a % 2);
      a = a / 2;
    }
    String s = sb.reverse().toString();
    return s;
  }

  public static void main(String[] args) {

    System.out.println(Arrays.toString(solution("110010101001")));
    System.out.println(Arrays.toString(solution("01110")));
    System.out.println(Arrays.toString(solution("1111111")));
  }
}
