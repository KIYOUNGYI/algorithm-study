package com.study.codility;

import java.util.HashMap;
import java.util.Map;

public class 문제 {

  static Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    int[] a = {4, 10, 5, 4, 2, 10};
    int[] b = {1, 4, 3, 3, 1, 2};
    int[] c = {6, 4, 4, 6};
    System.out.println(solution(c));
  }

  public static int solution(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], -1);
      } else {
        map.put(arr[i], i);
      }
    }

//    System.out.println(map.toString());
    int ans = Integer.MAX_VALUE;
    int t = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      Integer x = map.get(i);
      if (x != null) {
        if (x != -1) {
          if (ans > x) {
            ans = x;
            t = i;
          }
        }
      }
    }
    if (t == Integer.MAX_VALUE) {
      return -1;
    }
    return t;
  }
}
