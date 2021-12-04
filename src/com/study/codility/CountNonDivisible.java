package com.study.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNonDivisible {

  static Map<Integer, Integer> myMap = new HashMap<>();


  public static List<Integer> divisors(int n) {
    List<Integer> arrList = new ArrayList<>();

    for (int i = 1; i <= (int) Math.sqrt(n); i++) {

      if (n % i == 0) {
        arrList.add(i);

        if (i != n / i) {
          arrList.add(n / i);
        }
      }
    }

    return arrList;
  }


  public static void main(String[] args) {

//    System.out.println(divisors(24).toString());

    int[] a = {3, 1, 2, 3, 6};

    System.out.println(Arrays.toString(solutionV1(a)));
  }



  public static int[] solution(int[] arr) {

    Map<Integer, Integer> myMap = new HashMap<>();

    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {

      int x = arr[i];

      if (myMap.containsKey(x)) {
        ans[i] = myMap.get(x);
      } else {

        int cnt = 0;
        for (int j = 0; j < arr.length; j++) {
          int y = arr[j];
          if (x % y != 0) {
            cnt += 1;
          }
        }
        ans[i] = cnt;
        myMap.put(x, cnt);
      }

    }

    return ans;
  }


  public static int[] solutionV1(int[] arr) {

    Map<Integer, Integer> myMap = new HashMap<>();

    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {

      int x = arr[i];

      if (myMap.containsKey(x)) {
        ans[i] = myMap.get(x);
      } else {

        int cnt = 0;
        for (int j = 0; j < arr.length; j++) {
          int y = arr[j];
          if (x % y != 0) {
            cnt += 1;
          }
        }
        ans[i] = cnt;
        myMap.put(x, cnt);
      }

    }

    return ans;
  }

  public static int[] solutionOld(int[] arr) {

    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int x = arr[i];
      int cnt = 0;
      for (int j = 0; j < arr.length; j++) {
        int y = arr[j];
        if (x % y != 0) {
          cnt += 1;
        }
      }
      ans[i] = cnt;
    }

    return ans;
  }
}
