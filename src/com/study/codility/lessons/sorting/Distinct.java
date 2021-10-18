package com.study.codility.lessons.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * <p>
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1 A[3] = 2    A[4] = 3    A[5] = 1 the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000]. Copyright 2009–2021 by Codility Limited. All Rights Reserved.
 * Unauthorized copying, publication or disclosure prohibited.
 *
 *
 * <p>
 * <p>
 * [100 result]
 * <p>
 * https://app.codility.com/demo/results/training96Q9RM-YNH/
 *
 * <p>
 * [75 result]
 * <p>
 * https://app.codility.com/demo/results/trainingNAJKUN-ZQB/
 */
public class Distinct {

  public static int solution(int[] A) {

    Map<Integer, Integer> myMap = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      myMap.put(A[i], A[i]);
    }

    return myMap.keySet().size();

  }

  //https://app.codility.com/demo/results/trainingNAJKUN-ZQB/
  public static int solution75(int[] A) {

    List<Integer> arrList = new ArrayList<>();

    for (int i : A) {
      if (!arrList.contains(i)) {
        arrList.add(i);
      }
    }

    return arrList.size();
  }

  public static void main(String[] args) {

    int[] a = {0};
    System.out.println(solution75(a));
  }
}
