package com.study.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

  public static String solution(String[] registered_list, String new_id) {

    List<String> arrList = new ArrayList<>();

    for (int i = 0; i < registered_list.length; i++) {
      arrList.add(registered_list[i]);
    }

    String tempId = new_id;

    Object[] objects = splitStr2(tempId);
    String s = (String) objects[0];
    int n = (int) objects[1];

    while (true) {

      if (!arrList.contains(tempId)) {
        break;
      } else {
        n = n + 1;
        tempId = s + String.valueOf(n);
//        System.out.println("tempId = " + tempId);

      }

    }

    return tempId;
  }

  public static Object[] splitStr(String input) {

    char[] charArr = input.toCharArray();

    int idx = 0;
    for (int i = 0; i < charArr.length; i++) {
      if (charArr[i] == '0' || charArr[i] == '1' || charArr[i] == '2' || charArr[i] == '3' || charArr[i] == '4' || charArr[i] == '5' || charArr[i] == '6' || charArr[i] == '7' || charArr[i] == '8'
          || charArr[i] == '9') {
        idx = i;
        break;
      }
    }

    String t1 = null;
    String t2 = null;
    int t3 = 0;
    if (idx == 0) {
      t1 = input;
      t3 = 0;
    } else {
      t1 = input.substring(0, idx);
      t2 = input.substring(idx, input.length());
      t3 = Integer.parseInt(t2);

    }
//    System.out.println("t1 = " + t1);
//    System.out.println("t3 = " + t3);
    Object[] objArr = new Object[2];
    objArr[0] = t1;
    objArr[1] = t3;

    return objArr;
  }

  public static Object[] splitStr2(String input) {

    String[] results = input.split("[0-9]");
    String[] results2 = input.split("[a-z]");
//    System.out.println("Arrays.toString(results2) = " + Arrays.toString(results2));
    Object[] objArr = new Object[2];
    objArr[0] = results[0];

    int t = 0;
    if(results2.length!=0){
      t = Integer.parseInt(results2[results2.length - 1]);
    }
    objArr[1] = t;

    return objArr;
  }

  public static void main(String[] args) {

//    String[] registeredList1 = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
//    String newId1 = "ace15";
////    splitStr("apple");
//    System.out.println(solution(registeredList1, newId1));

//    splitStr("cow");

//    String[] registeredList2 = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
//    String newId2 = "cow";
//    System.out.println(solution(registeredList2, newId2));

//    String[] registeredList3 = {"bird99", "bird98", "bird101", "gotoxy"};
//    String newId3 = "bird98";
//    System.out.println(solution(registeredList3, newId3));

//
//    String[] registeredList4 = {"apple1", "orange", "banana3"};
//    String newId4 = "apple";
//    System.out.println(solution(registeredList4,newId4));

//    String str = "abcde12345";
//    String[] results = str.split("[0-9]");
//    for (int i = 0; i < results.length; i++) {
//      System.out.println("results[" + i + "] = " + results[i]);
//    }
//
//    String[] results2 = str.split("[a-z]");
//    for (int i = 0; i < results2.length; i++) {
//      System.out.println("results[" + i + "] = " + results2[i]);
//    }

    splitStr2("apple123");
  }

}
