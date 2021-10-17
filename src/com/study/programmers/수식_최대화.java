package com.study.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 수식_최대화 {


  private static void splitStr(String input){
    String[] split = input.split("-");
    System.out.println("Arrays.toString(split) = " + Arrays.toString(split));
    List<String> arrList = new ArrayList<>();


  }

  public static void main(String[] args) {
    splitStr("100-200*300-500+20");
  }
}
