package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level1_두_개_뽑아서_더하기 {

  public static int[] solution(int[] numbers) {

    List<Integer> arrList = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {

      for (int j = 0; j < numbers.length; j++) {
        if (i == j) {
          continue;
        }

        if (!arrList.contains(numbers[i] + numbers[j])) {
          arrList.add(numbers[i] + numbers[j]);
        }

      }
    }
    Collections.sort(arrList);

    int[] answer = new int[arrList.size()];
    for (int i = 0; i < arrList.size(); i++) {
      answer[i] = arrList.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] x = {5, 0, 2, 7};
    System.out.println(Arrays.toString(solution(x)));
  }
}
