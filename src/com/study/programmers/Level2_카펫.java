package com.study.programmers;

import java.util.Arrays;

public class Level2_카펫 {

  public static int[] solution(int brown, int yellow) {

    int garo = yellow;
    int sero = 1;
    boolean flag = false;

    int tempSero = 0;
    int tempGaro = 0;

    for (int i = sero; ; i++) {

      if (flag) {
        break;
      }

      if (i > garo / i) {
        break;
      } else {
        if (garo % i == 0) {

//          System.out.println("sero -> " + i + " garo -> " + garo / i);
          tempSero = i;
          tempGaro = garo / i;
          //24,1
          int x = ((tempGaro + 2) * (tempSero + 2)) - yellow;
          if (x == brown) {
            break;
          }
        }
      }
    }

    int[] answer = {tempGaro + 2, tempSero + 2};
    return answer;
  }


  public static void main(String[] args) {

    int brown = 8;
    int yellow = 1;
    int[] solution = solution(brown, yellow);
    System.out.println(Arrays.toString(solution));

  }

  //public static int[] solution(int brown, int yellow) {
  //
  //    int garo = yellow;//24
  //    int sero = 1;//1
  //    boolean flag = false;
  //
  //    int tempSero = 0;
  //    int tempGaro = 0;
  //    int tempOut = 0;
  //
  //    for (int i = sero; ; i++) {
  //
  //      if (flag) {
  //        break;
  //      }
  //
  //      if (i > garo / i) {
  //        break;
  //      } else {
  //        if (garo % i == 0) {
  //
  ////          System.out.println("sero -> " + i + " garo -> " + garo / i);
  //          tempSero = i;
  //          tempGaro = garo / i;
  //          //24,1
  //
  //          int x = ((tempGaro + 2) * (tempSero + 2)) - yellow;
  //          if (x == brown) {
  //            tempOut = 2;
  //            break;
  //          }
  //
  //
  //        }
  //      }
  //    }
  //
  //    int[] answer = {tempGaro + tempOut, tempSero + tempOut};
  //    return answer;
  //  }
}
//https://programmers.co.kr/questions/12197