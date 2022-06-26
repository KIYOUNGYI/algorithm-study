package com.study.programmers;

import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class 완주하지_못한_선수 {


  public static String solution(String[] participant, String[] completion) {

    sort(participant);
    sort(completion);

    for (int i = 0; i < completion.length; i++) {
      String x = participant[i];
      String y = completion[i];
      if (!x.equals(y)) {
        return x;
      }
    }
    return participant[participant.length - 1];

  }

  public static String solutionBetter(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : participant) {
      hm.put(player, hm.getOrDefault(player, 0) + 1);
    }
    for (String player : completion) {
      hm.put(player, hm.get(player) - 1);
    }

    for (String key : hm.keySet()) {
      if (hm.get(key) != 0) {
        answer = key;
      }
    }
    return answer;
  }

  public static String solutionBad(String[] participant, String[] completion) {

    Map<String, Integer> map = new HashMap<>();

    for (String s : participant) {
      if (map.containsKey(s)) {
        Integer integer = map.get(s);
        map.put(s, integer + 1);
      } else {
        map.put(s, 1);
      }
    }
    System.out.println("map = " + map.toString());

    for (String s : completion) {
      if (map.containsKey(s)) {
        Integer integer = map.get(s);
        integer = integer - 1;
        if (integer == 0) {
          map.remove(s);
        } else {
          map.put(s, integer - 1);
        }
      }
    }

    for (String s : map.keySet()) {
      return s;
    }

    return null;
  }

  public static void main(String[] args) {
//    String[] s = {"mislav", "stanko", "mislav", "ana"};
//    String[] s2 = {"stanko", "ana", "mislav"};
//    System.out.println(solution(s, s2));
//
    String[] s3 = {"leo", "kiki", "eden"};
    String[] s4 = {"eden", "kiki"};
    System.out.println(solution(s3, s4));
  }
}
