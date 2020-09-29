package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 수 이어 쓰기 1
 * 브루트 포스
 * https://www.acmicpc.net/problem/1748
 * 좋은 풀이 : https://www.acmicpc.net/source/22721187
 */
public class P1748 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    long cnt = 0;
    for (long i = 1; i <= n; i++) {
      if (i >= 1 && i <= 9) {
        cnt += 1;
      } else if (i >= 10 && i <= 99) {
        cnt += 2;
      } else if (i >= 10 * 10 && i <= 999) {
        cnt += 3;
      } else if (i >= 10 * 10 * 10 && i <= 9999) {
        cnt += 4;
      } else if (i >= 10 * 10 * 10 * 10 && i <= 99999) {
        cnt += 5;
      } else if (i >= 10 * 10 * 10 * 10 * 10 && i <= 999999) {
        cnt += 6;
      } else if (i >= 10 * 10 * 10 * 10 * 10 * 10 && i <= 9999999) {
        cnt += 7;
      } else if (i >= 10 * 10 * 10 * 10 * 10 * 10 * 10 && i <= 99999999) {
        cnt += 8;
      } else if (i == 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10) {
        cnt += 9;
      }
    }
    bw.write(Long.toString(cnt));
    bw.close();
  }
}
