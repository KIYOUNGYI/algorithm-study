package com.study.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level3_다단계 {

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int len = enroll.length;

    int[] parent = new int[len];
    int[] score = new int[len];

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < enroll.length; i++) {
      map.put(enroll[i], i);
    }

    for (int i = 0; i < referral.length; i++) {
      if (referral[i].equals("-")) {
        parent[i] = -1;
      } else {
        parent[i] = map.get(referral[i]);
      }
    }

    for (int i = 0; i < seller.length; i++) {

      int idx = map.get(seller[i]);
      int amt = amount[i];

      int total = amt * 100;

      int tenPercentVal = (int) (total * 0.1);
      int myVal = total - tenPercentVal;

      score[idx] = score[idx] + myVal;
//      System.out.println("seller : " + seller[i] + " idx : " + idx + " totalVal : " + total + " ten : " + tenPercentVal + " myVal : " + myVal);
      while (idx != -1) {

        idx = parent[idx];
//        System.out.println("parent idx : " + idx);
        if (idx == -1) {
          break;
        }

        total = tenPercentVal;
        tenPercentVal = (int) (total * 0.1);
        myVal = total - tenPercentVal;
        score[idx] = score[idx] + myVal;

        if(tenPercentVal<1){
          break;
        }
      }
//      System.out.println("------");

    }

    return score;
  }

  public static void main(String[] args) {
    String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    String[] seller1 = {"young", "john", "tod", "emily", "mary"};
    int[] amount1 = {12, 4, 2, 5, 10};

    System.out.println(Arrays.toString(solution(enroll1, referral1, seller1, amount1)));

    String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    String[] seller2 = {"sam", "emily", "jaimie", "edward"};
    int[] amount2 = {2, 3, 5, 4};


    System.out.println(Arrays.toString(solution(enroll2, referral2, seller2, amount2)));

  }
}
