package com.study.programmers.twotwo.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복2 {

  static int[] member;
  static List<Integer> reserveList = new ArrayList<>();
  static List<Integer> lostList = new ArrayList<>();

  public static int solution(int n, int[] lost, int[] reserve) {

    member = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      member[i] = 1;
    }

    for (int i = 0; i < lost.length; i++) {
      member[lost[i]] = 0;
    }

    for (int i : reserve) {
      reserveList.add(i);
    }

    for (int i : lost) {
      lostList.add(i);
    }

    int len = lostList.size();

    for(int i=0;i<len;i++){

      int t = lostList.get(i);

      if(reserveList.contains(t-1)){

      }

    }



    int answer = 0;
    return answer;
  }

  public static void main(String[] args) {

    //total, lost, reserve
//    System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
//    System.out.println(solution(3, new int[]{3}, new int[]{1}));
  }
}

//2 - 1
//4 - 3
//-----------
//4 - 5
//-----------
//2 - 3
//4 - 5
//-----------

//4 - 3
//-----------
//4 - 5
