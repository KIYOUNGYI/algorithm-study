package com.study.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 네 수 https://www.acmicpc.net/problem/10824
 */
public class P10824 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    String a = arr[0] + arr[1];
    String b = arr[2] + arr[3];
    long a1 = Long.parseLong(a);
    long b1 = Long.parseLong(b);
    System.out.println(a1 + b1);

  }
}
