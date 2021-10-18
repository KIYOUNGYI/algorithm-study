package com.study.programmers;

import java.util.Arrays;

public class Level1_K번째_수 {

  public static int[] solution(int[] array, int[][] commands) {

    int commandLen = commands.length;
    int[] answer = new int[commandLen];

    for (int idx = 0; idx < commandLen; idx++) {

      int[] command = commands[idx];
      int i = command[0];
      int j = command[1];
      int k = command[2];

      int len = j - i + 1;
      int[] temp = new int[len];
      int x = 0;
      for (int a = i - 1; a < j; a++) {
        temp[x++] = array[a];
      }
      Arrays.sort(temp);

      answer[idx] = temp[k - 1];
    }

    return answer;
  }


  public static void main(String[] args) {

    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    System.out.println(Arrays.toString(solution(array, commands)));

  }
}
