package com.study.bj.b2021.middleclass1;

import java.util.Arrays;
import java.util.Scanner;

public class P10815_숫자카드 {

  static int[] arr;
  static int[] target;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }

    int n1 = scan.nextInt();
    target = new int[n1];
    for (int i = 0; i < n1; i++) {
      target[i] = scan.nextInt();
    }

    Arrays.sort(arr);
    for (int i = 0; i < n1; i++) {
//      int x = binarySearchRecursive(target[i], 0, arr.length - 1);
      int y = binarySearchIterative(target[i], arr.length);
      System.out.print(y + " ");
    }
  }

  private static int binarySearchRecursive(int val, int s, int e) {
    if (s > e) {
      return 0;
    }
    if (arr[s] == val || arr[e] == val) {
      return 1;
    }

    int mid = (s + e) / 2;
    if (arr[mid] == val) {
      return 1;
    } else if (arr[mid] < val) {//내가 찾은 값이 target 보다 작으면 시작점을 올려야 한다.
      return binarySearchRecursive(val, mid + 1, e);
    } else {
      return binarySearchRecursive(val, s, mid - 1);
    }
  }


  private static int binarySearchIterative(int key, int len) {
    int start = 0;
    int end = len - 1;
    int mid;

    while (end - start >= 0) {
      mid = (start + end) / 2;

      if (arr[mid] == key) {
        return 1;
      } else if (arr[mid] < key) {//key 값이 arr[mid] 값보다 크면 오른쪽으로 가야지
        start = mid + 1;
      } else {//arr[mid] > key -> 왼쪽으로 가야지
        end = mid - 1;
      }
    }

    return 0;
  }


}