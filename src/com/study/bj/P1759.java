package com.study.bj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 조합 암호만들기 https://www.acmicpc.net/problem/1759
 * [1] 조합을 센스있게 만드는 방법
 * [2] tobin을 활용하는 방법 1시간 정도 걸렸다.-_- 오랜만쓰 인풋도 껄끄러웠다. 로컬에 cheat_1759 따놨다. Arrays.sort() 이것도 있다 -_- tobin char[] arr 로 푸는게 날 뻔했나...
 */
public class P1759 {

  static boolean[] v;
  static int[] answer;
  static int[] arr;//문제 주어지는 케이스 문자열
  static int L, C;//조합,총케이스

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    L = scan.nextInt();
    C = scan.nextInt();
    scan.nextLine();
    String input = scan.nextLine();
    arr = new int[C];
    v = new boolean[C];
    answer = new int[L];
    int idx = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        continue;
      } else {
        arr[idx++] = input.charAt(i);
      }
    }
    ArrayList<Integer> arrList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    Collections.sort(arrList);
    for (int i = 0; i < arrList.size(); i++) {
      arr[i] = arrList.get(i);
    }

    recursive(0);
    scan.close();
  }

  private static void recursive(int depth) {
    if (depth == L) {
      printAnswer();
      return;
    }
    if (depth == 0) {
      for (int i = 0; i < C; i++) {
        if (!v[i]) {
          v[i] = true;
          answer[depth] = arr[i];
          recursive(depth + 1);
          v[i] = false;
        }
      }
    } else if (depth >= 1) {
      for (int i = 0; i < C; i++) {
        if (!v[i]) {
          v[i] = true;
          answer[depth] = arr[i];
          if (answer[depth - 1] < answer[depth]) {
            recursive(depth + 1);
          }
          v[i] = false;
        }
      }
    }

  }

  private static void printAnswer() {
    if (countJaMo()) {
      for (int i = 0; i < answer.length; i++) {
        System.out.print((char) answer[i]);
      }
      System.out.println();
    }
  }

  private static boolean countJaMo() {
    int j = 0;
    int m = 0;
    for (int i = 0; i < answer.length; i++) {
      if (answer[i] == (int) 'a' || answer[i] == (int) 'e' || answer[i] == (int) 'i' || answer[i] == (int) 'o' || answer[i] == (int) 'u') {
        j += 1;
      } else {
        m += 1;
      }
    }
    if (j >= 1 && m >= 2) {
      return true;
    } else {
      return false;
    }
  }

}
