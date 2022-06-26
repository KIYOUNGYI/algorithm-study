package com.study.programmers.twotwo.levelone;

import java.util.Arrays;

public class 체육복3 {

  static int totalLen;
  static boolean[] reserve;
  static int[] member;

  public static int solution(int n, int[] lostInput, int[] resInput) {

    totalLen = n + 1;
    member = new int[totalLen];//[n->9 // <0,  [1,2,3,4,5,6,7,8,9]>
    Arrays.fill(member, 1);

    for (int i : lostInput) {
      member[i] = 0;
    }

    reserve = new boolean[totalLen];

    for (int i : resInput) {
      reserve[i] = true;
    }

    for (int idx = 1; idx < totalLen; idx++) {
        dfs(idx);
    }

    return 1;
  }


  public static void dfs(int idx) {

    if( idx-1>=1 || idx+1<=totalLen){




    }



  }

  public static void main(String[] args) {

    //total, lost, reserve
//    System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//    System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
//    System.out.println(solution(3, new int[]{3}, new int[]{1}));
    System.out.println(solution(9, new int[]{2, 4, 6}, new int[]{3, 7}));
  }
}
