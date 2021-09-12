package com.study.bj.b2021.step1.brute_force.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1759_암호_만들기_2 {

  static int n;//4
  static int m;//6
  static int[] input;
  static boolean[] v;
  static int[] answer;

  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
//    System.out.println((int) 'a');
//    System.out.println((int) 'e');
//    System.out.println((int) 'i');
//    System.out.println((int) 'o');
//    System.out.println((int) 'u');

    String temp2 = br.readLine();
    String[] s = temp2.split(" ");
    n = Integer.parseInt(s[0]);
    m = Integer.parseInt(s[1]);
    v = new boolean[m + 1];
    input = new int[m + 1];
    answer = new int[n + 1];
    String temp = br.readLine();
    String[] temp3 = temp.split(" ");
    for (int i = 0; i < temp3.length; i++) {
      int c = temp3[i].charAt(0);
      input[i] = c;
    }
    Arrays.sort(input);
    recursion(1);

    bw.flush();
    bw.close();
  }

  private static void recursion(int depth) throws IOException {

    //base case
    if (depth == n + 1) {

      if (check()) {
        printArr();
      }

      return;//must exit
    }

    if (depth == 1) {
      for (int i = 1; i <= m; i++) {
        if (!v[i]) {
          v[i] = true;
          answer[depth] = input[i];
          recursion(depth + 1);
          v[i] = false;
        }
      }
    }
    if (depth >= 2) {

      for (int i = 1; i <= m; i++) {

        if (!v[i]) {
          if (answer[depth - 1] < input[i]) {
            v[i] = true;
            answer[depth] = input[i];
            recursion(depth + 1);
            v[i] = false;
          }
        }
      }
    }
  }

  private static void printArr() throws IOException {

    for (int i = 1; i <= n; i++) {
      bw.write((char) answer[i] + "");
    }
    bw.write("\n");
  }

  private static boolean check() {

    int ja = 0;
    int mo = 0;
    for (int i = 1; i <= n; i++) {
      if (answer[i] == 97 || answer[i] == 101 || answer[i] == 105 || answer[i] == 111 || answer[i] == 117) {
        mo += 1;
      } else {
        ja += 1;
      }
    }
    return mo >= 1 && ja >= 2 ? true : false;
  }

}
