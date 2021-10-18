package com.study.programmers;

public class Level2_최소공배수 {

  public static long solution(int[] arr) {

    if (arr.length == 1) {
      return arr[0];
    }

    int lim = 101;
    for (int i = 0; i < arr.length; i++) {
      lim = min(lim, arr[i]);
    }

    int ans = 1;
    int x;
    for (x = 1; x <= lim; x++) {
      int cnt = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] % x == 0) {
          cnt += 1;
        } else {
          break;
        }
        if (cnt == arr.length) {
          ans = x;
        }
      }
    }


    for(int i=0;i<arr.length;i++){
      arr[i] = arr[i]/ans;
    }

    long v = ans;
    for(int i=0;i<arr.length;i++){
      v = v * arr[i];
    }

    return v;
  }

  private static int min(int a, int b) {
    return a > b ? b : a;
  }

  public static void main(String[] args) {
    int[] a = {2, 6, 8, 14};
    System.out.println(solution(a));
  }


}
