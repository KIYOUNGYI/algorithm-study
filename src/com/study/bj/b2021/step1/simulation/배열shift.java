package com.study.bj.b2021.step1.simulation;

import java.util.Arrays;

public class 배열shift {

  public static void main(String[] args) {

    //왼쪽 shift
    int[] a = {1, 2, 3, 4, 5};
    int[] temp = new int[5];

//    for (int i = 0; i < 5; i++) {
//      temp[i] = a[abs(i+1)%5];
//    }
//    System.out.println(Arrays.toString(temp));

    int shift = 2;

    //오른쪽 shift

    for (int i = 0; i < 5; i++) {
      temp[(i + shift) % 5] = a[i];
    }
    System.out.println(Arrays.toString(temp));

  }

  private static int abs(int a) {
    return a > 0 ? a : -a;
  }
}
