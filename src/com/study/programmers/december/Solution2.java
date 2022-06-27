package com.study.programmers.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2 {

  static String[] orderArr = new String[500_001];
  static Map<String, Integer> recipeMap = new HashMap<>();

  public static int solution(int n, String[] recipes, String[] orders) {

    for (int i = 0; i < orders.length; i++) {
      String[] s = orders[i].split(" ");
      orderArr[Integer.parseInt(s[1])] = s[0];
    }

    for (int i = 0; i < recipes.length; i++) {
      String[] s = recipes[i].split(" ");
      //      recipeMap.put()
      recipeMap.put(s[0], Integer.parseInt(s[1]));
    }

    List<Queue<String>> qList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      Queue<String> q = new LinkedList();
      qList.add(q);
    }

//    qList.get(0).add(order)


    int answer = 0;
    return answer;
  }


  public static void main(String[] args) {

    String[] receipes2 = {"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"};
    String[] orders2 = {"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"};
    System.out.println(solution(3, receipes2, orders2));
  }
}
