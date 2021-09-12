package com.study.codility.lessons.timecomplexity;

/**
 * <p> O(N) or O(N * log(N)) </p>
 * <p> https://app.codility.com/demo/results/training7RRX6J-H53/ 솔직히 이 문제 잘 모르겠 </p>
 */
public class PermMissingElem {


  public static void main(String[] args) {
    int[] c = {2, 3, 4, 5};
    System.out.println(solution(c));
  }

  public static int solution(int[] arr) {

    int N = arr.length;
    if (N == 0) {
      return 1;
    }

    boolean[] v = new boolean[N + 2];
    for (int i = 0; i < arr.length; i++) {
      v[arr[i]] = true;
    }

    for (int i = 1; i <= N + 1; i++) {
      if (v[i] == false) {
        return i;
      }
    }

    return 0;
  }


  public static int solution50(int[] arr) {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean[] v = new boolean[1_000_001];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
      v[arr[i]] = true;
    }

    for (int i = min; i <= max; i++) {
      if (v[i] == false) {
        return i;
      }
    }

    return 0;
  }
}
