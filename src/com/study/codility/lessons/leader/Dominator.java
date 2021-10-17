package com.study.codility.lessons.leader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3 A[3] = 2    A[4] = 3    A[5] = -1 A[6] = 3    A[7] = 3 The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4,
 * 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3 A[3] = 2    A[4] = 3    A[5] = -1 A[6] = 3    A[7] = 3 the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the range [−2,147,483,648..2,147,483,647]. Copyright 2009–2021 by Codility Limited. All Rights Reserved.
 * Unauthorized copying, publication or disclosure prohibited.
 * <p>
 * https://app.codility.com/demo/results/trainingT3N43E-8U3/
 */
public class Dominator {


  public static void main(String[] args) {
    int[] a = {42};
    int[] b = {9, 3, 9, 3, 9, 7, 9};
    int[] c = {3, 4, 3, 2, 3, -1, 3, 3};
    int[] d = {0, 0, 1, 1, 1};
    int[] e = {0, 0, 0, 1, 1, 1};
    System.out.println(solution(d));
  }


  public static int solution(int[] arr) {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      if (map.get(arr[i]) == null) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(i);
        map.put(arr[i], arrList);
      } else {
        ArrayList<Integer> arrayList = map.get(arr[i]);
        arrayList.add(i);
        map.put(arr[i], arrayList);
      }
    }

    // System.out.println(map.toString());

    int size = 0;
    int idx = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key).size() > size) {
        size = map.get(key).size();
        idx = map.get(key).get(0);
      }
    }

    if (size > arr.length / 2) {
      return idx;
    }

    return -1;
  }


  //https://app.codility.com/demo/results/trainingGER5P7-YR5/
  public int solution55(int[] arr) {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {

      if (map.get(arr[i]) == null) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(i);
        map.put(arr[i], arrList);
      } else {
        ArrayList<Integer> arrayList = map.get(arr[i]);
        arrayList.add(i);
        map.put(arr[i], arrayList);
      }
    }

    // System.out.println(map.toString());
    int size = 0;
    int idx = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key).size() > size) {
        size = map.get(key).size();
        idx = key;
      }
    }

    ArrayList<Integer> arrayList = map.get(idx);

    return arrayList.get(0);
  }


}
