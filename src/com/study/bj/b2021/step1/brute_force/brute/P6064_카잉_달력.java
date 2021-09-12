package com.study.bj.b2021.step1.brute_force.brute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P6064_카잉_달력 {


  static int tc;
  static int M, N, x, y;
  static Point[] arr;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

//    System.out.println(gcd(4,8));

    String s = br.readLine();
    tc = Integer.parseInt(s);

    for (int i = 0; i < tc; i++) {
      String s2 = br.readLine();
      String[] s1 = s2.split(" ");
      M = Integer.parseInt(s1[0]);
      N = Integer.parseInt(s1[1]);
      x = Integer.parseInt(s1[2]);
      y = Integer.parseInt(s1[3]);

      int t = gcd(M, N);
      int loopCnt = t * M / t * N / t;

      boolean flag = false;

//      arr = new Point[loopCnt + 1];
      for (int j = 1; j <= loopCnt; j++) {

        int a = j % M;
        if (a == 0) {
          a = M;
        }

        int b = j % N;
        if (b == 0) {
          b = N;
        }
//        arr[j] = new Point(a, b);

        if (a == x && b == y) {
          bw.write(j+"\n");
          flag = true;
          break;
        }
      }

      if (!flag) {
        bw.write(-1+"\n");
      }
    }

//    System.out.println("----");
//    System.out.println(arr[59]);
//    System.out.println(arr[60]);
    bw.flush();
    bw.close();

  }

  static int gcd(int x, int y) {

    int big = max(x, y);
    int small = min(x, y);

    for (; ; ) {
      int remain = big % small;
      if (remain == 0) {
        return small;
      }
//      System.out.println("b:"+big+" s:"+small+" remain:"+remain);
      big = small;
      small = remain;
    }
  }

  static int gcd2(int x, int y) {

    int big = max(x, y);
    int small = min(x, y);

    int r = -1;
    while (r != 0) {
      r = big % small;
      if (r == 0) {
        return small;
      }
      big = small;
      small = r;
    }
    return small;
  }

  private static int max(int x, int y) {
    return x > y ? x : y;
  }

  private static int min(int x, int y) {
    return x > y ? y : x;
  }


  static class Point {

    int px;
    int py;
//    int idx;//필요할까


    public Point() {
    }

    public Point(int px, int py) {
      this.px = px;
      this.py = py;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + px +
          ", y=" + py +
          '}';
    }
  }
}
