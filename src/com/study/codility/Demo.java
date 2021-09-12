package com.study.codility;

import java.util.ArrayList;
import java.util.List;

public class Demo {

  public static void main(String[] args) {
    int[] a = {4, 10, 5, 4, 2, 10};
    int[] b = {6,4,4,6};
    int ans = solution(a);
    System.out.println(ans);
    int ans2 = solution(b);
    System.out.println(ans2);
  }

  static int solution(int[] A) {

    List<Integer>[] arrList = new ArrayList[100_001];
    for (int i = 0; i < 100_001; i++) {
      arrList[i] = new ArrayList<>();
    }

    for (int i = 0; i < A.length; i++) {
      int t = A[i];
      arrList[t].add(i);
    }


    int t = Integer.MAX_VALUE;
    int ans = -1;
    for (int i = 0; i < 100_001; i++) {
      if(arrList[i].size()==1){
        if(arrList[i].get(0)<t){
          t = arrList[i].get(0);
          ans = i;
        }
      }
    }
    return ans;
  }
}
