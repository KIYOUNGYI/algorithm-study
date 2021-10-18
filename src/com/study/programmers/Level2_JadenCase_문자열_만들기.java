package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_JadenCase_문자열_만들기 {


  public static String solution2(String s) {

    List<String> arrList = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<s.length();i++){

      sb.append(s.charAt(i));
      if(s.charAt(i)==' ' || i==s.length()-1){
        arrList.add(sb.toString());
        sb = new StringBuilder();
      }
    }

    System.out.println(arrList.toString());


    String[] arr2 = new String[arrList.size()];

    for (int i = 0; i < arrList.size(); i++) {

      String temp = arrList.get(i);
      for (int j = 0; j < temp.length(); j++) {
        if (j == 0) {
          sb.append(String.valueOf(temp.charAt(j)).toUpperCase());
        } else {
          sb.append(String.valueOf(temp.charAt(j)).toLowerCase());
        }
      }
      arr2[i] = sb.toString();
      sb = new StringBuilder();
    }

    System.out.println(Arrays.toString(arr2));

    StringBuilder sb2 = new StringBuilder();

    for(int i=0;i<arr2.length-1;i++){
      sb2.append(arr2[i]);
//      sb2.append(" ");
    }
      sb2.append(arr2[arr2.length-1]);

    return sb2.toString();
  }

  public static String solution(String s) {

    String[] arr = s.split(" ");


    String[] arr2 = new String[arr.length];

    for (int i = 0; i < arr.length; i++) {

      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < arr[i].length(); j++) {
        if (j == 0) {
          sb.append(String.valueOf(arr[i].charAt(j)).toUpperCase());
        } else {
          sb.append(String.valueOf(arr[i].charAt(j)).toLowerCase());
        }
      }
      arr2[i] = sb.toString();
    }

//    System.out.println(Arrays.toString(arr2));

    StringBuilder sb2 = new StringBuilder();

    for(int i=0;i<arr2.length-1;i++){
      sb2.append(arr2[i]);
      sb2.append(" ");
    }
    sb2.append(arr2[arr2.length-1]);

    return sb2.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution2("3people unFollowed me "));
  }
}
