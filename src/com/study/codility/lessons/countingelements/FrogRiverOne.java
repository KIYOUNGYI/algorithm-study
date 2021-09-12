package com.study.codility.lessons.countingelements;

public class FrogRiverOne {

  public static void main(String[] args) {
//    int[] a = {1, 3, 1, 4, 2, 3, 5, 4};
//    int t = solution(5, a);
    int[] a = {1};
    System.out.println(solution(1, a));
  }

  //https://app.codility.com/demo/results/trainingKAYGSM-MHV/
  //O(N)
  public static int solution81(int x, int[] arr) {

    int[] copy = new int[arr.length];
    int s = 1;
    for (int i = 0; i < arr.length; i++) {

      if (copy[arr[i]] == 0) {
        copy[arr[i]] = s;
        s += 1;
      } else {
        copy[arr[i]] = s;
      }
      if (s == x + 1) {
        return i;
      }
//      System.out.println(i+" "+ Arrays.toString(copy));
    }

    return -1;
  }

  //https://app.codility.com/demo/results/training3MC9SR-32G/
  //O(N)
  public static int solution(int x, int[] arr) {

    int[] copy = new int[100_001];
    int s = 1;
    for (int i = 0; i < arr.length; i++) {

      if (copy[arr[i]] == 0) {
        copy[arr[i]] = s;
        s += 1;
      } else {
        copy[arr[i]] = s;
      }
      if (s == x + 1) {
        return i;
      }
//      System.out.println(i+" "+ Arrays.toString(copy));
    }

    return -1;
  }
}
