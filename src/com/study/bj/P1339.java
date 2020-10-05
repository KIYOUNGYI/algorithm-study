package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 단어 수학
 * https://www.acmicpc.net/problem/1339
 */

public class P1339 {

  static int MAX = Integer.MIN_VALUE;
  static int n;

  static boolean[] visit = new boolean[10];
  static int[] alphabet = new int[26];
  static ArrayList<Character> arrList = new ArrayList<>();
  static int[] temp;
  static int arrLen;
  static ArrayList<String> input = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      input.add(temp);
      for (int j = 0; j < temp.length(); j++) {
        if (!arrList.contains(temp.charAt(j))) {
          arrList.add(temp.charAt(j));
        }
      }
    }
//    System.out.println(arrList.toString());
    arrLen = arrList.size();
    temp = new int[arrLen];
    johab(0);
    bw.write(MAX+"\n");
    bw.close();
  }

  public static void calculate() {
    int sum = 0;
    for (int i = 0; i < input.size(); i++) {
      String temp = input.get(i);
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < temp.length(); j++) {
        int t = alphabet[temp.charAt(j) - 65];
        sb.append(t);
      }
      int x = Integer.parseInt(sb.toString());
      sum += x;
    }
    if (MAX < sum) {
      MAX = sum;
    }
  }

  public static void mapping() {
    for (int i = 0; i < arrList.size(); i++) {
      alphabet[arrList.get(i) - 65] = temp[i];
    }
//    System.out.println("alphabet:"+Arrays.toString(alphabet));
  }

  public static void johab(int depth) {
    if (arrLen == depth) {
//      System.out.println(Arrays.toString(temp));
      mapping();
      calculate();
      return;
    }

    for (int i = 9; i >= 9 - arrLen + 1; i--) {
      if (!visit[i]) {
        visit[i] = true;
        temp[depth] = i;
        johab(depth + 1);
        visit[i] = false;
      }
    }
  }
}
