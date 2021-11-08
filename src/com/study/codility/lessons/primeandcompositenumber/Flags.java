package com.study.codility.lessons.primeandcompositenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 다시 풀어야 함
 * <p>
 * 유튜브 풀이임
 * <p>
 * 이해 못함
 */
public class Flags {

  public static int solution(int[] arr) {

    List<Integer> peaks = new ArrayList<>();

    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        peaks.add(i);
      }
    }

    if (arr[arr.length - 2] < arr[arr.length - 1]) {
      peaks.add(arr.length - 1);
    }

    if (peaks.size() <= 1) {
      return peaks.size();
    }

    int maxFlags = (int) Math.ceil(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0)));
    System.out.println("maxFlags = " + maxFlags);

    for (int flags = maxFlags; flags > 1; flags--) {

      int flagsPlaced = 2;

      int startIdx = 0;
      int endIdx = peaks.size() - 1;

      int startFlag = peaks.get(startIdx);
      int endFlag = peaks.get(endIdx);

      while (startIdx < endIdx) {
        startIdx += 1;
        endIdx -= 1;

        if (peaks.get(startIdx) >= startFlag + flags) {
          if (peaks.get(startIdx) <= endFlag - flags) {
            flagsPlaced += 1;
            startFlag = peaks.get(startIdx);
          }
        }

        if (peaks.get(endIdx) >= startFlag + flags) {
          if (peaks.get(endIdx) <= endFlag - flags) {
            flagsPlaced += 1;
            startFlag = peaks.get(endIdx);
          }
        }

        if (flagsPlaced == flags) {
          return flags;
        }

      }


    }

    return 0;
  }

  public static void main(String[] args) {

    int[] arr = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
    System.out.println(solution(arr));

//    int[] brr = {1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4};
//    System.out.println(solution(brr));
  }

}
