package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 여행경로 {

  static boolean flag = false;
  static List<Integer> answer = new ArrayList<>();
  static int limit;
  static List<Integer>[] arrayLists;
  static boolean[][] visit = new boolean[10_001][10_001];
  static List<String> cities = new ArrayList<>();
  static Integer start;
  static Map<String, Integer> cityMap = new HashMap<>();
  static Map<Integer, String> city2Map = new HashMap<>();
//  static List<String> damn = new ArrayList<>();


  public static String[] solution(String[][] tickets) {

    limit = tickets.length;

    for (int i = 0; i < tickets.length; i++) {
      String one = tickets[i][0];
      String two = tickets[i][1];

      if (!cities.contains(one)) {
        cities.add(one);
      }
      if (!cities.contains(two)) {
        cities.add(two);
      }
    }
    Collections.sort(cities);

    for (int i = 0; i < cities.size(); i++) {
      if (cities.get(i).equals("ICN")) {
        start = i;
      }
      cityMap.put(cities.get(i), i);
      city2Map.put(i, cities.get(i));
    }

    arrayLists = new List[cities.size()];

    for (int i = 0; i < arrayLists.length; i++) {
      arrayLists[i] = new ArrayList<>();
    }

    for (int i = 0; i < tickets.length; i++) {
      Integer cityStartIdx = cityMap.get(tickets[i][0]);
      Integer cityDestIdx = cityMap.get(tickets[i][1]);

      arrayLists[cityStartIdx].add(cityDestIdx);

    }

    for (int i = 0; i < cities.size(); i++) {
      Collections.sort(arrayLists[i]);
    }

//    printArrayList();
    System.out.println(start);
    answer.add(start);
    dfs(start, 1);

//    System.out.println("answer.size() = " + answer.size());
    String[] result = new String[answer.size()];
    for (int i = 0; i < answer.size(); i++) {
      String t2 = city2Map.get(answer.get(i));
      result[i] = t2;
    }

    return result;
  }

  private static void dfs(Integer val, int depth) {

    if (flag) {
      return;
    }

    if (depth == limit + 1) {
//      for (int i = 0; i < answer.size(); i++) {
//        System.out.print(city2Map.get(answer.get(i)) + " ");
////        damn.add(city2Map.get(answer.get(i)));
//      }
//      System.out.println("damn size : "+damn.size());
//      System.out.println("answer = " + answer.toString());
//      System.out.println();

      flag = true;
      return;
    }

    if (flag) {
      return;
    }

    List<Integer> destCities = arrayLists[val];
    int visitLen = destCities.size();

    for (int i = 0; i < visitLen; i++) {

      if (!visit[val][i]) {
        visit[val][i] = true;
        answer.add(destCities.get(i));
        dfs(destCities.get(i), depth + 1);
        if (flag) {
          return;
        }
        visit[val][i] = false;
        int answerLen = answer.size();
        answer.remove(answerLen - 1);
      }

    }

  }


  private static void printArrayList() {
    for (int i = 0; i < arrayLists.length; i++) {
      System.out.println(i + " " + arrayLists[i].toString());
    }

    for (int i = 0; i < arrayLists.length; i++) {
      System.out.print(i + " ");

      int size = arrayLists[i].size();
      for (int j = 0; j < size; j++) {
        System.out.print(visit[i][j] + " ");
      }
      System.out.println();


    }
  }

  public static void main(String[] args) {

//    String[][] str1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//    System.out.println(Arrays.toString(solution(str1)));
//
    String[][] str2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
    System.out.println(Arrays.toString(solution(str2)));
  }
}
