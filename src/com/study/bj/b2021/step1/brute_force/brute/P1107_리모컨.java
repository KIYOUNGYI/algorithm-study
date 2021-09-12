package com.study.bj.b2021.step1.brute_force.brute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 폭파
 */
public class P1107_리모컨 {

  static final int MAX = 600_010;
  //  static final int MAX = 8_010;
  static int[] answer = new int[MAX];
  static boolean[] possible = new boolean[MAX];
  static Scanner scan = new Scanner(System.in);
  static int target;
  static int notWorkingCount;
  static Map<Integer, Integer> notWorkingButtonMap = new HashMap<>();
  static int ans = Integer.MAX_VALUE;

  public static void main(String[] args) {

    target = scan.nextInt();
    notWorkingCount = scan.nextInt();

    for (int i = 0; i < notWorkingCount; i++) {
      int t = scan.nextInt();
      notWorkingButtonMap.put(t, t);
    }

    if (target == 100) {
      System.out.println(0);
      return;
    }

    for (int i = 0; i < MAX; i++) {
      answer[i] = Integer.MAX_VALUE;
    }
//    System.out.println(Arrays.toString(answer));
//    System.out.println("answer[103]:"+answer[103]);

    for (int i = 0; i < MAX; i++) {

      String s = Integer.toString(i);
      char[] arr = s.toCharArray();

      int size = 0;
      for (int j = 0; j < arr.length; j++) {
        int x = arr[j] - 48;
        if (notWorkingButtonMap.containsKey(x)) {
          possible[j] = false;
          break;
        } else {
          size += 1;
        }
        if (size == arr.length) {
          if (answer[i] > abs(target - i)) {
            answer[i] = abs(target - i);
            possible[i] = true;
          }
        }
      }
    }

    possible[100] = true;
    answer[100] = target - 100;

//    for (int i = 1; i <= 1000; i++) {
//      System.out.println(i + " answer[" + i + "] : " + answer[i]);
//    }

    int temp = Integer.MAX_VALUE;
    for (int j = 0; j < MAX; j++) {
      if (possible[j] && answer[j] < temp) {
        ans = answer[j];
      }
    }

//    System.out.println(ans);
    printAnswer();
  }

  private static void printAnswer() {
    int min = Integer.MAX_VALUE;
    int idx = 0;
    for (int i = 0; i < MAX; i++) {
      if (answer[i] < min) {
        min = answer[i];
        idx = i;
      }
    }
//    System.out.println(idx + " " + abs(min));
    String temp = Integer.toString(idx);
//    System.out.println();
    int candidate = temp.length() + min;
    if (abs(answer[100]) <= candidate) {
      System.out.println(abs(answer[100]));
    } else {
      System.out.println(candidate);
    }

  }

  private static int abs(int x) {
    return x > 0 ? x : -x;
  }


}
