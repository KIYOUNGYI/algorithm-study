package com.study.bj;

import java.util.Scanner;

/**
 * 숫자카드 https://www.acmicpc.net/problem/10815
 * <p>
 * 난 이 문제 의외로 쉽게 풀었다. 근데 대부분 바이너리서치로 푸네?? 나도 바이너리로 다음에 풀어볼까? https://www.acmicpc.net/source/22534991
 * <p>
 * 자바 binary search 소스 https://www.acmicpc.net/source/22519215
 */
public class P10815 {

  static int[] plusArr = new int[10000020];
  static int[] minusArr = new int[10000020];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    for (int i = 0; i < N; i++) {
      int a = scan.nextInt();
      if (a >= 0) {
        plusArr[a] += 1;
      } else {
        minusArr[abs(a)] += 1;
      }
//            System.out.println(a);
    }
    int M = scan.nextInt();
    for (int i = 0; i < M; i++) {
      int a = scan.nextInt();
      if (a > 0) {
        if (i == M - 1) {
          if (plusArr[a] > 0) {
            System.out.print("1");
          } else {
            System.out.print("0");
          }
        } else {
          if (plusArr[a] > 0) {
            System.out.print("1 ");
          } else {
            System.out.print("0 ");
          }
        }
      } else {
        if (i == M - 1) {
          if (minusArr[abs(a)] > 0) {
            System.out.print("1");
          } else {
            System.out.print("0");
          }
        } else {
          if (minusArr[abs(a)] > 0) {
            System.out.print("1 ");
          } else {
            System.out.print("0 ");
          }
        }
      }
    }
  }

  public static int abs(int x) {
    if (x > 0) {
      return x;
    } else {
      return -x;
    }
  }

}
