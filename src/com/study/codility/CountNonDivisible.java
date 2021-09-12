package com.study.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {

  static Map<Integer, Integer> map = new HashMap<>();



  public static void main(String[] args) {
    int[] a = {3, 1, 2, 3, 6};

    System.out.println(Arrays.toString(solution(a)));
  }

  public static int[] solution(int[] arr) {

    int[] ans = new int[arr.length];


    for(int i=0;i<arr.length;i++){
      int x = arr[i];
      int cnt = 0;
      for(int j=0;j<arr.length;j++){
        int y = arr[j];
        if(x%y!=0){
          cnt+=1;
        }
      }
      ans[i] = cnt;
    }

    return ans;
  }
}
