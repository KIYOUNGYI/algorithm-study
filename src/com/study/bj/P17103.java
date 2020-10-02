package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 골드바흐 파티션
 * https://www.acmicpc.net/problem/17103
 */
public class P17103 {

  static final int limit = 1_000_020;
  static int n;
  public static boolean[] prime = new boolean[limit];

  public static void main(String[] args) throws IOException {
    init();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int t = Integer.parseInt(br.readLine());
      int cnt = 0;
      for (int j = 2; j <= t / 2; j++) {
//        System.out.println("j:"+j);
        if (prime[j]) {
          if (prime[t - j]) {
            cnt += 1;
          }
        }
      }
      bw.write(cnt+"\n");
//      System.out.println(cnt);
    }
    bw.close();
  }

  private static void init() {
    for (int i = 0; i < limit; i++) {
      prime[i] = true;
    }
    prime[1] = false;

    for (int i = 2; i < limit; i++) {
      for (int j = i + i; j < limit; j = j + i) {
        prime[j] = false;
      }
    }
//    for(int i=2;i<=100;i++)
//    {
//      System.out.println(i+" "+prime[i]);
//    }
  }
}
