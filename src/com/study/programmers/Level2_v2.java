package com.study.programmers;

import java.util.Arrays;

public class Level2_v2 {

  static int[] bit;
  static int limit;
  static int cnt = 0;

  public static void main(String[] args) {
//    int[] a = {1, 1, 1, 1, 1};
////    solution(a, 5);
//    System.out.println(solution(a, 3));
    ;
    System.out.println(Arrays.toString(solution("110010101001")));
  }


  public static int[] solution(String s) {

    int zeroRemoveCnt = 0;
    int idx = 1;
    for (idx = 0; ; idx++) {
      if (s.equals("1")) {
        break;
      }
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '1') {
          sb.append(s.charAt(j));
        } else {
          zeroRemoveCnt += 1;
        }
      }
      Integer afterZeroRemoveLen = sb.toString().length();
//      System.out.println("afterZeroRemoveLen = " + afterZeroRemoveLen);
      s = toBinStr(afterZeroRemoveLen);

    }

    int[] answer = {idx, zeroRemoveCnt};
    return answer;
  }

  private static String toBinStr(Integer x) {
    StringBuilder sb = new StringBuilder();
    while (x != 1) {
      sb.append(x % 2);
      x = x / 2;
    }
    sb.append(1);

    String t = sb.reverse().toString();

    return t;
  }

  public static int solution(int[] numbers, int target) {

    bit = new int[numbers.length];

    for (limit = 1; limit <= numbers.length; limit++) {
      bitMake(0, 0, numbers, target);
    }
    return cnt;
  }

  private static void bitMake(int depth, int sum, int[] numbers, int target) {

    if (sum == limit) {
//      System.out.println(Arrays.toString(bit));
      int t = calculate(numbers);
      if (t == target) {
        cnt += 1;
      }
      return;
    }

    if (depth == bit.length) {
      return;
    }

    bit[depth] = 1;
    bitMake(depth + 1, sum + 1, numbers, target);
    bit[depth] = 0;
    bitMake(depth + 1, sum, numbers, target);
  }

  private static int calculate(int[] numbers) {
    int[] temp = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      if (bit[i] == 0) {
        temp[i] = -numbers[i];
      } else {
        temp[i] = numbers[i];
      }
    }
    int sum = 0;
    for (int i = 0; i < temp.length; i++) {
      sum += temp[i];
    }
    return sum;
  }
}
