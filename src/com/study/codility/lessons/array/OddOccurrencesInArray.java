package com.study.codility.lessons.array;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

  public static void main(String[] args) {
    int[] a = {42};
    int[] b = {9, 3, 9, 3, 9, 7, 9};
//    System.out.println(solution(a));
  }

  public static int solution100(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      if (map.get(arr[i]) == null) {
        map.put(arr[i], 1);
      } else {
        int v = map.get(arr[i]);
        map.put(arr[i], v + 1);
      }
    }
    System.out.println(map.toString());
    for (Integer key : map.keySet()) {
      if (map.get(key) % 2 != 0) {
        return key;
      }
    }

    return 0;
  }


  public static int solutionScore77(int[] arr) {

    int[] check = new int[1_000_001];

    for (int i = 0; i < arr.length; i++) {
      check[arr[i]] += 1;
    }

    for (int i = 0; i < check.length; i++) {
      if (check[i] % 2 != 0) {
        return i;
      }
    }

    return 0;
  }
}
