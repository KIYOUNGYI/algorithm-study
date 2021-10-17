package com.study.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {

  static int[] parent;

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

    int len = enroll.length;

    int[] score = new int[len];
    parent = new int[len];

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      map.put(enroll[i], i);
    }

    System.out.println(map.toString());
    for (int i = 0; i < len; i++) {
      if (!map.containsKey(referral[i])) {
        parent[i] = -1;
      } else {
        int idx = map.get(referral[i]);
        parent[i] = idx;
      }
    }

    for (int i = 0; i < seller.length; i++) {
      String sel = seller[i];
      int amt = amount[i];
//      System.out.println("seller : " + sel);
//      System.out.println("amt : " + amt);
      int idx = map.get(sel);

      int mok = amt * 100;
      int remainMok = (int) (mok * 0.1);

      int myMok = mok - remainMok;

//      System.out.println("myMok : " + myMok);
//      System.out.println("remainMok : " + remainMok);
      score[idx] = score[idx] + myMok;

      while (idx != -1) {

//        System.out.println("idx:" + idx);
        idx = parent[idx];
        if (idx == -1) {
          break;
        }

        mok = remainMok;
        remainMok = (int) (mok * 0.1);
        myMok = mok - remainMok;

//        System.out.println("\tmyMok : " + myMok);
//        System.out.println("\tremainMok : " + remainMok);

        score[idx] = score[idx] + myMok;

      }

//      System.out.println("-->" + Arrays.toString(score));

    }

    System.out.println(Arrays.toString(parent));

    return score;
  }

  public static void main(String[] args) {

//    String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//    String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//    String[] seller1 = {"young", "john", "tod", "emily", "mary"};
//    int[] amount1 = {12, 4, 2, 5, 10};
//
//    System.out.println(Arrays.toString(solution(enroll1, referral1, seller1, amount1)));

    String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    String[] seller2 = {"sam", "emily", "jaimie", "edward"};
    int[] amount2 = {2, 3, 5, 4};

    System.out.println(Arrays.toString(solution(enroll2, referral2, seller2, amount2)));

  }
}
