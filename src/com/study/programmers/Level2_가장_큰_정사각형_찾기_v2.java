package com.study.programmers;

/**
 * 이 문제 brute force 로 접근하면 100% 시간초과 난다.
 */
public class Level2_가장_큰_정사각형_찾기_v2 {

  private static boolean isAllZero(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static int solution(int[][] board) {

    int sero = board.length;
    int garo = board[0].length;

    if (isAllZero(board)) {
      return 0;
    }

    int answer = 1;

    for (int i = 1; i < sero; i++) {
      for (int j = 1; j < garo; j++) {

        if (board[i][j] == 0) {
          continue;
        }
        board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
        answer = Math.max(answer, board[i][j]);
      }
    }

    return answer * answer;
  }

  public static void main(String[] args) {

    int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};

    int[][] brr = {{0, 0, 1, 1}, {1, 1, 1, 1}};

    System.out.println(solution(brr));
//    System.out.println(solution(brr));

  }
}
