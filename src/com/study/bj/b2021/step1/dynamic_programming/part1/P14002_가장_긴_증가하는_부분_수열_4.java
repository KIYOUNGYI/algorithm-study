package com.study.bj.b2021.step1.dynamic_programming.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P14002_가장_긴_증가하는_부분_수열_4 {

  static int n;
  static int[] a;
  static int[] d;//내가 생각하는게 맞긴 했음 .
  static int[] v;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    a = new int[n];
    d = new int[n];
    v = new int[n];

    String temp1 = br.readLine();
    String[] temp2 = temp1.split(" ");
    for (int i = 0; i < temp2.length; i++) {
      a[i] = Integer.parseInt(temp2[i]);
    }


    for (int i = 0; i < n; i++) {
      d[i] = 1;
      v[i] = -1;
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j] && d[j] + 1 > d[i]) {
          d[i] = d[j] + 1;
          v[i] = j;
        }
      }
    }

    int ans = d[0];
    int p = 1;
    for (int i = 0; i < n; i++) {
      if (ans < d[i]) {
        ans = d[i];
        p = i;
      }
    }
    bw.write(ans + "\n");
    go(p);
    bw.write("\n");
    bw.flush();
  }

  static void go(int p) throws IOException {
    if (p == -1) {
      return;
    }

    go(v[p]);
    bw.write(a[p] + " ");
  }
}
