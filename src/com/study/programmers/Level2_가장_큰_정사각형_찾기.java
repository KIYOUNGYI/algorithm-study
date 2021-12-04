package com.study.programmers;

public class Level2_가장_큰_정사각형_찾기 {

  public static int solution(int[][] board) {

    int lenA = board.length;
    int ans = 0;

    int lenB = board[0].length;

    for (int a = 0; a < lenA; a++) {

      for (int b = 0; b < lenB; b++) {
//        System.out.println("a = " + a + " b = " + b);
        boolean flag = false;

        for (int size = 1; size <= lenA; size++) {

          if (a + size <= lenA && b + size <= lenB) {
//            System.out.println("size : " + size);

            int lim = size * size;
            int cnt = 0;
            for (int i = a; i < a + size; i++) {
              for (int j = b; j < b + size; j++) {
//                System.out.println("\ti = " + i + " j : " + j + " board[" + i + "][" + j + "] : " + board[i][j]);
                if (board[i][j] == 1) {
                  cnt += 1;
                } else {
                  flag = true;
                  break;
                }
              }
            }
//            System.out.println("cnt : " + cnt + " lim : " + lim);
            if (cnt == lim) {
              if (ans < cnt) {
                ans = cnt;
              }
            }
          }
          if (flag) {
            break;
          }
        }
      }
    }

    int answer = ans;
    return answer;
  }

  public static void main(String[] args) {

    int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};

    int[][] brr = {{0, 0, 1, 1}, {1, 1, 1, 1}};

    System.out.println(solution(arr));
//    System.out.println(solution(brr));

  }
}
