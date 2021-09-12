package com.study.codility.lessons.timecomplexity;

public class FrogJmp {

  public static void main(String[] args) {
    System.out.println(solution100(10, 131, 30));
  }


  public static int solution44(int x, int y, int d) {
    // write your code in Java SE 8
    if (x == y) {
      return 1;
    }
    for (int idx = 1; ; idx += 1) {
      x = x + d;
      if (x >= y) {
        return idx;
      }
    }
  }

  //O(1)
  public static int solution88(int x, int y, int d) {

    int t = y - x;
    for (int a = t; ; a++) {
      if (a % d == 0) {
        return a / d;
      }
    }
  }

  //O(1)
  public static int solution100(int x, int y, int d) {

    if (x == y) {
      return 0;
    }

    int t = y - x;
    int a = t / d;
    if (t % d == 0) {
      return a;
    }

    return a + 1;
  }


}
