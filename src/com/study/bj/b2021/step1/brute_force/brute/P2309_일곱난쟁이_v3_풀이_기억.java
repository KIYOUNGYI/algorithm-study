package com.study.bj.b2021.step1.brute_force.brute;

import java.util.Arrays;
import java.util.Scanner;


public class P2309_일곱난쟁이_v3_풀이_기억 {

  static int[] arr = new int[9];
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    int totalSum = 0;
    for (int i = 0; i < 9; i++) {
      arr[i] = scan.nextInt();
      totalSum += arr[i];
    }

    Arrays.sort(arr);

    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {

//        System.out.println(i + " " + j);

        if (totalSum - (arr[i] + arr[j]) == 100) {

          for (int k = 0; k < 9; k++) {
            if (i == k || j == k) {
              continue;
            }
            System.out.println(arr[k]);
          }
          return;
        }
      }
    }


  }
}
