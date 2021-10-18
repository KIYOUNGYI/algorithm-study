package com.study.programmers;

import java.util.Arrays;

/**
 * 어렵네
 */
public class Level2_가장_큰_수 {

  public static String solution(int[] numbers) {

    int len = numbers.length;

    String[] temp = new String[len];

    for (int i = 0; i < len; i++) {
      temp[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(temp);

    System.out.println(Arrays.toString(temp));


    String answer = "";
    return answer;
  }


  public static void main(String[] args) {

    int[] a1 = {6, 10, 2};
    System.out.println(solution(a1));

    int[] a2 = {3, 30, 34, 5, 9};
    System.out.println(solution(a2));
  }
}
