package com.study.bj.b2021.step1.dynamic_programming.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1912 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static int[] s;
  static int MAX;

  public static void main(String[] args) throws IOException {

    String t1 = br.readLine();
    n = Integer.parseInt(t1);
    arr = new int[n];
    s = new int[n];
    String t2 = br.readLine();
    String[] temp = t2.split(" ");
    for (int i = 0; i < temp.length; i++) {
      arr[i] = Integer.parseInt(temp[i]);
    }

    s[0] = arr[0];
    MAX = s[0];

    for (int i = 1; i < n; i++) {
      if (arr[i] + s[i - 1] > arr[i]) {
        s[i] = arr[i] + s[i - 1];
      } else {
        s[i] = arr[i];
      }

      if (s[i] > MAX) {
        MAX = s[i];
      }
    }
//    System.out.println(Arrays.toString(s));
    System.out.println(MAX);

  }
}
