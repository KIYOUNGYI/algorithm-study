package com.study.programmers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Level2_1차_캐시 {

  public static int solution(int cacheSize, String[] cities) {

    Deque<String> q = new LinkedList<>();
    int score = 0;

    for (int i = 0; i < cities.length; i++) {

      String city = cities[i];
      city = city.toLowerCase();

      if (!q.contains(city)) {
        score += 5;
      } else {
        score += 1;
        q.remove(city);
        q.addLast(city);
      }
//      System.out.println("->"+q.size()+"cacheSize->"+cacheSize);
      if (!q.contains(city) && q.size() < cacheSize) {
        q.addLast(city);
      } else if (!q.contains(city) && q.size() == cacheSize) {

        if (cacheSize == 0) {
          continue;
        }

        q.poll();
        q.addLast(city);
      }
    }

    return score;
  }

  public static int solutionFailed1(int cacheSize, String[] cities) {

    Queue<String> q = new LinkedList<>();
    int score = 0;

    for (int i = 0; i < cities.length; i++) {

      String city = cities[i];
      city = city.toLowerCase();

      if (!q.contains(city)) {
        score += 5;
      } else {
        score += 1;
        q.remove(city);
        q.add(city);
      }

      if (!q.contains(city) && q.size() < cacheSize) {
        q.add(city);
      } else if (!q.contains(city) && q.size() == cacheSize) {
        q.poll();
        q.add(city);
      }
    }

    return score;
  }

  public static int solutionFailed2(int cacheSize, String[] cities) {

    Queue<String> q = new LinkedList<>();
    int score = 0;

    for (int i = 0; i < cities.length; i++) {

      String city = cities[i];
      city = city.toLowerCase();

      if (!q.contains(city)) {
        score += 5;
        if (q.size() < cacheSize) {
          q.add(city);
        } else if (q.size() == cacheSize) {
          q.poll();
          q.add(city);
        }
      } else {
        score += 1;
      }

      // if (!q.contains(city) && q.size() < cacheSize) {
      //   q.add(city);
      // } else if (!q.contains(city) && q.size() == cacheSize) {
      //   q.poll();
      //   q.add(city);
      // }
    }

    return score;
  }

  public static int solutionOtherPersonGoodSolution(int cacheSize, String[] cities) {
    int answer = 0;
    ArrayList<String> list = new ArrayList<String>();

    if (cacheSize == 0) {
      return cities.length * 5;
    }

    for (int i = 0; i < cities.length; i++) {
      cities[i] = cities[i].toUpperCase();

      if (list.contains(cities[i])) {
        answer++;
        list.remove(cities[i]);
        list.add(cities[i]);
      } else {
        answer += 5;
        if (list.size() == cacheSize) {
          list.remove(0);
          list.add(cities[i]);
        } else {
          list.add(cities[i]);
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {

//    int cacheSize = 3;
//    String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//    int solution = solution(cacheSize, cities);
//    System.out.println("solution = " + solution);

//    int cacheSize2 = 3;
//    String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//    System.out.println(solution(cacheSize2, cities2));

//    int cacheSize3 = 2;
//    String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//    System.out.println(solution(cacheSize3,cities3));

//    int cacheSize4 = 5;
//    String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//    System.out.println(solution(cacheSize4,cities4));

    int cacheSize5 = 0;
    String[] cities5 = {"Jeju", "Jeju"};
    System.out.println(solution(cacheSize5, cities5));

//    int cacheSize6 = 0;
//    String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//    System.out.println(solution(cacheSize6,cities6));
  }
}
