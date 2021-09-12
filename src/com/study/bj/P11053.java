package com.study.bj;

import java.util.Scanner;

/**
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 * <p>
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 * <p>
 * [입력] 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 * <p>
 * [출력] 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 */
public class P11053 {

  static int n;
  static int[] arr, d;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    arr = new int[n + 1];
    d = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = scan.nextInt();
    }

    d[1] = 1;
    for (int i = 1; i <= n; i++) {
      d[i] = 1;
      int std = arr[i];
//      System.out.println("i : " + i);

      int cnt = 0;
      for (int j = 1; j < i; j++) {
//        System.out.print("j : "+j+" ");
        if (arr[j] < std && d[i] < d[j] + 1) {
//          if (arr[j] < std) {
          d[i] = d[j] + 1;
//            cnt += 1;
        }
      }
//      System.out.println();
    }
    System.out.println(d[n]);
  }
}
