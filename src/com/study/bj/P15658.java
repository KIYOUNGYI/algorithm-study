package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 연산자 끼워넣기 (2) ->
 * https://www.acmicpc.net/problem/15658
 * [1] 시간초과
 */
public class P15658 {

  static int MAX = Integer.MIN_VALUE;
  static int MIN = Integer.MAX_VALUE;
  static int N;
  static int[] arr;
  static int[] gihoCandidate;
  static int[] gihoInput;
  static boolean[] visit;
  static int len;
  static int cnt=0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    gihoInput = new int[N - 1];

    String[] temp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) { arr[i] = Integer.parseInt(temp[i]); }

    String[] temp2 = br.readLine().split(" ");
    int a = Integer.parseInt(temp2[0]);//(add)
    int b = Integer.parseInt(temp2[1]);//(sub)
    int c = Integer.parseInt(temp2[2]);//(mul)
    int d = Integer.parseInt(temp2[3]);//(div)
    len = a + b + c + d;
    gihoCandidate = new int[len];
    visit = new boolean[len];
    int idx = 0;
    for (int i = 0; i < a; i++) {
      gihoCandidate[idx++] = 1;
    }
    for (int i = 0; i < b; i++) {
      gihoCandidate[idx++] = 2;
    }
    for (int i = 0; i < c; i++) {
      gihoCandidate[idx++] = 3;
    }
    for (int i = 0; i < d; i++) {
      gihoCandidate[idx++] = 4;
    }

    recursive(0);
    System.out.println("cnt:"+cnt);
    bw.write(MAX + "\n");
    bw.write(MIN + "\n");
    bw.close();
  }

  public static void recursive(int depth) {
    if (depth == N - 1)
    {
      System.out.println(Arrays.toString(gihoInput));
      calcuate();
      cnt+=1;
      return;
    }

    for (int i = 0; i < len; i++) {
      if (!visit[i]) {
        visit[i] = true;
        gihoInput[depth] = gihoCandidate[i];
        recursive(depth + 1);
        visit[i] = false;
      }
    }
  }

  public static void calcuate() {
    int total = arr[0];
    for (int i = 0; i < gihoInput.length; i++) {
      if (gihoInput[i] == 1) {
        total = total + arr[i + 1];
      } else if (gihoInput[i] == 2) {
        total = total - arr[i + 1];
      } else if (gihoInput[i] == 3) {
        total = total * arr[i + 1];
      } else if (gihoInput[i] == 4) {
        total = total / arr[i + 1];
      }
    }
    if (MAX < total) {
      MAX = total;
    }
    if (MIN > total) {
      MIN = total;
    }
  }

}

