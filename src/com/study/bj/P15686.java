package com.study.bj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */
public class P15686 {

  static int max = Integer.MAX_VALUE;
  static int remainCnt;
  static int n, keepAliveCnt;
  static ArrayList<CPoint> house = new ArrayList<>();
  static ArrayList<CPoint> chicken = new ArrayList<>();
  static boolean[] visit;
  static int[] mark;
  static int[][] arr;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    keepAliveCnt = scan.nextInt();
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scan.nextInt();
        if (arr[i][j] == 1) {
          house.add(new CPoint(i, j));
        } else if (arr[i][j] == 2) {
          chicken.add(new CPoint(i, j));
        }
      }
    }
    int chickenLen = chicken.size();
    visit = new boolean[chickenLen];
    mark = new int[chickenLen];

    if (chickenLen < keepAliveCnt) {
      keepAliveCnt = chickenLen;
    }
    for (int i = 1; i <= keepAliveCnt; i++) {
//      System.out.println(">"+i+"개만 남기고 모두 제거/ 전체 "+chickenLen+" 개 중 "+(chickenLen-i)+" 개 제거");
      remainCnt = i;
      johab(0, 0);
    }
    System.out.println(max);
  }

  public static void calculate() {
    int sum = 0;
    for (int j = 0; j < house.size(); j++) {
      CPoint cPoint = house.get(j);
      int min = Integer.MAX_VALUE;
      int t = 0;
      for (int i = 0; i < chicken.size(); i++) {
        if (mark[i] == 1) {
          CPoint cPoint1 = chicken.get(i);
          t = calcuateDistance(cPoint, cPoint1);
          if (t < min) {
            min = t;
          }
        }
      }
      sum = sum + min;
    }
//    System.out.println(">sum:"+sum);
    if (sum < max) {
      max = sum;
    }
  }

  private static int calcuateDistance(CPoint cPoint, CPoint cPoint1) {
    return abs(cPoint.x - cPoint1.x) + abs(cPoint.y - cPoint1.y);
  }

  private static int abs(int x) {
    return x >= 0 ? x : -x;
  }


  public static void johab(int depth, int cnt) {
    if (cnt == remainCnt) {
//      System.out.println(Arrays.toString(mark));
      calculate();
      return;
    }
    if (depth == chicken.size()) {
      return;
    }
    mark[depth] = 1;
    johab(depth + 1, cnt + 1);
    mark[depth] = 0;
    johab(depth + 1, cnt);
  }
}


class CPoint {

  int x, y;

  public CPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "CPoint{" + "x=" + x + ", y=" + y + '}';
  }
}