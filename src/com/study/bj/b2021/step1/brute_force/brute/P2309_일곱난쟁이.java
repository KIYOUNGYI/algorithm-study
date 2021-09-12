package com.study.bj.b2021.step1.brute_force.brute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class P2309_일곱난쟁이 {

  static boolean flag = true;
  static int[] input = new int[9];
  static List<Integer> arrList = new ArrayList<>();
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    for (int i = 0; i < 9; i++) {
      input[i] = scan.nextInt();
    }

    dfs(0, 0);

  }

  private static int sum() {
    int sum = 0;
    int size = arrList.size();
    for (int i = 0; i < size; i++) {
      int idx = arrList.get(i);
      sum += input[idx];
    }
    return sum;
  }

  private static void dfs(int depth, int value) {

    if (!flag) {
      return;
    }

    if (depth == 7) {
      if (sum() == 100) {
        printArr();
        flag = false;
      }
      return;
    }

    if (value == 9) {
      return;
    }

    arrList.add(value);
    dfs(depth + 1, value + 1);
    int size = arrList.size();
    arrList.remove(size - 1);
    dfs(depth, value + 1);
  }

  private static void printArr() {

    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < arrList.size(); i++) {
      int t = arrList.get(i);
//      System.out.println("t:" + t + " input[t]:" + input[t]);
      answer.add(input[t]);
    }

    Collections.sort(answer);
    for (int i = 0; i < 7; i++) {
      System.out.println(answer.get(i));
    }

  }

}
