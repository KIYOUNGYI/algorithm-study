package com.study.codility.lessons.leader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3 A[3] = 2    A[4] = 3    A[5] = -1 A[6] = 3    A[7] = 3 The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those
 * with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not
 * have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3 A[3] = 2    A[4] = 3    A[5] = -1 A[6] = 3    A[7] = 3 the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an integer within the range [−2,147,483,648..2,147,483,647]. Copyright 2009–2021 by Codility Limited.
 * All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * <p>
 * https://app.codility.com/demo/results/trainingT3N43E-8U3/
 */
public class Dominator {


  public static void main(String[] args) {
    int[] a = {42};
    int[] b = {9, 3, 9, 3, 9, 7, 9};
    int[] c = {3, 4, 3, 2, 3, -1, 3, 3};
    int[] d = {0, 0, 1, 1, 1};
    int[] e = {1, 2, 1};
    int[] f = {0, 0, 1, 1, 1};
    int[] g = {2, 1, 1, 1, 3};
    System.out.println(goldenLeader(a));
  }

  /**
   * https://app.codility.com/demo/results/trainingV9QCHS-GSS/
   */
  public static int goldenLeader(int[] arr) {

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      if (stack.isEmpty()) {
        stack.push(arr[i]);
      } else {

        if (stack.peek() == arr[i]) {
          stack.push(arr[i]);
        } else {
          stack.pop();
        }

      }
    }

    if (stack.isEmpty()) {
      return -1;
    }

    int dominator = stack.peek();
    int len = arr.length;

    int limit = len / 2;
//
    int cnt = 0;
//
    int tempIdx = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] == dominator) {
        cnt += 1;
        tempIdx = i;
      }
    }

    if (cnt > limit) {
      return tempIdx;
    } else {
      return -1;
    }
  }

  /**
   * [해냈다]
   * <p>
   * https://app.codility.com/demo/results/trainingFYHYUH-7VT/
   *
   *
   * <p>
   * [힘들다]
   * <p>
   * https://app.codility.com/demo/results/training29PYFF-UP8/
   */
  public static int solutionStudying(int[] arr) {

    if (arr.length == 0) {
      return -1;
    }

    if (arr.length == 1) {
      return 0;
    }

    int[] brr = new int[arr.length];
    for (int i = 0; i < brr.length; i++) {
      brr[i] = arr[i];
    }

    Arrays.sort(arr);

    int len = arr.length;
    int leader = -1;

    int candidate = arr[len / 2];

    int temp = 0;
    for (int i = 0; i < brr.length; i++) {
      if (candidate == brr[i]) {
        temp = i;
        break;
      }
    }

    int count = 1;

    for (int i = len / 2 + 1; i < len; i++) {
      if (arr[i] == candidate) {
        count += 1;
      } else {
        break;
      }
    }

    for (int i = len / 2 - 1; i >= 0; i--) {

      if (arr[i] == candidate) {
        count += 1;
      } else {
        break;
      }

    }

    if (count > len / 2) {
      leader = temp;
    }

    return leader;
  }


  /**
   * 다 맞긴 했는데, 단원이 제공하는 풀이를 활용해서 풀어봐야겠다.
   */
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

    System.out.println(map.toString());

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
