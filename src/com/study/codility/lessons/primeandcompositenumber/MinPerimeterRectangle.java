package com.study.codility.lessons.primeandcompositenumber;

public class MinPerimeterRectangle {

  public static void main(String[] args) {
    System.out.println(solution(30));
  }

  //https://app.codility.com/demo/results/trainingSGC3U3-3ZT/
  //O(sqrt(N))
  public static int solution(int n) {

    int ans = Integer.MAX_VALUE;
    long i = 1;

    while (i * i <= n) {

      if (n % i == 0) {
//        System.out.println(n + " " + i + " " + (n / i));
        if (2 * (i + (n / i)) < ans) {
          ans = (int) (2 * (i + (n / i)));
        }
      }
      i += 1;
    }

    return ans;
  }
}
