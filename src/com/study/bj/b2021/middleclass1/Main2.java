package com.study.bj.b2021.middleclass1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

  public static ArrayList<Integer> arrList = new ArrayList();
  public static int n;
  public static int r;
  public static int cnt = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    r = scan.nextInt();
    f(0, 0);
    System.out.println("cnt:" + cnt);

  }

  private static void f(int depth, int y) {

    if (depth == r) {
//      System.out.println(arrList.toString());
      System.out.println("--------");
      cnt += 1;
      return;
    }

    else if (y == n + 1) {
      System.out.println("targetVal exceed : " + y);
      return;
    }

    arrList.add(y);
    System.out.println("> "+arrList.toString());
    f(depth + 1, y + 1);
    int len = arrList.size();
    arrList.remove(len - 1);
    System.out.println("> "+arrList.toString());
    f(depth, y + 1);


  }
}
