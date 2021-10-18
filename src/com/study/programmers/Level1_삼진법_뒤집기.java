package com.study.programmers;

public class Level1_삼진법_뒤집기 {

  public static int solution(int n) {
    String a = toReversedTernary(n);
    int b = reversedTernaryToDecimal(a);

    return b;
  }

  private static int reversedTernaryToDecimal(String a) {

    int sum = 0;
    int idx = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
      int t = (a.charAt(i) - 48) * (int) Math.pow(3, (idx++));
      sum = sum + t;
    }

    return sum;
  }

  private static String toReversedTernary(int n) {

    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      sb.append(n % 3);
      n = n / 3;
    }

    return sb.toString();
  }

  public static void main(String[] args) {
//    System.out.println('1' - 48);
    System.out.println(solution(45));
//    System.out.println(solution(7));
  }
}
