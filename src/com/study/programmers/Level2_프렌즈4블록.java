package com.study.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://programmers.co.kr/learn/courses/30/lessons/17679/solution_groups?language=java&type=all
 */
public class Level2_프렌즈4블록 {

  static boolean[][] checkArr;
  static int sero;
  static int garo;
  static int[][] arr;
  static int cnt = 0;

  public static int solution(int m, int n, String[] board) {

    sero = m;
    garo = n;
    arr = new int[sero][garo];
    checkArr = new boolean[sero][garo];

    createArr(board);

    for (int idx = 0; idx <= 1000; idx++) {

      boolean r = traverse(m, n);
      if (!r) {
        break;
      }
      shift();

      checkArr = new boolean[sero][garo];
    }

    return cnt;
  }

  private static void shift() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        if (checkArr[i][j]) {
          arr[i][j] = 0;
          cnt += 1;
        }
      }
    }

    for (int i = garo - 1; i >= 0; i--) {

      List<Integer> arrList = new ArrayList<>();

      //arrList 채워넣고 (밑에서부터 위로)
      for (int j = sero - 1; j >= 0; j--) {
        if (arr[j][i] != 0) {
          arrList.add(arr[j][i]);
        }
      }
//      System.out.println("arrList:" + arrList.toString());
      for (int j = sero - 1; j >= 0; j--) {
        arr[j][i] = 0;
      }

      int temp = sero - 1;
      for (int idx = 0; idx < arrList.size(); idx++) {

        arr[temp--][i] = arrList.get(idx);

      }

    }

  }

  private static void createArr(String[] board) {

    for (int i = 0; i < board.length; i++) {

      String x = board[i];
      for (int j = 0; j < x.length(); j++) {
        arr[i][j] = x.charAt(j);
      }

    }
  }

  private static boolean traverse(int m, int n) {

    boolean flag = false;

    for (int a = 0; a < m; a++) {
      for (int b = 0; b < n; b++) {

        if (arr[a][b] != 0) {
          if (decide(a, b)) {
            check(a, b);
            flag = true;
          }
        }
      }
    }

    return flag;
  }

  private static void check(int a, int b) {

    for (int i = a; i < a + 2; i++) {
      for (int j = b; j < b + 2; j++) {
        checkArr[i][j] = true;
      }
    }
  }


  private static boolean decide(int a, int b) {

    int t = arr[a][b];
    int cnt = 0;
    for (int i = a; i < a + 2; i++) {

      for (int j = b; j < b + 2; j++) {

        if (i < sero && j < garo) {
          if (arr[i][j] == t) {
            cnt += 1;
          }
        } else {
          return false;
        }
      }

    }
    return cnt == 4;

  }

  public static void main(String[] args) {
    int m1 = 4;
    int n1 = 5;
    String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    System.out.println(solution(m1, n1, board1));
//
//    int m2 = 6;
//    int n2 = 6;
//    String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
////    System.out.println(solution(m1, n1, board1));
//    System.out.println(solution(m2, n2, board2));

//    int m3 = 5;
//    int n3 = 6;
//    String[] board3 = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"};
//    System.out.println(solution(m3, n3, board3));

  }


  private static void printCheck() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(checkArr[i][j] == true ? "T " : "F ");
      }
      System.out.println();
    }
  }

  private static void printArr() {

    for (int i = 0; i < sero; i++) {
      for (int j = 0; j < garo; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

}

//A A A A A A
//B B A A T B
//B B A A T B
//J J J T A A
//J J J T A A

//AAAAAA
//BBAATB
//BBAATB
//JJJTAA
//JJJTAA