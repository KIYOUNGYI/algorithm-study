package com.study.programmers;

public class 큰_정사각형 {

  public static int solutionNotCorrect(int[][] board) {

    int lenA = board.length;
    int ans = 0;

    int lenB = board[0].length;

    for (int a = 0; a < lenA; a++) {

      for (int b = 0; b < lenB; b++) {
//        System.out.println("a = " + a + " b = " + b);

        int cnt = 0;
        for (int size = 1; size <= lenA; size++) {



          if (a + size <= lenA && b + size <= lenB) {
//            System.out.println("size : " + size);

            for (int i = a; i < a + size; i++) {
//              System.out.println("\ti:" + i + " j:" + (b + size - 1) + " -> " + board[i][b + size - 1]);
              if (board[i][b + size - 1] == 0) {
                break;
              } else {
                cnt += 1;
              }
            }
            for (int j = 0; j < size - 1; j++) {
//              System.out.println("\ti:" + (size - 1) + " j:" + j + " ->" + board[size - 1][j]);
              if (board[size - 1][j] == 0) {
                break;
              } else {
                cnt += 1;
              }
            }
          }
//          System.out.println("cnt->"+cnt);
          if (cnt == size * size) {
            if(cnt>ans){
              ans = cnt;
            }
          }

        }
      }
    }

    return ans;
  }


  public static int solutionBadPerformance(int[][] board) {

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

    int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};

    int[][] brr = {{0, 0, 1, 1}, {1, 1, 1, 1}};

    System.out.println(solutionNotCorrect(arr));
//    System.out.println(solution(brr));

  }

}
