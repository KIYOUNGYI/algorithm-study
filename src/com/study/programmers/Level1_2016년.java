package com.study.programmers;

public class Level1_2016년 {

  static String[] arr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

  public static String solution(int a, int b) {

    int month = 1;
    int day = 1;
    int idx = 4;
    for (int i = 1; i <= 366; i++) {
      if (i == 1) {
        day = 1;
        month = 1;
      } else if (i == 31 + 1) {//2월
        day = 1;
        month = 2;
      } else if (i == 31 + 29 + 1) {//3
        day = 1;
        month = 3;
      } else if (i == 31 + 29 + 31 + 1) {//4월
        day = 1;
        month = 4;
      } else if (i == 31 + 29 + 31 + 30 + 1) {//5
        day = 1;
        month = 5;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 1) {//6
        day = 1;
        month = 6;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 1) {//7
        day = 1;
        month = 7;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 31 + 1) {//8
        day = 1;
        month = 8;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 1) {//9월 시작
        day = 1;
        month = 9;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 1) {//10월 시작
        day = 1;
        month = 10;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 1) {//11월 시작
        day = 1;
        month = 11;
      } else if (i == 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 1) {//12월 시작
        day = 1;
        month = 12;
      } else {
        day += 1;
      }

      if (a == month && b == day) {
        break;
      }
      idx = (idx + 1) % 7;
    }

//    System.out.println("idx = " + idx);

    return arr[idx];
  }

  public static void main(String[] args) {
    int a = 5;
    int b = 24;
    System.out.println(solution(a, b));
  }

}
