package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 	1, 2, 3 더하기 5
 * 	다이나믹 프로그래밍
 * 	https://www.acmicpc.net/problem/15990
 * 	재귀로 풀면 시간초과 뜨나보네
 */
public class P15990 {

  static long n;
  static int input;
  static int[] arr;
  static long cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Long.parseLong(br.readLine());
    for (long a = 0; a < n; a++) {
      input = Integer.parseInt(br.readLine());
      arr = new int[input];
      recursive(0, 0);
      bw.write(Long.toString(cnt % 1_000_000_009)+"\n");
      cnt = 0;
    }
    bw.close();
  }

  public static void recursive(int depth, int sum) {
    if (depth == input) {
//      System.out.println(Arrays.toString(arr));
      return;
    }
    if (sum == input) {
      cnt += 1;
      System.out.println(Arrays.toString(arr));
      return;
    }
    if (depth == 0) {
      for (int i = 1; i <= 3; i++) {
        if (sum + i <= input) {
          arr[depth] = i;
          recursive(depth + 1, sum + i);
          arr[depth] = 0;
        }
      }
    } else if (depth >= 1) {
      for (int i = 1; i <= 3; i++) {
        if (sum + i <= input) {
          if (arr[depth - 1] != i) {
            arr[depth] = i;
            recursive(depth + 1, sum + i);
            arr[depth] = 0;
          }
        }
      }
    }

  }

}
