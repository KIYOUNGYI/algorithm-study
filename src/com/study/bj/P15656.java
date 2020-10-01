package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (7)
 * https://www.acmicpc.net/problem/15656
 */
public class P15656 {

  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] arr;
  static int[] temp;
  static int n;
  static int r;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner scan = new Scanner(System.in);
    String[] dummy = br.readLine().split(" ");
    n = Integer.parseInt(dummy[0]);
    r = Integer.parseInt(dummy[1]);

    arr = new int[n];
    temp = new int[r];

    String[] dummy2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(dummy2[i]);
    }
    Arrays.sort(arr);
//    System.out.println(Arrays.toString(arr));
    recursive(0);
    scan.close();
    bw.close();
  }

  public static void recursive(int depth) throws IOException {
    if (depth == r) {
      for (int i = 0; i < temp.length; i++) {
//        System.out.print(temp[i] + " ");
        bw.write(temp[i] + " ");
      }
      bw.write("\n");
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      temp[depth] = arr[i];
      recursive(depth + 1);
    }
  }
}

