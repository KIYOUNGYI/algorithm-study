package com.study.programmers;

public class Level2_가장_큰_정사각형_찾기 {

  public static int solution(int[][] board) {

    int len = board.length;

    for (int a = 0; a < len; a++) {

      for (int b = 0; b < len; b++) {


      }
      System.out.println();
    }

    int answer = 1234;
    return answer;
  }

  public static void main(String[] args) {

    int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};

    int[][] brr = {{0, 0, 1, 1}, {1, 1, 1, 1}};

    System.out.println(solution(arr));
//    System.out.println(solution(brr));

  }
}
