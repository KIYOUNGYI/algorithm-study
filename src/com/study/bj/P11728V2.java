package com.study.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 배열 합치기
 * https://www.acmicpc.net/problem/11728
 */
public class P11728V2 {

  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] temp1 = br.readLine().split(" ");

    int a = Integer.parseInt(temp1[0]);
    int b = Integer.parseInt(temp1[1]);
    long[] a1 = new long[a];
    long[] b1 = new long[b];

    String[] temp2 = br.readLine().split(" ");
    for (int i = 0; i < a; i++) {
      a1[i] = Long.parseLong(temp2[i]);
    }

    String[] temp3 = br.readLine().split(" ");
    for (int i = 0; i < b; i++) {
      b1[i] = Long.parseLong(temp3[i]);
    }
    merge(a1, b1);
  }

  public static void merge(long[] a, long[] b) throws IOException{
    long[] c = new long[a.length + b.length];
    int idx = 0;
    int ptr1 = 0;
    int ptr2 = 0;
    while (ptr1 < a.length && ptr2 < b.length) {
      if (a[ptr1] <= b[ptr2]) {
        c[idx++] = a[ptr1++];
      } else {
        c[idx++] = b[ptr2++];
      }
    }
    if (ptr1 == a.length) {
      while (ptr2 < b.length) {
        c[idx++] = b[ptr2++];
      }
    }

    if (ptr2 == b.length) {
      while (ptr1 < a.length) {
        c[idx++] = a[ptr1++];
      }
    }

//    System.out.println(Arrays.toString(c));
    for (int i = 0; i < c.length - 1; i++) {
      bw.write(c[i] + " ");
    }
    bw.write(c[c.length - 1]+"\n");
    bw.close();
  }
}
