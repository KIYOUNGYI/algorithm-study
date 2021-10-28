package com.study.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 이 문제는 힌트 없었으면 못 풀었다.
 * <p>
 * https://programmers.co.kr/questions/20613
 */
public class Level2_가장_큰_수_v2 {

  //public static String solution(int[] numbers) {
  //
  //    int len = numbers.length;
  //    List<Integer> arrList = new ArrayList<>();
  //
  //    for (int i = 0; i < len; i++) {
  //      arrList.add(numbers[i]);
  //    }
  //
  //    Collections.sort(arrList, new MyComparator());
  //
  //    StringBuilder sb = new StringBuilder();
  //
  //    for (int i = 0; i < len; i++) {
  //      sb.append(arrList.get(i));
  //    }
  //
  //    return sb.toString();
  //  }
  //
  //    public static class MyComparator implements Comparator<Integer> {
  //
  //    @Override
  //    public int compare(Integer num1, Integer num2) {
  //
  //      int a = Integer.valueOf(Integer.toString(num1) + Integer.toString(num2));
  //      int b = Integer.valueOf(Integer.toString(num2) + Integer.toString(num1));
  //
  //      return a < b ? +1 : -1;
  //    }
  //  }

  public static String solution(int[] numbers) {

    int len = numbers.length;
    List<String> arrList = new ArrayList<>();

    for (int i = 0; i < len; i++) {
      arrList.add(String.valueOf(numbers[i]));
    }

    Collections.sort(arrList, new MyComparator());
//    System.out.println("arrList = " + arrList.toString());

    if (arrList.get(0).equals("0")) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len; i++) {
      sb.append(arrList.get(i));
    }

    return sb.toString();
  }


  public static void main(String[] args) {

//    int[] a1 = {6, 10, 2};
//    System.out.println(solution(a1));

    int[] a2 = {0, 0, 0};
    System.out.println(solution(a2));

//    List<Integer> arrList = new ArrayList<>();
//    arrList.add(6);
//    arrList.add(10);
//    arrList.add(2);
//    Collections.sort(arrList, new MyComparator());
//    System.out.println("arrList = " + arrList.toString());
  }

  public static class MyComparator implements Comparator<String> {

    @Override
    public int compare(String num1, String num2) {

      return (num1 + num2).compareTo(num2 + num1);
    }
  }

  //Comparator 작동하지 않은 것
  public static class MyComparatorV2 implements Comparator<Long> {

    @Override
    public int compare(Long num1, Long num2) {

      String x = Long.toString(num1) + Long.toString(num2);
      String y = Long.toString(num2) + Long.toString(num1);
      Long.valueOf(x);
      Long.valueOf(y);
      return (y + x).compareTo(x + y);
    }
  }
}
