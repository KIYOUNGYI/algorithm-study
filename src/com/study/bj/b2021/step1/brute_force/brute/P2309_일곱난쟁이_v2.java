package com.study.bj.b2021.step1.brute_force.brute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class P2309_일곱난쟁이_v2 {

  static int[] input = new int[9];
  static int[] arr = new int[2];
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    int totalSum = 0;
    for (int i = 0; i < 9; i++) {
      input[i] = scan.nextInt();
      totalSum += input[i];
    }

    int v1 = 0, v2 = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (i == j) {
          continue;
        }
        if (totalSum - (input[i] + input[j]) == 100) {
          v1 = input[i];
          v2 = input[j];
          break;
        }
      }
    }

    List<Integer> arrList = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      int t = input[i];
      if (t != v1 && t != v2) {
        arrList.add(input[i]);
      }
    }
    Collections.sort(arrList);

    for (int i = 0; i < 7; i++) {
      System.out.println(arrList.get(i));
    }

  }
}
