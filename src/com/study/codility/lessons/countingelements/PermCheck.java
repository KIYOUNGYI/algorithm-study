package com.study.codility.lessons.countingelements;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {

  public static void main(String[] args) {
    int[] a = {4, 1, 3, 2};
    int[] b = {4, 1, 3};
    int[] c = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
//    Arrays.sort(c);
//    System.out.println(Arrays.toString(c));
    System.out.println(solution100(c));
  }

  //https://app.codility.com/demo/results/training9P3KA8-FA7/
  public static int solution88(int[] arr) {

    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }


    }

    int size = arr.length;//4
    if (size == max) {
      return 1;
    }

    return 0;
  }

  //https://app.codility.com/demo/results/trainingSU9SNH-K2J/
  public static int solution100(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }

      if (map.containsKey(arr[i])) {
        int t = map.get(arr[i]);
        map.put(arr[i], t + 1);
      } else {
        map.put(arr[i], 1);
      }

    }

    for (Integer key : map.keySet()) {
      Integer v = map.get(key);
      if (v >= 2) {
        return 0;
      }
    }

    int size = arr.length;//4
    if (size == max) {
      return 1;
    }

    return 0;
  }
}
