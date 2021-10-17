package com.study.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level2_전화번호_목록_오답_포함 {

  public static boolean solutionOtherPersonSolution(String[] phoneBook) {
    boolean answer = true;

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < phoneBook.length; i++) {
      map.put(phoneBook[i], i);
    }

    for (int i = 0; i < phoneBook.length; i++) {
      for (int j = 0; j < phoneBook[i].length(); j++) {
        if (map.containsKey(phoneBook[i].substring(0, j))) {//1234 (1,12,123,1234) 아...접두사니까....
          answer = false;
          return answer;
        }
      }
    }

    return answer;
  }


  //v2
  public static boolean solution(String[] phoneBook) {

    Arrays.sort(phoneBook);

    if (phoneBook.length == 2) {
      if (phoneBook[1].length() <= phoneBook[0].length() && phoneBook[1].startsWith(phoneBook[0])) {
        return false;
      }
    }

    for (int i = 1; i < phoneBook.length - 1; i++) {

      String pivot = phoneBook[i];
      String previous = phoneBook[i - 1];
      String next = phoneBook[i + 1];

      if (previous.startsWith(pivot) || pivot.startsWith(previous)) {
        return false;
      }

      if (pivot.startsWith(next) || next.startsWith(previous)) {
        return false;
      }
    }

    return true;
  }


  public static boolean solutionCommit1(String[] phoneBook) {

    Arrays.sort(phoneBook);

    if (phoneBook.length == 2) {
      if (phoneBook[1].length() <= phoneBook[0].length() && phoneBook[1].startsWith(phoneBook[0])) {
        return false;
      }
    }

    for (int i = 1; i < phoneBook.length - 1; i++) {
      String pivot = phoneBook[i];
      String previous = phoneBook[i - 1];
      String next = phoneBook[i + 1];

      if (pivot.length() <= previous.length()) {
        if (previous.startsWith(pivot)) {
          return false;
        }
      }

      if (pivot.length() >= previous.length()) {
        if (pivot.startsWith(previous)) {
          return false;
        }
      }

      if (pivot.length() >= next.length()) {
        if (pivot.startsWith(next)) {
          return false;
        }
      }
      if (next.startsWith(previous)) {
        return false;
      }
    }

    return true;
  }

  public static boolean solutionBackup(String[] phoneBook) {

    Arrays.sort(phoneBook);

    if (phoneBook.length == 2) {
      if (phoneBook[1].length() <= phoneBook[0].length() && phoneBook[1].startsWith(phoneBook[0])) {
        return false;
      }
    }

    for (int i = 1; i < phoneBook.length - 1; i++) {
      String pivot = phoneBook[i];
      String previous = phoneBook[i - 1];
      String next = phoneBook[i + 1];

      if (pivot.length() <= previous.length()) {
        if (previous.startsWith(pivot)) {
          return false;
        }
      }

      if (pivot.length() >= previous.length()) {
        if (pivot.startsWith(previous)) {
          return false;
        }
      }

      if (pivot.length() >= next.length()) {
        if (pivot.startsWith(next)) {
          return false;
        }
      }
      if (pivot.length() <= next.length()) {
        if (next.startsWith(previous)) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {

    String[] input1 = {"119", "97674223", "1195524421"};
    String[] input2 = {"123", "456", "789"};
    String[] input3 = {"12", "123", "1235", "567", "88"};
    String[] input4 = {"12", "123"};
    String[] input5 = {"1"};
    String[] input6 = {"12", "123", "13"};
    String[] input7 = {"101", "0"};
    boolean solution = solution(input7);
    System.out.println("solution = " + solution);

//    String a = "13";
//    String b = "123";
//    boolean contains = b.contains(a);
//    System.out.println(contains);

  }
}
