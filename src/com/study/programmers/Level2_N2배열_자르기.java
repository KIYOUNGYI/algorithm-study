package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_N2배열_자르기 {


  static long[][] arr;

//  public static int[] solution(int n, long left, long right) {
//
//    arr = new int[n][n];
//
//    for (int i = 0; i < n; i++) {
//
//      for (int x = 0; x < i + 1; x++) {
//        arr[x][i] = i + 1;
//      }
//
//      for (int y = 0; y < i; y++) {
//        arr[i][y] = i + 1;
//      }
//    }
//
//    List<Integer> brrList = new ArrayList<>();
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//
//        brrList.add(arr[i][j]);
//
//      }
//    }
//
//    List<Integer> arrList = new ArrayList();
//    for (int i = (int) left; i <= right; i++) {
//      arrList.add(brrList.get(i));
//    }
//
//    return arrList.stream().mapToInt(i -> i).toArray();
//  }


//  public static int[] solution(int n, long left, long right) {
//
//    arr = new int[n][n];
//
//    for (int i = 0; i < n; i++) {
//
//      for (int x = 0; x < i + 1; x++) {
//        arr[x][i] = i + 1;
//      }
//
//      for (int y = 0; y < i; y++) {
//        arr[i][y] = i + 1;
//      }
//    }
//
//    int[] brr = new int[n * n];
//    int idx = 0;
//
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < n; j++) {
//
//        brr[idx++] = arr[i][j];
//
//      }
//    }
//
//    List<Integer> arrList = new ArrayList();
//    for (int i = (int) left; i <= right; i++) {
//      arrList.add(brr[i]);
//    }
//
//    return arrList.stream().mapToInt(i -> i).toArray();
//  }


  public static int[] solution(int n, long left, long right) {

    arr = new long[n][n];

    for (int i = 0; i < n; i++) {

      for (int x = 0; x < i + 1; x++) {
        arr[x][i] = i + 1;
      }

      for (int y = 0; y < i; y++) {
        arr[i][y] = i + 1;
      }
    }

    long[] brr = new long[n * n];
    int idx = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        brr[idx++] = arr[i][j];

      }
    }

    List<Long> arrList = new ArrayList();
    for (int i = (int) left; i <= right; i++) {
      arrList.add(brr[i]);
    }
    long[] longs = arrList.stream().mapToLong(i -> i).toArray();
    int[] ints = new int[longs.length];
    for(int i=0;i<ints.length;i++){
      ints[i] = (int)longs[i];
    }
    return ints;
  }

  public static void main(String[] args) {

//    int n1 = 3;
//    int left1 = 2;
//    int right1 = 5;
//    System.out.println(Arrays.toString(solution(n1, left1, right1)));

    int n2 = 4;
    int left2 = 7;
    int right2 = 14;

    System.out.println(Arrays.toString(solution(n2, left2, right2)));

  }
}
