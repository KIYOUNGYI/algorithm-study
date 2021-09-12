package com.study.bj.b2021.step3.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1913_달팽이 {

  static int[][] a;
  static int n;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    int s = (n + 1) / 2;//시작점 (x,y), 그룹수
    System.out.println(s);

    List<Integer>[] arr = new List[s];

    for (int i = 0; i < s; i++) {
      arr[i] = new ArrayList<>();
    }


    for (int i = 1; i < s; i++) {
      int t = (2 * i + 1) * (2 * i + 1);
      System.out.println("last:" + t+" next:"+(t+1));
    }

  }
}
