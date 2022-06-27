package com.study.programmers.december;

import java.util.Arrays;

public class Solution1 {


  static int[] dx = {0, 0, 1};
  static int[] dy = {1, -1, 0};
  static char[][] myMap;
  static int sero;
  static int garo;

  public static int solution(String[] drum) {

    garo = drum[0].length();
    sero = drum.length;
//    System.out.println("garo = " + garo);
//    System.out.println("sero = " + sero);

    myMap = new char[sero + 1][garo];

    for (int i = 0; i < sero; i++) {
      String s = drum[i];
      for (int j = 0; j < s.length(); j++) {
        myMap[i][j] = s.charAt(j);
      }
    }
    //    System.out.println(Arrays.deepToString(myMap));

    int cnt = 0;

    for (int start = 0; start < garo; start++) {

      int pivotX = 0;
      int pivotY = start;
      int starCnt = 0;

      while (true) {

        if (myMap[pivotX][pivotY] == '#') {
          //아래
          pivotX = pivotX + 1;
        } else if (myMap[pivotX][pivotY] == '>') {
          //오른쪽
          pivotY = pivotY + 1;
        } else if (myMap[pivotX][pivotY] == '<') {
          //왼쪽
          pivotY = pivotY - 1;
        } else if (myMap[pivotX][pivotY] == '*') {
          if (starCnt == 1) {
            break;
          } else {
            //아래
            starCnt += 1;
            pivotX = pivotX + 1;
          }
        }
        if (pivotX == sero) {
          cnt += 1;
          break;
        }
      }


    }


    return cnt;
  }

  public static void main(String[] args) {

    String[] x = {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"};
    System.out.println(solution(x));
  }
}
