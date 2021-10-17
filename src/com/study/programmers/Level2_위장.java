package com.study.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다른 풀이
 * https://programmers.co.kr/learn/courses/30/lessons/42578/solution_groups?language=java
 */
public class Level2_위장 {

  public static int solution(String[][] clothes) {

    Map<String, Integer> spyMap = new HashMap<>();

    for (int i = 0; i < clothes.length; i++) {

      String type = clothes[i][1];
//      String detail = clothes[i][1];

      if (!spyMap.containsKey(type)) {
        spyMap.put(type, 1);
      } else {
        int t = spyMap.get(type);
        spyMap.put(type, t + 1);
      }

    }

//    System.out.println(spyMap.toString());

    List<Integer> arrList = new ArrayList<>();

    for (Integer value : spyMap.values()) {
      arrList.add(value);
    }

    int v = 1;
    for (int i = 0; i < arrList.size(); i++) {
      v = v * (arrList.get(i)+1);
    }

    return v-1;
  }


  public static void main(String[] args) {

    String[][] input1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
    System.out.println(solution(input1));

        String[][] input2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
    System.out.println(solution(input2));

  }
}
